package de.srendi.cctutorial.cctutorial;

import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.server.ServerLifecycleHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Our peripheral class, this is the class where we will register functions for our block.
 */
public class CCPeripheral implements IPeripheral {

    /**
     * A list of all our connected computers. We need this for event usages.
     */
    private final List<IComputerAccess> connectedComputers = new ArrayList<>();

    /**
     * This is our tile entity, we set the tile entity when we create a new peripheral. We use this tile entity to access the block or the world
     */
    private final CCTileEntity tileEntity;

    /**
     * @param tileEntity the tile entity of this peripheral
     */
    public CCPeripheral(CCTileEntity tileEntity) {
        this.tileEntity = tileEntity;
    }

    /**
     * We use getType to set the name for our peripheral. A modem would wrap our block as "test_n"
     *
     * @return the name of our peripheral
     */
    @Nonnull
    @Override
    public String getType() {
        return "test";
    }

    /**
     * CC use this method to check, if the peripheral in front of the modem is our peripheral
     */
    @Override
    public boolean equals(@Nullable IPeripheral iPeripheral) {
        return this == iPeripheral;
    }

    /**
     * Will be called when a computer disconnects from our block
     */
    @Override
    public void detach(@Nonnull IComputerAccess computer) {
        connectedComputers.remove(computer);
    }

    /**
     * Will be called when a computer connects to our block
     */
    @Override
    public void attach(@Nonnull IComputerAccess computer) {
        connectedComputers.add(computer);
    }

    public CCTileEntity getTileEntity() {
        return tileEntity;
    }

    /**
     * To register functions for our block, wee need to create final methods with the {@link LuaFunction} annotation
     * This function will send a message to every player on the Server
     */
    @LuaFunction
    public final void sendMessage(String message) {
        // Used to get the current server and all online players.
        ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers().forEach(player -> {
            // Now, send the message
            // To send a message, we need a Component(We use a TextComponent) and a sender UUID. We just pass an empty uuid in here
            player.sendMessage(new TextComponent(message), Util.NIL_UUID);
        });
    }

    /**
     * Because we want to access the world, we need to run this function on the main thread.
     */
    @LuaFunction(mainThread = true)
    public final boolean isRaining() {
        return getTileEntity().getLevel().getRainLevel(0) > 0;
    }

}

package de.srendi.cctutorial.cctutorial;

import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import static dan200.computercraft.shared.Capabilities.CAPABILITY_PERIPHERAL;

public class CCTileEntity extends TileEntity {

    public CCTileEntity() {
        super(Registration.CC_TILEENTITY.get());
    }

    /**
     * Our peripheral, we create a new peripheral for each new tile entity
     */
    protected CCPeripheral peripheral = new CCPeripheral(this);
    private LazyOptional<IPeripheral> peripheralCap;

    /**
     * When a computer modem tries to wrap our block, the modem will call getCapability to receive our peripheral.
     */
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction direction) {
        if (cap == CAPABILITY_PERIPHERAL) {
            if (peripheralCap == null) {
                peripheralCap = LazyOptional.of(() -> peripheral);
            }
            return peripheralCap.cast();
        }
        return super.getCapability(cap, direction);
    }
}

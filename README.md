# CC Tutorial
This is a little tutorial on how peripherals in cc work.
We use the simple system with the IPeripheral interface.

If you want to see, how I use this system with more functions and blocks, take a look at [Advanced Peripherals](https://github.com/Seniorendi/AdvancedPeripherals)

We create a peripheral with two functions:
* isRaining - a main thread function which will return true when it rains
* sendMessage - a function which will send a message to every player

## Supported Versions
- [1.19](https://github.com/Seniorendi/CCTutorial/tree/1.19)
- [1.18](https://github.com/Seniorendi/CCTutorial/tree/1.18)
- [1.16](https://github.com/Seniorendi/CCTutorial/tree/1.16)

## Content
* CCBlock - Our normal block, nothing special

* CCPeripheral - Our peripheral, here we register functions and manage connected computers

* Registration - Normal registration to register our blocks, items and so on

* CCTutorial - Our main class

* CCTileEntity - Our tile entity

* /src/main/resources/META-INF/mods.toml - Here we have our name of the mod, the mod id, the versiond and more. The most importang thing in the file is the modid and the dependencies for addons like cc-tweaked.

## Pictures

![Functions](https://intelligence-modding.de/wp-content/uploads/2022/04/Bild_2022-04-06_145710.png)

![Blocks](https://intelligence-modding.de/wp-content/uploads/2022/04/Bild_2022-04-06_145748.png)

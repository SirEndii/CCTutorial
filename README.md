# CC Tutorial
This is a little tutorial on how peripherals in cc works.
We use the simple system with the IPeripheral interface.

If you want to see, how I use this system with more functions and blocks, take a look at [Advanced Peripherals](https://github.com/Seniorendi/AdvancedPeripherals)

We create a peripheral with two functions:
* isRaining - a main thread function which will return true when it rains
* sendMessage - a function which will send a message to every player

## Content
* CCBlock - Our normal block, nothing special

* CCPeripheral - Our peripheral, here we register functions and manage connected computers

* Registration - Normal registration to register our blocks, items and so on

* CCTutorial - Our main class

* CCTileEntity - Our tile entity

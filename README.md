# Ender's Random Items Mod
A Minecraft mod with a bunch of random items, blocks, enchantments, and commands. Enjoy.

## Blocks

**Tesseract**: A block that when right-clicked gives you a potion effect. Think of it sort of like a mini beacon.

**Stone Torch**: Basically a torch made with stone rather than wood.

**Questionable Cheese**: Throw it on a beacon and see what happens, why don't you?

**Core**: My attempt at making another way of crafting things. To use it, you just place a block on top and right-click the core.

**Keycard Reader**: Goes with the keycard. It outputs a redstone signal when a player right-clicks it with a keycard matching its stored name.

**Dog Plushie**: Random plushie I spent way too long making AABBs for, and also the first model made by someone other than me.

## Items

**Moist Towelette**: A crafting item to be used with rotten flesh to make something slightly more edible.

**Puffballs**: Small 'foxes' that stay in your inventory and when held in your offhand give you various different potion effects.

**Iron Stone Chisel**: Used to create 4 stone sticks by right-clicking a stone block. It has 32 durability.

**Diamond Stone Chisel**: An upgraded version of the iron varient; it has 64 durability and crafts 8 stone sticks rather than 4.

**FLARD**: A lucky-block-like item that can be right-clicked to perform something random.

**Keycard**: Goes with the keycard reader. Renaming the item and shift-right-clicking a keycard reader you own will set the keycard reader's keycard name to the item's name.

**Sanitizing Water**: A crafting ingredient for the Moist Towelette.
**Puffball Fur**: A crafting ingredient for Puffballs.
**Puffball Tail**: Another crafting ingredient for Puffballs.
**Stone Stick**: A crafting ingredient for Stone Torches.

## Enchantments

**Anti Gravity**: Goes on boots, just gives you jump boost when wearing boots with it on them.

## Commands

**repair**: Repairs items. It has three args: 'mainhand', 'offhand' and 'all'.

**randomitems**: A command for testing parts of the mod. Currently it just lets you run FLARD effects.

## Other features include:

**Custom FLARD effects**: Used by FLARD to do something random, like a lucky block. You can create your own effects by extending FLARDEffect, and filling out the method runEffect() and (optionally) canRun(). Then you would want to register the effect by listening to the event RegistryEvent.Register&lt;FLARDEffect&gt;.
You can see the implementations for each effect [here](../master/src/main/java/net/enderturret/randomitems/flardeffects).
And you can look at the registration [here](../master/src/main/java/net/enderturret/randomitems/RandomItems.java) and [here](../master/src/main/java/net/enderturret/randomitems/init/ModFlardEffects.java).

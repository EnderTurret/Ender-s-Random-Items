# Ender's Random Items Mod
A Minecraft mod with a bunch of random items, blocks, enchantments, and commands. Enjoy.

## Blocks

**Tesseracts**: Blocks that when right-clicked give you a potion effect. Think of it sort of like a mini beacon.

**Stone Torch**: Basically a torch made with stone rather than wood.

**Questionable Cheese**: Throw it on a beacon.

**Core**: My attempt at making another way of crafting things. To use it, you just place a block on top and right-click the core.

**Keycard Reader**: Goes with the keycard. It outputs a redstone signal when a player right-clicks it with a keycard matching its stored name.

**Dog Plushie**: Random plushie I spent way too long making AABBs for. Also the first model made by someone other than me.

## Items

**Moist towelette**: A crafting item to be used with rotten flesh to make something slightly more edible.

**Puffballs**: Small 'foxes' that stay in your inventory and when held in your offhand give you different potion effects.

**Iron Stone Chisel**: Used to craft 4 stone sticks by right-clicking a stone block. Has 32 durability.

**Diamond Stone Chisel**: Same as the iron variant, except it has 64 durability and crafts 8 stone sticks instead.

**FLARD**: It's pretty much just a lucky block in item form.

**Invisible Armor**: It's really just normal vanilla armor but with the overlay absolutely covered in alpha.

**Keycard**: Goes with the keycard reader. Renaming the item and shift-clicking a keycard reader you own will set the reader's stored name to the keycard's name.

**Sanitizing water**: Crafting item.

**Puffball Fur**: Crafting item.

**Puffball Tail**: Crafting item.

**Stone Stick**: Crafting item.

## Enchantments

**Anti Gravity**: Goes on boots, just gives you jump boost when wearing boots with it on them.

**nVIDIA**: Really just a joke enchantment. It crashes your game for lols if you have an nVIDIA graphics card. It's disabled by default, you can enable it in the config.

## Commands

**repair**: Does exactly what you think it does. It has three args, 'mainhand', 'offhand' and 'all'.

## Other features include:

**Custom FLARD effects**: Utilized by FLARD to do something random, like a lucky block. You can create your own effects by extending FLARDEffect, and filling out the method runEffect() and (optionally) canRun(). Then you would want to register the effect by listening to the event RegistryEvent.Register&lt;FLARDEffect&gt;.
You can see the implementation for each effect [here](../master/src/main/java/net/enderturret/randomitems/flardeffects).
And you can look at the registration [here](../master/src/main/java/net/enderturret/randomitems/RandomItems) and [here](../master/src/main/java/net/enderturret/randomitems/init/ModFlardEffects).
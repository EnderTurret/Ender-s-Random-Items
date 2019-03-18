# Ender's Random Items Mod
A minecraft mod with the purpose of nothing whatsoever, it will contain several blocks and items that will do different things.

## Current items and blocks include:

**Tesseracts**: Blocks that when right-clicked give you a potion effect,
think of it sort of like a mini beacon.

**Moist towelette**: A crafting item to be used with rotten flesh to make something slightly more edible.

**Sanitizing water**: Crafting item.

**Puffballs**: Small 'foxes' that stay in your inventory and when held in your offhand give you special potion effects.

**Puffball Fur**: Crafting item.

**Puffball Tail**: Crafting item.

**Stone Stick**: Crafting item.

**Iron Stone Chisel**: Used to craft 4 stone sticks by right-clicking a stone block. Has 32 durability.

**Diamond Stone Chisel**: Same as the iron variant, except it has 64 durability and crafts 8 stone sticks instead.

**Stone Torch**: Basically a torch made with stone rather than wood.

**Questionable Cheese**: Throw it on a beacon.

**FLARD**: It is literally a lucky block in an item form.

**Core**: My attempt at making another way of crafting things. To use it, you just place a block on top and right-click the core.

**Invisible Armor**: It's really just normal vanilla armor but with the overlay absolutely covered in alpha.

**Keycard Reader**: Goes with the keycard. It outputs a redstone signal when a player right-clicks it with a keycard matching it's stored name.

**Keycard**: Goes with the keycard reader. Renaming the item and shift-clicking a keycard reader you own will set the reader's stored name to the keycard's.

**Dog Plushie**: Random plushie I spent way too long making AABBs for. Also the first model made by someone other than me.

## Enchantments

**Anti-Gravity**: Goes on boots, just gives you jump boost when wearing boots with it on them.

**nVIDIA**: Really just a joke enchantment. It crashes your game for lols if you have an nVIDIA graphics card. It's disabled by default, you can enable it in the config.

## Commands

**repair**: Does exactly what you think it does. It has two args, 'hand', and 'all'.

## Other features include:

**Custom FLARD effects**: Utilized by FLARD to do something random, kind of like a lucky block. You can create your own effects by
implementing AbstractFLARDEffect, and filling out the method onFLARDEffectRun. Then you would want to register the effect by calling the method
FLARDEffectRegistry.registerAll with an instance of your custom FLARD effect. For more information on how to make one, look at [one of these](../master/src/main/java/net/enderturret/randomitems/util/flardeffects)
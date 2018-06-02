# Ender's Random Items Mod
A minecraft mod with the purpose of nothing whatsoever, it will contain several blocks and items that will do different things.

##Current items and blocks include:

**Tesseracts**: Blocks that when right-clicked give you a potion effect,
think of it sort of like a mini beacon.

**Moist towelette**: A crafting item to be used with rotten flesh to make something slightly more edible.

**Sanitizing water**: Crafting item.

**Puffballs**: Small 'foxes' that stay in your inventory and when held in your offhand give you special potion effects.

**Stone Stick**: Crafting item.

**Stone Chisel**: Used to craft 6 stone sticks by right-clicking a stone block.

**Stone Torch**: Basically a torch made with stone rather than wood.

**Questionable Cheese**: Throw it on a beacon.

**FLARD**: It is literally a lucky block in an item form.

##Other features include:

**Custom FLARD effects**: Utilized by FLARD to do something random,
kind of like a lucky block. You can create your own effects by
implementing ICustomFLARDEffect, and filling out the method onFLARDEffectRun.
Then you would want to register the effect by calling the method
FLARDEffectRegistry.register with an instance of your custom FLARD effect.
If you have more than one you want to register, use FLARDEffectRegistry.registerAll.
For more information on how to make one, look at [one of these](../tree/master/src/main/java/net/enderturret/randomitems/util/flardeffects)
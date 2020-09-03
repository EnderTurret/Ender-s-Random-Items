package net.enderturret.randomitems.init;

import net.enderturret.randomitems.Reference;
import net.enderturret.randomitems.tileentity.KeycardReaderTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModTileEntities {

	private ModTileEntities() {}

	public static final DeferredRegister<TileEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Reference.MOD_ID);

	public static final RegistryObject<TileEntityType<?>> KEYCARD_READER_TYPE = REGISTRY.register("keycardreadertileentity", () -> TileEntityType.Builder.create(KeycardReaderTE::new).build(null));
}
package ink.ikx.rt.api.mods.cote.function.botania;

import crafttweaker.api.block.IBlockState;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.BlockPlacedBy")
public interface BlockPlacedBy {
    void call(IWorld world, IBlockPos pos, IBlockState state, IEntityLivingBase entity, IItemStack stack);
}

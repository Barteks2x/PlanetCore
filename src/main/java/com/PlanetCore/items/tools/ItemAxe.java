package com.PlanetCore.items.tools;

import com.PlanetCore.init.ModItems;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Set;

public class ItemAxe extends ItemTool {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);
    private static final float[] ATTACK_DAMAGES = new float[] {6.0F, 8.0F, 8.0F, 8.0F, 6.0F};
    private static final float[] ATTACK_SPEEDS = new float[] { -3.2F, -3.2F, -3.1F, -3.0F, -3.0F};

    protected ItemAxe(ModItems.ToolMaterialCustom material)
    {
        super(material, EFFECTIVE_ON);
        this.attackDamage = ATTACK_DAMAGES[material.ordinal()];
        this.attackSpeed = ATTACK_SPEEDS[material.ordinal()];
    }

    protected ItemAxe(ModItems.ToolMaterialCustom material, float damage, float speed)
    {
        super(material, EFFECTIVE_ON);
        this.attackDamage = damage;
        this.attackSpeed = speed;
    }

    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency;
    }

}
package io.github.terslenk.exlimus.utils;

import io.github.terslenk.exlimus.ExLimus;
import io.github.terslenk.exlimus.items.miscellaneous.CookedApple;
import io.github.terslenk.exlimus.items.miscellaneous.CookedWorm;
import io.github.terslenk.exlimus.items.tools.ReinforcedHammer;
import io.github.terslenk.exlimus.items.tools.StoneHammer;
import io.github.terslenk.exlimus.items.tools.WoodenKama;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



@UtilityClass
public final class Items {
    //TOOLS
    public static final SlimefunItemStack WOODEN_KAMA = new SlimefunItemStack(
            "WOODEN_KAMA",
            Material.WOODEN_HOE,
            "&f木钩",
            "",
            "&7一种可以用来收割树叶的工具"
    );
    public static final SlimefunItemStack STONE_HAMMER = new SlimefunItemStack(
            "STONE_HAMMER",
            Material.STONE_PICKAXE,
            "&f石锤",
            "",
            "&7一种可以用来粉碎方块的工具"
    );
    public static final SlimefunItemStack REINFORCED_HAMMER = new SlimefunItemStack(
            "REINFORCED_HAMMER",
            Material.IRON_PICKAXE,
            "&f强化锤",
            "",
            "&7石锤的强化版"
    );

    static {
        ItemMeta kamaMeta = WOODEN_KAMA.getItemMeta();
        kamaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        WOODEN_KAMA.setItemMeta(kamaMeta);
        WOODEN_KAMA.addEnchantment(Enchantment.SILK_TOUCH, 1);

        ItemMeta stoneHammerMeta = STONE_HAMMER.getItemMeta();
        stoneHammerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        STONE_HAMMER.setItemMeta(stoneHammerMeta);
        STONE_HAMMER.addEnchantment(Enchantment.DURABILITY, 1);

        ItemMeta reinforcedHammerMeta = REINFORCED_HAMMER.getItemMeta();
        reinforcedHammerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        REINFORCED_HAMMER.setItemMeta(reinforcedHammerMeta);
        REINFORCED_HAMMER.addEnchantment(Enchantment.DURABILITY, 2);
    }

    //MISC
    public static final SlimefunItemStack DUST = new SlimefunItemStack(
            "DUST",
            Material.CLAY,
            "&f粉末",
            "",
            "&7由沙子粉碎而成",
            "&7可将该粉末过筛"
    );
    public static final SlimefunItemStack WORM = new SlimefunItemStack(
            "WORM",
            Material.STRING,
            "&f蚕",
            "",
            "&7一种以桑叶为食的生物"
    );
    public static final SlimefunItemStack COOKED_WORM = new SlimefunItemStack(
            "COOKED_WORM",
            Material.STRING,
            "&f烤蚕蛹",
            "",
            "&7将蚕蛹在火上烤至金黄",
            "&7鸡肉味，嘎嘣脆！"
    );
    public static final SlimefunItemStack COOKED_APPLE = new SlimefunItemStack(
            "COOKED_APPLE",
            Material.APPLE,
            "&f烤苹果",
            "",
            "&7将苹果在火上烤制而成",
            "&7似乎比生苹果要好吃的多?"
    );
    //MACHINES

    public static void setup(ExLimus el){
        //TOOLS
        new StoneHammer(Categories.EL_TOOLS, STONE_HAMMER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE),
                null, new ItemStack(Material.STICK), new ItemStack(Material.STONE),
                new ItemStack(Material.STICK), null, new ItemStack(Material.STONE)}).register(el);

        new ReinforcedHammer(Categories.EL_TOOLS, REINFORCED_HAMMER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE),
                null, new ItemStack(Material.STICK), new ItemStack(Material.STONE),
                new ItemStack(Material.STICK), null, new ItemStack(Material.STONE)}).register(el);

        new WoodenKama(Categories.EL_TOOLS, WOODEN_KAMA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new ItemStack(Material.OAK_SLAB), new ItemStack(Material.STICK), null,
                null, new ItemStack(Material.STICK), null,
                null, new ItemStack(Material.STICK), null
        }).register(el);

        //MISC

        new CookedApple(Categories.EL_MISC, COOKED_APPLE, RecipeType.SMELTERY, new ItemStack[]{
                new ItemStack(Material.APPLE), null, null,
                null, null, null,
                null, null, null
        }).register(el);

        new CookedWorm(Categories.EL_MISC, COOKED_WORM, RecipeType.SMELTERY, new ItemStack[]{
                WORM, null, null,
                null,null,null,
                null,null,null
        }).register(el);

        new UnplaceableBlock(Categories.EL_MISC, WORM, RecipeTypes.KAMA_BREAK, new ItemStack[]{
                null, null, null,
                null,new CustomItemStack(Material.OAK_LEAVES,"&f匿于各色的树叶之中"),null,
                null,null,null
        }).register(el);

        new UnplaceableBlock(Categories.EL_MISC, DUST, RecipeTypes.HAMMER_BREAK, new ItemStack[]{
                null, null, null,
                null,new ItemStack(Material.SAND),null,
                null,null,null
        }).register(el);

    }
}
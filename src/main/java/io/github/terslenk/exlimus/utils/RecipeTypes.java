package io.github.terslenk.exlimus.utils;

import io.github.terslenk.exlimus.ExLimus;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;



@UtilityClass
public class RecipeTypes {
    public static final RecipeType HAMMER_BREAK = new RecipeType(new NamespacedKey(ExLimus.getAddon(), "hammer_break"), new CustomItemStack(Material.DIAMOND_PICKAXE,"&6用石锤粉碎","","&7可以通过打破特定的方块来收集该物品"));
    public static final RecipeType KAMA_BREAK = new RecipeType(new NamespacedKey(ExLimus.getAddon(), "kama_break"),new CustomItemStack(Material.WOODEN_HOE,"&6用木钩收割","","&7可以通过打破特定的方块来收集该物品"));
}

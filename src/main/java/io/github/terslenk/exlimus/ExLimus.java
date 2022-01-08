package io.github.terslenk.exlimus;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.terslenk.exlimus.items.StoneHammer;
import io.github.terslenk.exlimus.items.WoodenCrook;
import io.github.terslenk.exlimus.items.Worm;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ExLimus extends AbstractAddon {

    public ExLimus(){
        super("TerslenK", "Ex-Limus", "master", "auto-update");
    }

    @Override
    protected void enable() {
        setup();
    }

    @Override
    protected void disable() {
    }

    public void setup() {
        ItemGroup category = new ItemGroup(ExLimus.createKey("ex_limus_main"), new CustomItemStack(Material.BARREL, "&6Èx Limus"), 6);

    SlimefunItemStack ItemStack1 = new SlimefunItemStack("EXLIMUS_WOODEN_CROOK", Material.WOODEN_HOE, "&fWooden Crook", "", "&7An Item that let you get some Leaves and Saplings");

        new WoodenCrook(category, ItemStack1,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]  {
                new ItemStack(Material.STICK),new ItemStack(Material.STICK),null,
                null            ,             new ItemStack(Material.STICK),null,
                null            ,             new ItemStack(Material.STICK),null
        }).register(this);

    SlimefunItemStack ItemStack2 = new SlimefunItemStack("EXLIMUS_STONE_HAMMER", Material.STONE_PICKAXE, "&fStone Hammer", "","A Tool that helps you to get some gravel and sand.");

            new StoneHammer(category, ItemStack2,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]  {
                    null,new ItemStack(Material.COBBLESTONE),null,
                    null,new ItemStack(Material.STICK),new ItemStack(Material.COBBLESTONE),
                    new ItemStack(Material.STICK),null,null,
        }).register(this);

    SlimefunItemStack ItemStack3 = new SlimefunItemStack("EXLIMUS_WORM", Material.STRING, "&fWorm", "", "&7A creature that can be dropped by Wooden Crook.");

        new Worm(category, ItemStack3,RecipeType.NULL, new ItemStack[]  {
                null,null,null,
                null,null,null,
                null,null,null,
        }).register(this);

    }
}
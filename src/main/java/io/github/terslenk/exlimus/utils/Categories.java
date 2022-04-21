package io.github.terslenk.exlimus.utils;

import io.github.mooy1.infinitylib.groups.MultiGroup;
import io.github.mooy1.infinitylib.groups.SubGroup;
import io.github.terslenk.exlimus.ExLimus;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;

@UtilityClass
public class Categories {
    public static final ItemGroup EL_TOOLS = new SubGroup(
            "el_tools",
            new CustomItemStack(Material.DIAMOND_PICKAXE,
                    "&9工具")
    );
    public static final ItemGroup EL_MACHINES = new SubGroup(
            "el_machines",
            new CustomItemStack(Material.SCAFFOLDING,
                    "&5机器")
    );

    public static final ItemGroup EL_MISC = new SubGroup(
            "el_misc",
            new CustomItemStack(SlimefunItems.TIN_CAN,
                    "&a杂项")
    );

    public static final ItemGroup EL_VANILLA = new SubGroup(
            "el_vanilla",
            new CustomItemStack(Material.GRASS_BLOCK,
                    "&f原版物品"));

    public static final ItemGroup EL_MAIN = new MultiGroup(
            "el_main",
            new CustomItemStack(Material.BARREL,
                    "&6新手工具"),
            EL_TOOLS,EL_MACHINES,EL_MISC,EL_VANILLA
    );
    public static void setup(ExLimus el){
        EL_MAIN.register(el);
    }
}

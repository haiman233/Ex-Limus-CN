package io.github.terslenk.exlimus.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.DamageableItem;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.terslenk.exlimus.items.itemsid.Worm;


@SuppressWarnings("ALL")
public class WoodenCrook extends SimpleSlimefunItem<ToolUseHandler> implements NotPlaceable, DamageableItem {
    private static final int SAPLINGCHANCE = 25;
    private static final int WORMCHANCE = 100;
    public WoodenCrook(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

    }

    @Override
    public void preRegister() {
        ItemUseHandler blockUseHandler = this::onBlockRightClick;
        addItemHandler(blockUseHandler);
    }

    private void onBlockRightClick(PlayerRightClickEvent event) {
        event.cancel();
    }
    @Override
    public ToolUseHandler getItemHandler() {
        return (e, tool, fortune, drops) -> {
            damageItem(e.getPlayer(), tool);

            Material material = e.getBlock().getType();
            if (Tag.LEAVES.isTagged(material)) {
                int rollSapling = ThreadLocalRandom.current().nextInt(101);
                if (rollSapling < SAPLINGCHANCE) {
                    ItemStack sapling = new ItemStack(Objects.requireNonNull(Material.getMaterial(material.toString().replace("LEAVES", "SAPLING"))));
                    drops.add(sapling);
                }
                if (rollSapling < WORMCHANCE) {
                    drops.add(new CustomItemStack(Worm, 3));
                }
            }
        };
    }

    public boolean isDamageable() {
        return true;
    }
}


package io.github.terslenk.exlimus.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.inventory.ItemStack;

public class Worm extends SlimefunItem implements NotPlaceable {
    public Worm(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
}

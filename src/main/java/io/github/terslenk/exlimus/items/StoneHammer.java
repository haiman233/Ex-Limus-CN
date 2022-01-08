package io.github.terslenk.exlimus.items;

import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.DamageableItem;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.tags.SlimefunTag;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("ALL")
public class StoneHammer extends SimpleSlimefunItem<ToolUseHandler> implements NotPlaceable, DamageableItem {
    public StoneHammer(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
    public @Nonnull
    ToolUseHandler getItemHandler() {
        return (e, tool, fortune, drops) -> {
            Material mat = e.getBlock().getType();

            if (SlimefunTag.STONE_VARIANTS.isTagged(mat)) {
                if (Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_17)) {
                    switch(mat) {
                        case DEEPSLATE:
                            drops.add(new CustomItemStack(Material.GRAVEL, String.valueOf(1)));
                            break;
                        case COBBLED_DEEPSLATE:
                            drops.add(new CustomItemStack(Material.GRAVEL, String.valueOf(1)));
                            break;
                        default:
                            break;
                    }
                }

                switch(mat) {
                    case STONE:
                        drops.add(new CustomItemStack(Material.GRAVEL, String.valueOf(1)));
                        break;
                    case COBBLESTONE:
                        drops.add(new CustomItemStack(Material.GRAVEL, String.valueOf(1)));
                        break;
                    case DIORITE:
                        drops.add(new CustomItemStack(Material.GRAVEL, String.valueOf(1)));
                        break;
                    case ANDESITE:
                        drops.add(new CustomItemStack(Material.GRAVEL, String.valueOf(1)));
                        break;
                    case GRANITE:
                        drops.add(new CustomItemStack(Material.GRAVEL, String.valueOf(1)));
                        break;
                    default:
                        for (ItemStack drop : e.getBlock().getDrops(tool)) {
                            drops.add(new CustomItemStack(drop, drop.getAmount() * 2));
                        }
                        break;
                }
            }
        };
    }

    public boolean isDamageable() {
        return true;
    }
}


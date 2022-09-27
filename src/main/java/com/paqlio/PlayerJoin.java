package com.paqlio;

import com.hakan.core.HCore;
import com.hakan.core.npc.HNPC;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Paqlio
 * @since 27.09.2022 - 23:35
 **/



public class PlayerJoin implements Listener{


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        var player = event.getPlayer();
        event.setJoinMessage(color(""));
        create(player);

    }

    public void create(Player player) {
        String id = player.getName();
        Location location = player.getLocation();
        List<String> lines = Arrays.asList(color("&a&lSURVIVAL"));

        HNPC npc = HCore.npcBuilder(id)
                .showEveryone(false)
                .location(location)
                .lines(lines)
                .skin(player.getName())
                .build();

        npc.setEquipment(HNPC.EquipmentType.CHEST, new ItemStack(Material.DIAMOND_CHESTPLATE)); //sets chestplate of npc as diamond
        npc.setEquipment(HNPC.EquipmentType.LEGS, new ItemStack(Material.LEATHER_LEGGINGS)); //sets leggings of npc as leather
        npc.expire(15, TimeUnit.SECONDS); //our npc will remove in 15 seconds
        npc.addViewer(player);
    }
    private String color(String string) {
        return ChatColor.translateAlternateColorCodes('&',string);
    }
}
package me.billbominecraft.mordsheets.events;

import me.billbominecraft.mordsheets.utils.CharacterSheetUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionEvents implements Listener {

    private CharacterSheetUtil sheetUtil;

    public ConnectionEvents(CharacterSheetUtil sheetUtil){

        this.sheetUtil = sheetUtil;

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player joinPlayer = event.getPlayer();
        String uuid = joinPlayer.getUniqueId().toString();
        sheetUtil.loadSheet(uuid);
        sheetUtil.saveSheet(uuid);

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){

        Player leavePlayer = event.getPlayer();
        String uuid = leavePlayer.getUniqueId().toString();
        sheetUtil.saveSheet(uuid);
        sheetUtil.getSheetHashMap().remove(uuid);

    }

}

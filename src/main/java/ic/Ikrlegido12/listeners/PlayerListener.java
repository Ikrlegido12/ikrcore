package ic.Ikrlegido12.listeners;

import ic.Ikrlegido12.IkrCore;

import ic.Ikrlegido12.config.MainConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerListener implements Listener {

    private IkrCore plugin;

    public PlayerListener(IkrCore plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        String message = event.getMessage();
        if(message.toLowerCase().contains("aternos")){
            badMessage(event);
        } else if (message.toLowerCase().contains("fuck")) {
            badMessage(event);
        }
    }
    @EventHandler
    public void brokeBlocks(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().toString().equalsIgnoreCase("spawn") && !player.hasPermission("ikrcore.admin")){
            event.setCancelled(true);
            event.getPlayer().sendMessage(
                    ic.Ikrlegido12.utils.message.sendMsg("&cNo puedes romper bloques en el spawn."));
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        MainConfigManager mainConfigManager = plugin.getMainConfigManager();
        if(mainConfigManager.isWelcomeMessageEnabled()){
            List<String> message = mainConfigManager.getWelcomeMessageMessage();
            for(String m : message){
                player.sendMessage(ic.Ikrlegido12.utils.message.sendMsgWoP(m.replace("%player%", player.getName())));
            }
        }

        Location location = new Location(Bukkit.getWorld("spawn"), 0, -59,0,0,0);
        event.getPlayer().teleport(location);

    }

    public void badMessage(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        event.setCancelled(true);
        player.sendMessage(ic.Ikrlegido12.utils.message.sendMsg(plugin.getMainConfigManager().getPreventBlockBreak()));
    }


}

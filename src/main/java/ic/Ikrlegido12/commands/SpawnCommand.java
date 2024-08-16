/* package ic.Ikrlegido12.commands;

import ic.Ikrlegido12.IkrCore;
import ic.Ikrlegido12.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import static org.bukkit.Bukkit.getWorld;

public class SpawnCommand implements CommandExecutor {
    private IkrCore plugin;

    public SpawnCommand(IkrCore plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)){
            //Console
            sender.sendMessage(message.sendMsg("&fEste mensaje fue recibido por la consola."));
            return true;

        }
        Player player = (Player) sender;
        Bukkit.getPlayer(player);
        return false;
    }
    public void teleportToSpawn(PlayerTeleportEvent event, Player player){
        teleport(player getWorld("spawn"), 0, -59,0);
    }
} */

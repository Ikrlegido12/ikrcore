package ic.Ikrlegido12.commands;

import ic.Ikrlegido12.IkrCore;
import ic.Ikrlegido12.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    private final IkrCore plugin;

    public FlyCommand(IkrCore plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(sender.hasPermission("ikrcore.fly")){
            sender.sendMessage(message.sendMsg("&cNo tienes permisos para usar este comando."));
            return true;
        }

        Player player = null;
        if(args.length == 1){
            if(sender instanceof Player){
                player = (Player)sender;
            } else {
                sender.sendMessage(message.sendMsg("&cDebes especificar una persona."));
                return true;
            }
        } else {
            player = Bukkit.getPlayer(args[1]);
            if(player == null){
                sender.sendMessage(message.sendMsg("&cJugador no conectado."));
                return true;
            }
        }

        if(player.getAllowFlight()){
            if(!player.equals(sender)){
                sender.sendMessage(message.sendMsg("&cModo de vuelo desactivado para&3 "+player.getName()+"&c."));
            }
            player.sendMessage(message.sendMsg("&cModo de vuelo desactivado."));

            player.setAllowFlight(false);
        } else {
            if(!player.equals(sender)){
                sender.sendMessage(message.sendMsg("&aModo de vuelo activado para&3 "+player.getName()+"&a."));
            }
            player.sendMessage(message.sendMsg("&aModo de vuelo activado."));

            player.setAllowFlight(true);
        }

        return true;

    }
}

















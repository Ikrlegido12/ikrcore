package ic.Ikrlegido12.commands;

import ic.Ikrlegido12.IkrCore;
import ic.Ikrlegido12.utils.message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class XpCommand implements CommandExecutor {
    private final IkrCore plugin;

    public XpCommand(IkrCore plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(sender.hasPermission("ikrcore.xp")){
            sender.sendMessage(message.sendMsg("&cNo tienes permisos para usar este comando."));
            return true;
        }
        if (args.length == 0){
            sender.sendMessage(message.sendMsg("&cDebes usar: &f/experiencia <cantidad> (jugador)"));
            return true;
        }

        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(args[0]);
            if(cantidad <= 0){
                sender.sendMessage(message.sendMsg(plugin.getMainConfigManager().getInvalidNumber()));
                return true;
            }
        } catch(NumberFormatException e){
            sender.sendMessage(message.sendMsg(plugin.getMainConfigManager().getInvalidNumber()));
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
        player.giveExp(cantidad);
        player.sendMessage("&aHas recibido &e"+cantidad+"&a de experiencia.");
        sender.sendMessage("&aHas enviado &e"+cantidad+"&a de experiencia a &b"+player.getName());
        return true;


    }
}

















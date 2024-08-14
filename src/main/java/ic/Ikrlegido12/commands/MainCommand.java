package ic.Ikrlegido12.commands;

import ic.Ikrlegido12.IkrCore;
import ic.Ikrlegido12.utils.message;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainCommand implements CommandExecutor {

    private IkrCore plugin;

    public MainCommand(IkrCore plugin){
        this.plugin = plugin;
    }

    private static String prefix = "&7[&cIkrCore&7] ";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)){
            //Consola
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&fEste mensaje fue recibido por la consola."));
            return true;

        }
        // Jugador
        Player player = (Player) sender;
        if(args.length >= 1){
            if(args[0].equalsIgnoreCase("bienvenida")){
                // Bienvenida
                sender.sendMessage(message.sendMsg("&fBienvenido &b"+ player.getName()));
            } else if(args[0].equalsIgnoreCase("fecha")){
                // La fecha
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String date = dateFormat.format(new Date());
                sender.sendMessage(message.sendMsg("&dFecha y hora de hoy &7(dd/MM/yyyy HH:mm:ss)&d: "));
                sender.sendMessage(message.sendMsg("&e" + date));

            } else if(args[0].equalsIgnoreCase("get")){
                subCommandGet(sender, args);
            } else if(args[0].equalsIgnoreCase("help")){
                help(sender);
            } else if(args[0].equalsIgnoreCase("reload")){
                subCommandReload(sender);
            }

        }else{
            help(sender);
        }




        return true;
    }

    public void help(CommandSender sender) {
        sender.sendMessage(message.sendMsg("&a+++++++++++++++++COMANDOS+++++++++++++++++"));
        sender.sendMessage(message.sendMsg("&f/ikrcore &b- &eMuestra este menu."));
        sender.sendMessage(message.sendMsg("&f/ikrcore fecha &b- &eMuestra la hora."));
        sender.sendMessage(message.sendMsg("&f/ikrcore bienvenida&b- &eTe da la bienvenida."));
        sender.sendMessage(message.sendMsg("&f/ikrcore get &b- &eObtiene informacion."));
        sender.sendMessage(message.sendMsg("&a+++++++++++++++++COMANDOS+++++++++++++++++"));
    }
    public void subCommandGet(CommandSender sender,String[] args){
        if(args.length == 1){
            sender.sendMessage(message.sendMsg("&cFaltan argumentos.&e Usa <author/version/description>"));

        } else {
            if(args[1].equalsIgnoreCase("author")){
                sender.sendMessage(message.sendMsg("&fEl autor(es) de este plugin es:&b " + plugin.getDescription().getAuthors()));
            } else if(args[1].equalsIgnoreCase("version")) {
                sender.sendMessage(message.sendMsg("&fVersion del plugin: &b"+ plugin.getDescription().getVersion()));
            } else if (args[1].equalsIgnoreCase("description")) {
                sender.sendMessage(message.sendMsg("&fDescripcion: &b" + plugin.getDescription().getDescription()));
            } else {

            }
        }

    }
    public void subCommandReload(CommandSender sender) {
        if (!sender.hasPermission("ikrcore.admin")) {
            sender.sendMessage(message.sendMsg("&cNo tienes permisos para usar este comando."));
            return;
        }
        plugin.getMainConfigManager().reloadConfig();
        sender.sendMessage(message.sendMsg("&aConfiguración recargada."));
    }



}

package ic.Ikrlegido12.utils;

import ic.Ikrlegido12.IkrCore;
import org.bukkit.ChatColor;

public class message {
    private static IkrCore plugin;

    private static String prefix = plugin.getMainConfigManager().getPrefix();
    public static String sendMsg(String Message){
        return ChatColor.translateAlternateColorCodes('&',prefix + " " + Message);
    }
    public static String sendMsgWoP(String Message){
        return ChatColor.translateAlternateColorCodes('&', Message);
    }

}

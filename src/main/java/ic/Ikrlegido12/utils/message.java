package ic.Ikrlegido12.utils;

import org.bukkit.ChatColor;

public class message {
    private static String prefix = "&7[&cIkrCore&7] ";
    public static String sendMsg(String Message){
        return ChatColor.translateAlternateColorCodes('&',prefix + Message);
    }
    public static String sendMsgWoP(String Message){
        return ChatColor.translateAlternateColorCodes('&', Message);
    }

}

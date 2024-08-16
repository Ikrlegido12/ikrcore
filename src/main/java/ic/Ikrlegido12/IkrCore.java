package ic.Ikrlegido12;

import ic.Ikrlegido12.commands.FlyCommand;
import ic.Ikrlegido12.commands.MainCommand;

import ic.Ikrlegido12.commands.XpCommand;
import ic.Ikrlegido12.config.MainConfigManager;
import ic.Ikrlegido12.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class IkrCore extends JavaPlugin {


    private String version = getDescription().getVersion();
    public static String prefix = "&7[&cIkrCore&7] ";
    private MainConfigManager mainConfigManager;

    public void onEnable(){
        registerCommands();
        registerEvents();
        mainConfigManager = new MainConfigManager(this);
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes(
                        '&',prefix + "&fEl plugin &b&lIkrCore &fha sido &ehabilitado&f correctamente. (Version "+ version + ")"));
    }
    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes(
                        '&', prefix + "&fEl plugin &b&lIkrCore &fha sido &edeshabilitado&f correctamente. (Version " + version +")"));
    }

    public void registerCommands(){
        this.getCommand("ikrcore").setExecutor(new MainCommand(this));
        this.getCommand("volar").setExecutor(new FlyCommand(this));
        this.getCommand("experiencia").setExecutor(new XpCommand(this));
        //this.getCommand("spawn").setExecutor(new SpawnCommand(this));
    }
    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerListener(this),this);
    }
    public MainConfigManager getMainConfigManager() {
        return mainConfigManager;
    }
}














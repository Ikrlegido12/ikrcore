package ic.Ikrlegido12.config;

import ic.Ikrlegido12.IkrCore;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;


public class MainConfigManager {

    private CustomConfig configFile;
    private IkrCore plugin;

    private String preventBlockBreak;
    private String prefix;
    private boolean welcomeMessageEnabled;
    private List<String> welcomeMessageMessage;

    public MainConfigManager(IkrCore plugin){
        this.plugin = plugin;
        configFile = new CustomConfig("config.yml",null,plugin,false);
        configFile.registerConfig();
        loadConfig();
    }

    public void loadConfig(){
        FileConfiguration config = configFile.getConfig();
        prefix = config.getString("messages.prefix");
        preventBlockBreak = config.getString("messages.prevent_block_break");
        welcomeMessageEnabled = config.getBoolean("config.welcome_message.enabled");
        welcomeMessageMessage = config.getStringList("config.welcome_message.message");
    }

    public void reloadConfig(){
        configFile.reloadConfig();
        loadConfig();
    }
    public String getPrefix() {
        return prefix;
    }
    public String getPreventBlockBreak() {
        return preventBlockBreak;
    }

    public boolean isWelcomeMessageEnabled() {
        return welcomeMessageEnabled;
    }

    public List<String> getWelcomeMessageMessage() {
        return welcomeMessageMessage;
    }
}
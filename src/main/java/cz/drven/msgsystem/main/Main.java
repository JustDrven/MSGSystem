package cz.drven.msgsystem.main;

import cz.drven.msgsystem.main.Commands.MSGCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            getCommand("msg").setExecutor(new MSGCommand());
            getServer().getConsoleSender().sendMessage("§8[§aMSG§8] §aPlugin enable!");
        } catch (Exception ex) {
            getServer().getConsoleSender().sendMessage("§8[§aMSG§8] §cError");
        }
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§8[§aMSG§8] §cPlugin disable");
        HandlerList.unregisterAll();
    }

    public static void msg(Player p, Player target, String msg) {
        p.sendMessage("§8[§aMSG§8] §e"+target.getName()+" §c§l>> §f"+ ChatColor.translateAlternateColorCodes('&', msg));
        target.sendMessage("§8[§aMSG§8] §e"+p.getName()+" §c§l>> §f"+ ChatColor.translateAlternateColorCodes('&', msg));
    }
}

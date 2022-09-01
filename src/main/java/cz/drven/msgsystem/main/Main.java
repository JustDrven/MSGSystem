package cz.drven.msgsystem.main;

import cz.drven.msgsystem.main.Commands.MSGCommand;
import cz.drven.msgsystem.main.Commands.SpyCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    public static List<Player> spy = new ArrayList<Player>();

    @Override
    public void onEnable() {
        try {
            getCommand("spy").setExecutor(new SpyCommand());
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
        for (Player spyplayers : spy) {
            spyplayers.sendMessage("§8[§aSPY§8] §e"+p.getName()+" §c§l>> §c"+target.getName()+" §8- " + ChatColor.translateAlternateColorCodes('&', msg));
        }
    }
}

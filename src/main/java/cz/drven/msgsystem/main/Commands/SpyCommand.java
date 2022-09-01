package cz.drven.msgsystem.main.Commands;

import cz.drven.msgsystem.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("spy.use")) {
            if (args.length == 0) {
                if (!Main.spy.contains(p)) {
                    Main.spy.add(p);
                    p.sendMessage("§8[§aSPY§8] §7MSGSpy was activated");
                } else {
                    Main.spy.remove(p);
                    p.sendMessage("§8[§aSPY§8] §7MSGSpy was deactivated");
                    return false;
                }
            } else {
                p.sendMessage("§8[§aSPY§8] §7Usage: §e/spy");
            }
        } else {
            p.sendMessage("§cYou're not allowed to do this!");
        }
        return true;
    }
}

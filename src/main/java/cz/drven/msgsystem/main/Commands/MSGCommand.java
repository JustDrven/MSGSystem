package cz.drven.msgsystem.main.Commands;

import cz.drven.msgsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSGCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("msg.use")) {
            if (args.length == 1 || args.length == 0) {
                p.sendMessage("§8[§aMSG§8] §7Usage: §e/msg <player> <msg>");
                return false;
            }
            String str = "";
            for (int i = 1; i < args.length; i++) {
                str = str + args[i] + " ";
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                Main.msg(p, target,
                        str.trim());
            } else {
                p.sendMessage("§8[§aMSG§8] §cPlayer "+target
                        .getName()+" is offline!");
            }
        } else {
            p.sendMessage("§cYou're not allowed to do this!");
        }
        return true;
    }
}

package me.loremente.punishtool;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

public class PunishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender CommandSender, Command command, String label, String[] args) {

        if (CommandSender instanceof Player) {
            Player player = (Player) CommandSender;

            if (args.length == 2) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);

                    switch (args[0].toLowerCase()) {
                        case "kick":
                            target.kickPlayer(ChatColor.GREEN + "You have kick a that player.");
                            break;
                        case "ban":
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "You have banned", null, null);
                            target.kickPlayer(ChatColor.GREEN + "You have ban that player.");
                            break;
                        case "tempban":
                            Calendar cal = Calendar.getInstance();

                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "You have banned", cal.getTime(), null);
                            target.kickPlayer(ChatColor.GREEN + "You have tempbanned that player.");
                            break;
                        default:
                            player.sendMessage(ChatColor.RED + "You did not specify the player to be banned");
                            return false;

                    }

                } else {
                    player.sendMessage(ChatColor.RED + "Player is offline");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Usage /punish <Player> <kick/ban/tempban>.");

            }
        }

        return false;
    }
}

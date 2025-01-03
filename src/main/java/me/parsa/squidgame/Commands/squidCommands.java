package me.parsa.squidgame.Commands;

import me.parsa.squidgame.SquidGame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class squidCommands implements CommandExecutor {

    private SquidGame sq;

    public squidCommands(SquidGame sq) {
        this.sq = sq;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("sq")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.LIGHT_PURPLE + "SquidGame v" + sq.getDescription().getVersion() + " Running on bukkit by " + sq.getDescription().getAuthors());
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}

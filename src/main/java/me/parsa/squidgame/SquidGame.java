package me.parsa.squidgame;




import me.parsa.squidgame.Commands.squidCommands;
import me.parsa.squidgame.Database.PointDatabase;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
//ds


public final class SquidGame extends JavaPlugin implements Listener, CommandExecutor {


    private BukkitAudiences adventure;

    private PointDatabase pointDatabase;

    public @NotNull BukkitAudiences adventure() {
        if(this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {
        getCommand("sq").setExecutor(new squidCommands(this));
        try {

            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }

            pointDatabase = new PointDatabase(getDataFolder().getAbsolutePath() + "/squidgame.db");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect to the database! " + ex.getMessage());
            Bukkit.getPluginManager().disablePlugin(this);
        }

    }


    @Override
    public void onDisable() {
        try {
            pointDatabase.closeConection();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }



}

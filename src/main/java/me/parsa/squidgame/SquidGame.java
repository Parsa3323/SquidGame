package me.parsa.squidgame;




import me.parsa.squidgame.Commands.squidCommands;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
//ds


public final class SquidGame extends JavaPlugin implements Listener, CommandExecutor {


    private BukkitAudiences adventure;

    public @NotNull BukkitAudiences adventure() {
        if(this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {
        getCommand("sq").setExecutor(new squidCommands(this));

    }


    @Override
    public void onDisable() {

    }



}

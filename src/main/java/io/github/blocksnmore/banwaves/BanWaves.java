package io.github.blocksnmore.banwaves;


import java.util.ArrayList;
import java.util.List;
import io.github.blocksnmore.banwaves.*;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@SuppressWarnings("unused")
public class BanWaves {
	private static String plugin;
	public static FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin(plugin).getConfig();
	public static void runBan() {
		String cmd;
		cmd = config.getString("banwave1");
		int i = 0;
		while (i-1 < Main.banwaveUsers.size()) {
		  runbancmd(cmd, Main.banwaveUsers.get(i));
		  i++;
		}
	}
	public static void banAdd(String p) {
		Main.banwaveUsers.add(p);
	}
	public static void banRem(String p) {
		Main.banwaveUsers.remove(p);
	}
	
	public static void runbancmd(String c, String p) {
		String command;
		command = c.replace("%user%", p);
		//Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
	}

}

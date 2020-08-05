package io.github.blocksnmore.banwaves;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.blocksnmore.banwaves.*;

@SuppressWarnings("unused")
public class Main extends JavaPlugin{
	static List<String> banwaveUsers = new ArrayList<String>();
	public FileConfiguration config = getConfig();
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			sender.sendMessage(ChatColor.GREEN+"Banwaves, A plugin by Blocks_n_more#5526");
		}else {
			if(!sender.hasPermission("banwave.use")) {
				sender.sendMessage(ChatColor.RED+"You do not have permission to use this!");
			}else {
				switch(args[0].toLowerCase()) {
				case "add":
					if(args.length == 1) {
						sender.sendMessage(ChatColor.RED+"You need to provide a player!");
					}else {
						if(sender.hasPermission("banwave.use")) {
							BanWaves.banAdd(args[1]);
							sender.sendMessage(ChatColor.GREEN+"Added the user!");
						}else {
							sender.sendMessage(ChatColor.RED+"You do not have permission to use this!");
						}
					}
					break;
				case "rem":
					if(args.length == 1) {
						sender.sendMessage(ChatColor.RED+"You need to provide a player!");
					}else {
						if(sender.hasPermission("banwave.use")) {
							BanWaves.banRem(args[1]);
							sender.sendMessage(ChatColor.GREEN+"Removed the user!");
						}else {
							sender.sendMessage(ChatColor.RED+"You do not have permission to use this!");
						}
					}
					break;
				case "test":
						banwaveUsers.add(args[1]);
				case "run":
					if(sender.hasPermission("banwave.run")) {
						sender.sendMessage(ChatColor.GREEN+"Executing banwave");
						BanWaves.runBan();
					}else {
						sender.sendMessage(ChatColor.RED+"You do not have permission to use this!");
					}
					break;
				default:
					sender.sendMessage(ChatColor.GREEN+"Current commands: Help Add Run Rem");
					break;
				}
			}
		}
		return false;
	}
	@Override
	public void onEnable() {
		System.out.println("Thanks for using my banwaves plugin! It will now activate");
		saveDefaultConfig();
	}
	@Override
	public void onDisable() {
		//BanWaves.runBan();
		System.out.println("Shutting down! Thanks for using banwaves");
	}
}

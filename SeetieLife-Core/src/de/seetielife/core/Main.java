package de.seetielife.core;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.seetielife.core.commands.CleanerCommand;
import de.seetielife.core.commands.InfoCommand;
import de.seetielife.core.listener.ReloadNachricht;

public class Main extends JavaPlugin {
	
	public static String pre = "§7[§4Seetielife.de§7] §b";
	public static String farbe = "§b ";
	public static String noperm = pre + "§bDafür hast du keine Berechtigungen!";
	public static String noplayer = "Du bist eine Konsole. Die darf das nicht :/";
	public static String falsch = pre + "§bDu hast den Command falsch genutzt!";
	
	@Override
	public void onDisable(){
		System.out.println("[Seetielife-Core] Das Plugin wurde deaktiviert!");
	}

	@Override
	public void onEnable(){
		System.out.println("[Seetielife-Core] Das Plugin wird geladen...");
		
		new File("plugins/SeetieLife").mkdirs();
		new File("plugins/SeetieLife/Spieler").mkdirs();
		new File("plugins/SeetieLife/Homes").mkdirs();
		new File("plugins/SeetieLife/Spawns").mkdirs();
		new File("plugins/SeetieLife/Permissions").mkdirs();
		new File("plugins/SeetieLife/Money").mkdirs();
		
		
		registerCommands();
		registerEvents();
		
	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ReloadNachricht(), this);
	}

	private void registerCommands() {
		getCommand("info").setExecutor(new InfoCommand());
		getCommand("cc").setExecutor(new CleanerCommand());
	}
}

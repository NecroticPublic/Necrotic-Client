package org.necrotic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

import org.necrotic.client.tools.Misc;

/**
 * The client's features can easily be toggled/changed here.
 * @author Gabriel Hannason
 */
public class Configuration {
	
	private static boolean FORCE_ONLINE = false;
	public static final boolean FORCE_CACHE_UPDATE = false;
	public static final boolean STOP_CACHE_UPDATES = false; //overrides the above
	
	/** LOADS CACHE FROM ./ IF TRUE, OTHERWISE USER.HOME FOLDER**/
	public static final boolean DROPBOX_MODE = false;
	
	/** MAIN CONSTANTS **/
	public final static String CLIENT_NAME = "Necrotic";
	public final static int CLIENT_VERSION = 55;
	public final static String CACHE_DIRECTORY_NAME = "NecroticCache"; //Cache folder name
	public static final String SETTINGS_DIRECTORY_NAME = "NecroticSettings";
	
	public final static boolean JAGCACHED_ENABLED = false;
	public final static String JAGCACHED_HOST  = "";

	public final static int SERVER_PORT = 43594;
	public final static boolean DISPLAY_GAMEWORLD_ON_LOGIN = false;
	
	/** UPDATING **/
	public final static int NPC_BITS = 18;

	
	/** FEATURES **/
	public static boolean SAVE_ACCOUNTS = false;
	public static boolean DISPLAY_HP_ABOVE_HEAD = false;
	public static boolean DISPLAY_USERNAMES_ABOVE_HEAD = false;
	public static boolean TWEENING_ENABLED = true;
	
	public static boolean NEW_HITMARKS = true;
	public static boolean CONSTITUTION_ENABLED = false;
	public static boolean NEW_HEALTH_BARS = true;
	
	public static boolean MONEY_POUCH_ENABLED = false;
	public static boolean SMILIES_ENABLED = false;
	public static boolean NOTIFICATIONS_ENABLED = false;
	public static boolean HIGHLIGHT_USERNAME = true;
	public static boolean NEW_CURSORS = false;
	public static boolean NEW_FUNCTION_KEYS = true;
	
	public static boolean FOG_ENABLED = false;
	public static boolean GROUND_TEXT = true;
	/**
	 * The client will run in high memory with textures rendering
	 */
	public static boolean HIGH_DETAIL = false;
	public static boolean hdTexturing = false;
	public static boolean hdMinimap = false;
	public static boolean hdShading = false;
	
	/**
	 * Roofs should be displayed
	 */
	public static boolean TOGGLE_ROOF_OFF = true;

	/**
	 * Should the new fov be displayed?
	 */
	public static boolean TOGGLE_FOV = true;
	
	public final static String SERVER_HOST() {
		//return "world1.necrotic.org"; // your live server's IP

		return "localhost"; // your local server's IP
	}

}
package org.necrotic.client.Settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.necrotic.Configuration;
import org.necrotic.client.Client;
import org.necrotic.client.Signlink;
import org.necrotic.client.constants.GameFrameConstants;
import org.necrotic.client.graphics.gameframe.GameFrame;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Brandon on 7/28/2017.
 */
public class Save {

    public static void settings(Client client) {
//    File file = new File(Signlink.getSettingsDirectory() + "/settings.json");
        Path path = Paths.get(Signlink.getSettingsDirectory(), "/settings.json");
        File file = path.toFile();
        file.getParentFile().setWritable(true);
        System.out.println("Save.Settings() called");

        if(!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                System.out.println("making settings directory.");
            } catch (SecurityException e) {
                System.out.println("Unable to create directory for settings!");
            }
        }
        try (FileWriter writer = new FileWriter(file)) {
            System.out.println("writting settings.json");
            Gson builder = new GsonBuilder().setPrettyPrinting().create();
            JsonObject object = new JsonObject();

            object.addProperty("save-accounts", Configuration.SAVE_ACCOUNTS);
            object.addProperty("new-f-keys", Configuration.NEW_FUNCTION_KEYS);
            object.addProperty("new-hp-bars", Configuration.NEW_HEALTH_BARS);
            object.addProperty("new-hitmark", Configuration.NEW_HITMARKS);
            object.addProperty("constitution", Configuration.CONSTITUTION_ENABLED);
            object.addProperty("new-cursor", Configuration.NEW_CURSORS);
            object.addProperty("display-hp-above-head", Configuration.DISPLAY_HP_ABOVE_HEAD);
            object.addProperty("display-username-above-head", Configuration.DISPLAY_USERNAMES_ABOVE_HEAD);
            object.addProperty("gameframe", GameFrameConstants.gameframeType == GameFrameConstants.GameFrameType.FRAME_525 ? false : true);
            object.addProperty("highlight-username", Configuration.HIGHLIGHT_USERNAME);
            object.addProperty("high-detail", Configuration.HIGH_DETAIL);
            object.addProperty("split-chat-color", new Integer(client.splitChatColor));
            object.addProperty("clan-chat-color", new Integer(client.clanChatColor));
            object.addProperty("split-chat", new Integer(client.variousSettings[502]));
            object.addProperty("ground-text", Configuration.GROUND_TEXT);
           // object.add("split-chat", builder.toJsonTree(client.variousSettings[502]));

            String stringSave = "";
            for(int i = 0; i < client.quickPrayers.length; i++)
                stringSave = stringSave + client.quickPrayers[i];
            System.out.println(stringSave);
            object.add("quick-prayers", builder.toJsonTree(stringSave));

            stringSave = "";
            for(int i = 0; i < client.quickCurses.length; i++)
                stringSave = stringSave + client.quickCurses[i];
            System.out.println(stringSave);
            object.add("quick-curses", builder.toJsonTree(stringSave));

            writer.write(builder.toJson(object));
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        }
    }


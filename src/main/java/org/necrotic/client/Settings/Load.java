package org.necrotic.client.Settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.necrotic.Configuration;
import org.necrotic.client.Client;
import org.necrotic.client.Signlink;
import org.necrotic.client.constants.GameFrameConstants;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Brandon on 7/28/2017.
 */
public class Load {

    public static void settings(Client client) {
        Path path = Paths.get(Signlink.getSettingsDirectory(), "/settings.json");
        File file = path.toFile();

        //if it doesn't exist no use on loading it, wait for saving method to create it.
        if(!file.exists()) {
            return;
        }

        try (FileReader fileReader = new FileReader(file)) {

            JsonParser fileparser = new JsonParser();
            Gson builder = new GsonBuilder().create();
            JsonObject reader = (JsonObject) fileparser.parse(fileReader);

            if(reader.has("save-accounts")) {
                Configuration.SAVE_ACCOUNTS = reader.get("save-accounts").getAsBoolean();
                System.out.println(reader.get("save-accounts").getAsString());
            }
            if(reader.has("new-f-keys")) {
                Configuration.NEW_FUNCTION_KEYS = reader.get("new-f-keys").getAsBoolean();
            }
            if(reader.has("new-hp-bars")) {
                Configuration.NEW_HEALTH_BARS = reader.get("new-hp-bars").getAsBoolean();
            }
            if(reader.has("new-hitmark")) {
                Configuration.NEW_HITMARKS = reader.get("new-hitmark").getAsBoolean();
            }
            if(reader.has("constitution")) {
                Configuration.CONSTITUTION_ENABLED = reader.get("constitution").getAsBoolean();
            }
            if(reader.has("new-cursor")) {
                Configuration.NEW_CURSORS = reader.get("new-cursor").getAsBoolean();
            }
            if(reader.has("display-hp-above-head")) {
                Configuration.DISPLAY_HP_ABOVE_HEAD = reader.get("display-hp-above-head").getAsBoolean();
            }
            if(reader.has("display-username-above-head")) {
                Configuration.DISPLAY_USERNAMES_ABOVE_HEAD = reader.get("display-username-above-head").getAsBoolean();
            }
            if(reader.has("gameframe")) {
                GameFrameConstants.gameframeType = reader.get("gameframe").getAsBoolean() ? GameFrameConstants.GameFrameType.FRAME_554 : GameFrameConstants.GameFrameType.FRAME_525;
            }
            if(reader.has("highlight-username")) {
                Configuration.HIGHLIGHT_USERNAME = reader.get("highlight-username").getAsBoolean();
            }
            if(reader.has("high-detail")) {
                if(!reader.get("high-detail").getAsBoolean()) {
                    Client.setLowDetail();
                } else {
                    Client.setHighDetail();
                }
            }
            if(reader.has("split-chat-color")) {
                client.splitChatColor = reader.get("split-chat-color").getAsInt();
            }
            if(reader.has("clan-chat-color")) {
                client.splitChatColor = reader.get("clan-chat-color").getAsInt();
            }
            if(reader.has("split-chat")) {
                client.variousSettings[502] = reader.get("split-chat").getAsInt();
            }
            if(reader.has("ground-text")) {
                Configuration.GROUND_TEXT = reader.get("ground-text").getAsBoolean();
            }
            if(reader.has("quick-prayers")) {
                String qp = reader.get("quick-prayers").getAsString();
                for (int i = 0; i < qp.length(); i++)
                    client.quickPrayers[i] = Integer.parseInt(qp.substring(i, i+1));
            }
            if(reader.has("quick-curses")) {
                String qp = reader.get("quick-curses").getAsString();
                for (int i = 0; i < qp.length(); i++)
                    client.quickCurses[i] = Integer.parseInt(qp.substring(i, i+1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

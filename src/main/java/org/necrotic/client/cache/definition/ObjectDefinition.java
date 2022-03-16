package org.necrotic.client.cache.definition;

import java.io.File;
import java.io.FileOutputStream;

import org.necrotic.client.Client;
import org.necrotic.client.FrameReader;
import org.necrotic.client.List;
import org.necrotic.client.Signlink;
import org.necrotic.client.cache.Archive;
import org.necrotic.client.cache.ondemand.OnDemandFetcher;
import org.necrotic.client.io.ByteBuffer;
import org.necrotic.client.world.Model;

public final class ObjectDefinition {

    private static int[] streamIndices;
    private static int[] streamIndices667;
    private static ByteBuffer stream667;

    private static final int[] showBlack = { 3735, 26346, 26347, 26348, 26358,
            26359, 26360, 26361, 26362, 26363, 26364 };

    public static ObjectDefinition forID(int id) {
        for (int j = 0; j < 20; j++) {
            if (cache[j].type == id) {
                return cache[j];
            }
        }
        if (id >= streamIndices.length) {
            // return forID667(id);
        }

        //cacheIndex = (cacheIndex + 1) % 20;,

        cacheIndex = (cacheIndex + 1) % 20;
        ObjectDefinition definition = cache[cacheIndex];

        boolean loadNew = (
                /*id == 8550 || id == 8551 || id == 7847 || id == 8150 || */id == 32159 || id == 32157 || id == 36672 || id == 36675 || id == 36692 || id == 34138 || id >= 39260 && id <= 39271 || id == 39229 || id == 39230 || id == 39231 || id == 36676 || id == 36692 || id > 11915 && id <= 11929 || id >= 11426 && id <= 11444 || id >= 14835 && id <= 14845 || id >= 11391 && id <= 11397 || id >= 12713 && id <= 12715
                );
        if (id < 0) {
            id = 0;
        }
        //    stream.position = streamIndices[id];
        try {
            if(id > streamIndices.length || loadNew)
                stream667.position = streamIndices667[id];
            else 
                stream.position = streamIndices[id];
        } catch (Exception e) {
            e.printStackTrace();
        }
        definition.type = id;
        definition.setDefaults();
        //    definition.readValues(stream);
        if(id > streamIndices.length || loadNew)
            definition.readValues(stream667);
        else
            definition.readValues(stream);
        for (int element : showBlack) {
            if (id == element) {
                definition.modifiedModelColors = new int[1];
                definition.originalModelColors = new int[1];
                definition.modifiedModelColors[0] = 0;
                definition.originalModelColors[0] = 1;
            }

        }

        if(definition.name == null) {
            definition.name = "";
            definition.hasActions = false;
        }

        int[][] shootingStars = { { 38661, 42165 }, { 38662, 42166 },
                { 38663, 42163 }, { 38664, 42164 }, { 38665, 42160 },
                { 38666, 42159 }, { 38667, 42168 }, { 38668, 42169 }, };

        for (int[] i : shootingStars) {
            if (id == i[0]) {
                stream.position = streamIndices[3514];
                definition.setDefaults();
                definition.readValues(stream);
                definition.objectModelIDs = new int[1];
                definition.objectModelIDs[0] = i[1];
                definition.sizeX = 2;
                definition.sizeY = 2;
                definition.name = "Crashed star";
                definition.actions = new String[5];
                definition.actions[0] = "Mine";
                definition.description = "A crashed star!".getBytes();
            }
        }
        loadEvilTree(definition);
        if (definition.description == null) {
            definition.description = ("It's a " + definition.name + ".").getBytes();
        }
        if (definition.actions == null || definition.actions.length < 5) {
            String[] newActions = new String[5];
            if(definition.actions != null) {
                for (int i = 0; i < 5; i++) {
                    if (i >= definition.actions.length) {
                        newActions[i] = null;
                    } else {
                        newActions[i] = definition.actions[i];
                    }
                }
            }
            definition.actions = newActions;
        }


        boolean removeObject = definition.type == 1442 || definition.type == 1433 || definition.type == 1443 || definition.type == 1441 || definition.type == 26916 || definition.type == 26917 || definition.type == 5244 || definition.type == 2623 || definition.type == 2956 || definition.type == 463 || definition.type == 462 || definition.type == 10527 || definition.type == 10529 || definition.type == 40257 || definition.type == 296 || definition.type == 300 || definition.type == 1747 || definition.type == 7332 || definition.type == 7326 || definition.type == 7325 || definition.type == 7385 || definition.type == 7331 || definition.type == 7385 || definition.type == 7320 || definition.type == 7317 || definition.type == 7323 || definition.type == 7354 || definition.type == 1536 || definition.type == 1537 || definition.type == 5126 || definition.type == 1551 || definition.type == 1553 || definition.type == 1516 || definition.type == 1519 || definition.type == 1557 || definition.type == 1558 || definition.type == 7126 || definition.type == 733 || definition.type == 14233 || definition.type == 14235 || definition.type == 1596 || definition.type == 1597 || definition.type == 14751 || definition.type == 14752 || definition.type == 14923 || definition.type == 36844 || definition.type == 30864 || definition.type == 2514 || definition.type == 1805 || definition.type == 15536 || definition.type == 2399 || definition.type == 14749 || definition.type == 29315 || definition.type == 29316 || definition.type == 29319 || definition.type == 29320 || definition.type == 29360 || definition.type == 1528 || definition.type == 36913 || definition.type == 36915 || definition.type == 15516 || definition.type == 35549 || definition.type == 35551 || definition.type == 26808 || definition.type == 26910 || definition.type == 26913 || definition.type == 24381 || definition.type == 15514 || definition.type == 25891 || definition.type == 26082 || definition.type == 26081 || definition.type == 1530 || definition.type == 16776 || definition.type == 16778 || definition.type == 28589 || definition.type == 1533 || definition.type == 17089 || definition.type == 1600 || definition.type == 1601 || definition.type == 11707 || definition.type == 24376 || definition.type == 24378 || definition.type == 40108 || definition.type == 59 || definition.type == 2069 || definition.type == 36846 || definition.type == 1506 ||
        		definition.type == 9299 ||
        		definition.type == 1508 || definition.type  == 4031 || definition.type == 11470 || definition.name != null && ((definition.name.equalsIgnoreCase("door") && definition.type != 15644 && definition.type != 15641) || definition.name.equalsIgnoreCase("gate"));
        if(removeObject) {
            definition.objectModelIDs = null;
            definition.hasActions = false;
            definition.isUnwalkable = false;
            return definition;
        }
        /*if(definition.varbitIndex <= 484 && definition.varbitIndex >= 469) {
            definition.configID = definition.varbitIndex;
            definition.varbitIndex = -1;
        }*/
        if(definition.name != null && definition.type != 591) {
            String s =definition.name.toLowerCase();
            if(s.contains("bank") && !s.contains("closed")) {
                definition.actions = new String[5];
                definition.actions[0] = "Use";
                definition.actions[1] = "Use Quickly";
            }
        }
        if (definition.type == 2882 || definition.type == 2883) {
        	definition.name = "Gate";
        	definition.actions = new String[5];
        	definition.actions[0] = "Open";
        	definition.actions[1] = null;
        }
        if (definition.type == 28295) {
        	definition.name = "@red@Holiday snowman";
        	definition.actions[0] = "@gre@Teleport to event";
        }
        if (definition.type == 11666) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Smelt";
        	definition.actions[1] = "Craft";
        }
        if (definition.type == 28426 || definition.type == 28427) {
        	definition.name = "Rocky plinth";
        	definition.actions = new String[5];
        	definition.description = "A very old rock formation.".getBytes();
        }
        if (definition.type == 28449 || definition.type == 28474 || definition.type == 28448) {
        	definition.name = "Dense brush";
        	definition.actions = new String[5];
        	definition.description = "Too thick to walk through.".getBytes();
        }
        if (definition.type == 28457 || 
        	definition.type == 28458 || 
        	definition.type == 28459 || 
        	definition.type == 28460 || 
        	definition.type == 28461 || 
        	definition.type == 28462 || 
        	definition.type == 28463 || 
        	definition.type == 28464 || 
        	definition.type == 28465 || 
        	definition.type == 28466 || 
        	definition.type == 28467 || 
        	definition.type == 28468 || 
        	definition.type == 28469 || 
        	definition.type == 28470 || 
        	definition.type == 28471 || 
        	definition.type == 28472 || 
        	definition.type == 28473 || 
        	definition.type == 28456) {
        	definition.name = "Murky water";
        	definition.description = "This water doesn't look clean...".getBytes();
        }
        if (definition.type == 134 || definition.type == 135) {
        	definition.name = "Heavy door";
        	definition.actions = new String[5];
        	definition.actions[0] = "Push";
        }
        if (definition.type == 17953) { //zulrah boat
        	definition.actions = new String[5];
        	definition.actions[0] = "Board";
        	definition.description = "I want you to know that I was rooting for you, mate. Know that.".getBytes();
        }
        if (definition.type == 57225) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Climb-over";
        }
        if (definition.type == 2305) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Escape";
        }
        if (definition.type == 589) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Search";
        }
        if (definition.type == 11678) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Inspect";
        }
        if (definition.type == 11339) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Search";
        }
        if (definition.type == 5595) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Search";
        }
        if (definition.type == 2725) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Search";
        }
        if (definition.type == 423) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Search";
        }
        if (definition.type == 57258) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Climb";
        }
        if (definition.type == 1739) {
        	definition.actions = new String[5];
        	definition.actions[0] = "Climb-up";
        	definition.actions[1] = "Climb-down";
        	//definition.actions[4] = "Climb-down";
        }
        if (definition.type == 11698) {
            definition.name = null;
            definition.hasActions = false;
            definition.actions = null;
            definition.modifiedModelColors = new int[] {6817, 6697, 6693, 7580};
            definition.originalModelColors = new int[] {21543, 21547, 45, 7341};
            definition.objectModelIDs = new int[] { 5013 };
        }
        if (definition.type == 11699) {
            definition.name = null;
            definition.hasActions = false;
            definition.actions = null;
            definition.modifiedModelColors = new int[] {74, 43117};
            definition.originalModelColors = new int[] {21543, 21547};
            definition.objectModelIDs = new int[] { 1424 };
        }
        if(definition.type == 5259) {
            definition.actions = new String[5];
            definition.name = "Ghost Town Barrier";
            definition.actions[0] = "Pass";
        }
        if(definition.type == 10805 || definition.type == 10806 || definition.type == 10807) {
            definition.name = "Grand Exchange clerk";
            definition.hasActions = true;
            definition.actions = new String[5];
            definition.actions[0] = "Use";
        }
        if(definition.type == 10091) {
            definition.actions = new String[] {"Bait", null, null, null, null};
            definition.name = "@yel@Rocktail fishing spot";
        }
        if(definition.type == 7836 || definition.type == 7808) {
            definition.hasActions = true;
            definition.actions = new String[] {"Dump-weeds", null, null, null, null};
            definition.name = "Compost bin";
        }
        if(definition.type == 26945) {
            definition.actions = new String[] {"Investigate", "Contribute", null, null, null};
            definition.name = "Well of Goodwill";
        }
        if(definition.type == 25014 || definition.type == 25026 || definition.type == 25020 || definition.type == 25019 || definition.type == 25024 || definition.type == 25025 || definition.type == 25016 || definition.type == 5167 || definition.type == 5168) {
            definition.actions = new String[5];
        }
        if(definition.type == 1948) {
            definition.name = "Wall";
        }
        if(definition.type == 25029) {
            definition.actions = new String[5];
            definition.actions[0] = "Go-through";
        }
        if(definition.type == 19187 || definition.type == 19175) {
            definition.actions = new String[5];
            definition.actions[0] = "Dismantle";
        }
        if(definition.type == 6434) {
            definition.actions = new String[5];
            definition.actions[0] = "Enter";
        }
        if(definition.type == 2182) {
            definition.actions = new String[5];
            definition.actions[0] = "Buy-Items";
            definition.name = "Culinaromancer's chest";
        }
        if(definition.type == 10177)
        {
            definition.actions = new String[5];
            definition.actions[0] = "Climb-down";
            definition.actions[1] = "Climb-up";
        }
        if(definition.type == 39515)
        {
            definition.name = "Pvm Portal";
        }
        if(definition.type == 2026)
        {
            definition.actions = new String[5];
            definition.actions[0] = "Net";
        }
        if(definition.type == 2029)
        {
            definition.actions = new String[5];
            definition.actions[0] = "Lure";
            definition.actions[1] = "Bait";
        }
        if(definition.type == 2030)
        {
            definition.actions = new String[5];
            definition.actions[0] = "Cage";
            definition.actions[1] = "Harpoon";
        }
        if(definition.type == 7352) {
            definition.name = "Gatestone portal";
            definition.actions = new String[5];
            definition.actions[0] = "Enter";
        }
        if(definition.type == 11356)
        {
            definition.name = "Dark Beast Portal";
        }
        if(definition.type == 47120) {
            definition.name = "Altar";
            definition.actions = new String[5];
            definition.actions[0] = "Craft-rune";
        }
        if(definition.type == 11325 || definition.type == 11328|| definition.type == 37943 || definition.type == 37940 
        		|| definition.type == 11325) {
        	definition.hasActions = false;
        }
        if(definition.type == 20331)
        {
            definition.actions = new String[5];
            definition.actions[0] = "Steal-from";
        }
        if(definition.type == 47180)
        {
            definition.name = "Frost Dragon Portal Device";
            definition.actions = new String[5];
            definition.actions[0] = "Activate";
        }
        if(definition.type == 8702) {
            definition.name = "Rocktail Barrel";
            definition.actions = new String[5];
            definition.actions[0] = "Fish-from";
        }
        if(definition.type == 2783)
        {
            definition.hasActions = true;
            definition.name = "Anvil";
            definition.actions = new String[5];
            definition.actions[0] = "Smith-on";
        }
        if(definition.type == 172) {
            definition.name = "Crystal Chest";
        }
        if(definition.type == 6714)
        {
            definition.hasActions = true;
            definition.name = "Door";
            definition.actions[0] = "Open";
        }
        if(definition.type == 8550 || definition.type == 8150 || definition.type == 8551 || definition.type == 7847 || definition.type == 8550)
        {
            definition.actions = new String[] {null, "Inspect", null, "Guide", null};

            definition.hasActions = true;

        }
        if(definition.type == 42151 || definition.type == 42160)
        {
            definition.name = "Rocks";
            definition.hasActions = true;
            definition.mapSceneID = 11;
        }
        if(definition.type == 42158 || definition.type == 42157)
        {
            definition.name = "Rocks";
            definition.hasActions = true;
            definition.mapSceneID = 12;
        }
        if(definition.type == 42123 || definition.type == 42124 || definition.type == 42119 || definition.type == 42120 || definition.type == 42118 || definition.type == 42122)
        {
            definition.name = "Tree";
            definition.hasActions = true;
            definition.actions = new String[] {"Cut", null, null, null, null};
            definition.mapSceneID = 0;
        }
        if(definition.type == 42127 || definition.type == 42131 || definition.type == 42133 || definition.type == 42129 || definition.type == 42134)
        {
            definition.name = "Tree";
            definition.hasActions = true;
            definition.actions = new String[] {"Cut", null, null, null, null};
            definition.mapSceneID = 6;
        }
        if(definition.type == 42082 || definition.type == 42083)
            definition.mapSceneID = 0;
        if(definition.type >= 42087 && definition.type <= 42117)
            definition.mapSceneID = 4;
        if(definition.type > 30000 && definition.name != null && definition.name.toLowerCase().contains("gravestone"))
            definition.mapSceneID = 34;
        if(definition.type == 36676)
        {
            definition.objectModelIDs = new int[]{17374, 17383};
            //    definition.objectModelTypes = null;
        }
        if(definition.type == 34255)
        {
            definition.configID = 8002;
            definition.configObjectIDs = new int[]
                    {
                            15385
                    };
        }
        if(definition.type == 13830)
        {
            //definition.objectModelIDs = new int[] {12199};
            definition.configID = 8003;
            definition.configObjectIDs = new int[]
                    {
                            13217, 13218, 13219, 13220, 13221, 13222, 13223
                    };
        }
        if (definition.type == 21634) {
            definition.hasActions = true;
            definition.actions = new String[5];
            definition.actions[0] = "Sail";
        }
        if (definition.type == 10284) {
            definition.name = "Chest";
            definition.hasActions = true;
            definition.actions = new String[5];
            definition.actions[0] = "Open";
        }
        if (definition.type == 22721) {
            definition.hasActions = true;
            definition.actions = new String[5];
            definition.actions[0] = "Smelt";
        }
        if (definition.type == 7837) {
            definition.hasActions = true;
            definition.actions = new String[5];
        }
        if (definition.type == 26280){
            definition.hasActions = true;
            definition.actions = new String[5];
            definition.actions[0] = "Study";
        }
        if (definition.type == 27339 || definition.type == 27306)
        {
            definition.hasActions = true;
            definition.name = "Mystical Monolith";
            definition.actions = new String[5];
            definition.actions[0] = "Travel";
            definition.actions[1] = "Pray-at";
        }
        if(definition.type == 15314 || definition.type == 15313)
        {
            definition.configID = 8000;
            definition.configObjectIDs = new int[] {definition.type, -1};
        }
        if(definition.type == 15306)
        {
            definition.configID = 8001;
            definition.configObjectIDs = new int[] {definition.type,-1, 13015};
        }
        if(definition.type == 15305)
        {
            definition.configID = 8001;
            definition.configObjectIDs = new int[] {definition.type, -1, 13016};    
        }
        if(definition.type == 15317)
        {
            definition.configID = 8001;
            definition.configObjectIDs = new int[] {definition.type, -1, 13096};    
        }
        if(definition.type == 8550)
        {
            definition.configObjectIDs = new int[] 
                    {
                            8576, 8575, 8574, 8573, 8576, 8576, 8558, 8559, 8560, 8561, 8562, 8562, 8562, 8580, 8581, 8582, 8583, 8584, 8584, 8584, 8535, 8536, 8537, 8538, 8539, 8539, 8539, 8641, 8642, 8643, 8644, 8645, 8645, 8645, 8618, 8619, 8620, 8621, 8622, 8623, 8624, 8624, 8624, 8595, 8596, 8597, 8598, 8599, 8600, 8601, 8601, 8601, 8656, 8657, 8658, 8659, 8660, 8661, 8662, 8663, 8664, 8664, 8664, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8563, 8564, 8565, 8566, 8576, 8576, 8576, 8585, 8586, 8587, 8588, 8576, 8576, 8576, 8540, 8541, 8542, 8543, 8576, 8576, 8576, 8646, 8647, 8648, 8649, 8576, 8576, 8576, 8625, 8626, 8627, 8628, 8629, 8630, 8576, 8576, 8576, 8602, 8603, 8604, 8605, 8606, 8607, 8576, 8576, 8576, 8665, 8666, 8667, 8668, 8669, 8670, 8671, 8672, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8567, 8568, 8569, 8576, 8576, 8576, 8576, 8589, 8590, 8591, 8576, 8576, 8576, 8576, 8544, 8545, 8546, 8576, 8576, 8576, 8576, 8650, 8651, 8652, 8576, 8576, 8576, 8576, 8631, 8632, 8633, 8634, 8635, 8576, 8576, 8576, 8576, 8608, 8609, 8610, 8611, 8612, 8576, 8576, 8576, 8576, 8673, 8674, 8675, 8676, 8677, 8678, 8679, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8570, 8571, 8572, 8576, 8576, 8576, 8576, 8592, 8593, 8594, 8576, 8576, 8576, 8576, 8547, 8548, 8549, 8576, 8576, 8576, 8576, 8653, 8654, 8655, 8576, 8576, 8576, 8576, 8636, 8637, 8638, 8639, 8640, 8576, 8576, 8576, 8576, 8613, 8614, 8615, 8616, 8617, 8576, 8576, 8576, 8576, 8680, 8681, 8682, 8683, 8684, 8685, 8686, 8576, 8576, 8576, 8576
                    };
        }
        if(definition.type == 8551)
        {
            definition.configObjectIDs = new int[] 
                    {
                            8576, 8575, 8574, 8573, 8576, 8576, 8558, 8559, 8560, 8561, 8562, 8562, 8562, 8580, 8581, 8582, 8583, 8584, 8584, 8584, 8535, 8536, 8537, 8538, 8539, 8539, 8539, 8641, 8642, 8643, 8644, 8645, 8645, 8645, 8618, 8619, 8620, 8621, 8622, 8623, 8624, 8624, 8624, 8595, 8596, 8597, 8598, 8599, 8600, 8601, 8601, 8601, 8656, 8657, 8658, 8659, 8660, 8661, 8662, 8663, 8664, 8664, 8664, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8563, 8564, 8565, 8566, 8576, 8576, 8576, 8585, 8586, 8587, 8588, 8576, 8576, 8576, 8540, 8541, 8542, 8543, 8576, 8576, 8576, 8646, 8647, 8648, 8649, 8576, 8576, 8576, 8625, 8626, 8627, 8628, 8629, 8630, 8576, 8576, 8576, 8602, 8603, 8604, 8605, 8606, 8607, 8576, 8576, 8576, 8665, 8666, 8667, 8668, 8669, 8670, 8671, 8672, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8567, 8568, 8569, 8576, 8576, 8576, 8576, 8589, 8590, 8591, 8576, 8576, 8576, 8576, 8544, 8545, 8546, 8576, 8576, 8576, 8576, 8650, 8651, 8652, 8576, 8576, 8576, 8576, 8631, 8632, 8633, 8634, 8635, 8576, 8576, 8576, 8576, 8608, 8609, 8610, 8611, 8612, 8576, 8576, 8576, 8576, 8673, 8674, 8675, 8676, 8677, 8678, 8679, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8570, 8571, 8572, 8576, 8576, 8576, 8576, 8592, 8593, 8594, 8576, 8576, 8576, 8576, 8547, 8548, 8549, 8576, 8576, 8576, 8576, 8653, 8654, 8655, 8576, 8576, 8576, 8576, 8636, 8637, 8638, 8639, 8640, 8576, 8576, 8576, 8576, 8613, 8614, 8615, 8616, 8617, 8576, 8576, 8576, 8576, 8680, 8681, 8682, 8683, 8684, 8685, 8686, 8576, 8576, 8576, 8576
                    };
        }
        if(definition.type == 7847)
        {
            definition.configObjectIDs = new int[] 
                    {
                            7843, 7842, 7841, 7840, 7843, 7843, 7843, 7843, 7867, 7868, 7869, 7870, 7871, 7899, 7900, 7901, 7902, 7903, 7883, 7884, 7885, 7886, 7887, 7919, 7920, 7921, 7922, 7923, 7851, 7852, 7853, 7854, 7855, 7918, 7917, 7916, 7915, 41538, 41539, 41540, 41541, 41542, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7872, 7873, 7874, 7875, 7843, 7904, 7905, 7906, 7907, 7843, 7888, 7889, 7890, 7891, 7843, 7924, 7925, 7926, 7927, 7843, 7856, 7857, 7858, 7859, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7876, 7877, 7878, 7843, 7843, 7908, 7909, 7910, 7843, 7843, 7892, 7893, 7894, 7843, 7843, 7928, 7929, 7930, 7843, 7843, 7860, 7861, 7862, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7879, 7880, 7881, 7882, 7843, 7911, 7912, 7913, 7914, 7843, 7895, 7896, 7897, 7898, 7843, 7931, 7932, 7933, 7934, 7843, 7863, 7864, 7865, 7866, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843
                    };
        }
        if(definition.type == 8150)
        {
            definition.configObjectIDs = new int[] 
                    {
                            8135, 8134, 8133, 8132, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 21101, 21127, 21159, 21178, 21185, 21185, 21185, 17776, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 17777, 17778, 17780, 17781, 17781, 17781, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8147, 8148, 8149, 8144, 8145, 8146, 8144, 8145, 8146, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 9044, 9045, 9046, 9047, 9048, 9048, 9049, 9050, 9051, 9052, 9053, 9054, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8144, 8145, 8146, 8135, 8135, 8135, 8135, 8135, 8135, -1, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135
                    };
        }

        switch (definition.type) {
        case 2470:
        	definition.name = "@red@Event Portal";
        	break;
        case 38700:
        	definition.name = "Free-For-All Portal @gre@(SAFE)";
        	break;
        case 6725:
        case 6714:
        case 6734:
        case 6730:
        case 6749:
        case 6742:
        case 6723:
        case 6728:
        case 6747:
        case 6744:
        case 6741:
        case 6779:
        case 6743:
        case 6719:
        case 6717:
        case 6731:
        case 6716:
        case 6720:
        case 6738:
        case 6726:
        case 6740:
        case 6721:
        case 6748:
        case 6729:
        case 6745:
        case 6718:
        case 6780:
        case 6746:
        case 6750:
        case 6722:
        case 6715:
            definition.name = "Door";
            definition.hasActions = true;
            break;
        case 5917:
        	definition.actions = new String[5];
        	definition.name = "Plasma Vent"; //friday the 13th
        	definition.actions[1] = "Search";
        	break;
        case 4875:
            definition.name = "Banana Stall";
            break;
        case 4874:
            definition.name = "Ring Stall";
            break;
        case 13493:
            definition.actions = new String[5];
            definition.actions[0] = "Steal from";
            break;
        case 2152:
            definition.actions = new String[5];
            definition.actions[0] = "Infuse Pouches";
            definition.actions[1] = "Renew Points";
            definition.name = "Summoning Obelisk";
            break;
        case 4306:
            definition.actions = new String[5];
            definition.actions[0] = "Use";
            break;
        case 2732:
        case 11404:
        case 11406:
        case 11405:
        case 20000:
        case 20001:
            definition.actions = new String[5];
            definition.actions[0] = "Add logs";
            break;
        case 2:
            definition.name = "Entrance";
            break;
        }

        return definition;
    }

    public static void nullify() {
        mruNodes1 = null;
        mruNodes2 = null;
        streamIndices = null;
        cache = null;
        stream = null;
    }

    public static void unpackConfig(Archive streamLoader) {
        /*stream = new ByteBuffer(streamLoader.get("loc.dat"));
        ByteBuffer stream = new ByteBuffer(streamLoader.get("loc.idx"));
        // stream667 = new ByteBuffer(streamLoader.get("667loc.dat"));
        // ByteBuffer idxBuffer667 = new
        // ByteBuffer(streamLoader.get("667loc.idx"));
        int totalObjects = stream.getUnsignedShort();
        // System.out.println("total objects: " + totalObjects);
        // int totalObjects667 = idxBuffer667.getUnsignedShort();
        // System.out.println("total 667 objects: " + totalObjects667);
        streamIndices = new int[totalObjects + 20000];
        int i = 2;
        for (int j = 0; j < totalObjects; j++) {
            streamIndices[j] = i;
            i += stream.getUnsignedShort();
        }
        /*
         * totalObjects = totalObjects667; streamIndices667 = new
         * int[totalObjects]; i = 2; for (int j = 0; j < totalObjects; j++) {
         * streamIndices667[j] = i; i += idxBuffer667.getUnsignedShort(); }
         *

        cache = new ObjectDefinition[20];
        for (int k = 0; k < 20; k++) {
            cache[k] = new ObjectDefinition();
        }
         */

        stream = new ByteBuffer(streamLoader.get("loc.dat"));
        ByteBuffer stream = new ByteBuffer(streamLoader.get("loc.idx"));
        stream667 = new ByteBuffer(streamLoader.get("667loc.dat"));
        ByteBuffer streamIdx667 = new ByteBuffer(streamLoader.get("667loc.idx"));

        int totalObjects = stream.getUnsignedShort();
        int totalObjects667 = streamIdx667.getUnsignedShort();
        streamIndices = new int[totalObjects];
        streamIndices667 = new int[totalObjects667];
        int i = 2;
        for (int j = 0; j < totalObjects; j++) {
            streamIndices[j] = i;
            i += stream.getUnsignedShort();
        }
        i = 2;
        for (int j = 0; j < totalObjects667; j++) {
            streamIndices667[j] = i;
            i += streamIdx667.getUnsignedShort();
        }
        cache = new ObjectDefinition[20];
        for (int k = 0; k < 20; k++)
            cache[k] = new ObjectDefinition();
    }

    public boolean aBoolean736;
    private byte brightness;
    private int offsetX;
    public String name;
    private int modelSizeY;
    private static final Model[] aModelArray741s = new Model[4];
    private byte contrast;
    public int sizeX;
    private int offsetH;
    public int mapFunctionID;
    private int[] originalModelColors;
    private int modelSizeX;
    public int configID;
    private boolean aBoolean751;
    public static boolean lowDetail;
    private static ByteBuffer stream;
    public int type;
    public boolean aBoolean757;
    public int mapSceneID;
    public int configObjectIDs[];
    private int anInt760;
    public int sizeY;
    public boolean adjustToTerrain;
    public boolean aBoolean764;
    public static Client clientInstance;
    private boolean isSolidObject;
    public boolean isUnwalkable;
    public int plane;
    private boolean nonFlatShading;
    private static int cacheIndex;
    private int modelSizeH;
    private int[] objectModelIDs;
    public int varbitIndex;
    public int anInt775;
    private int[] anIntArray776;
    public byte description[];
    public boolean hasActions;
    public boolean aBoolean779;
    public static List mruNodes2 = new List(30);
    public int animationID;
    private static ObjectDefinition[] cache;
    private int offsetY;
    private int[] modifiedModelColors;
    public static List mruNodes1 = new List(500);
    public String actions[];

    public void method574(OnDemandFetcher class42_sub1) {
        if (objectModelIDs == null) {
            return;
        }
        for (int objectModelID : objectModelIDs) {
            class42_sub1.method560(objectModelID & 0xffff, 0);
        }
    }

    public boolean method577(int i) {
        if (anIntArray776 == null) {
            if (objectModelIDs == null) {
                return true;
            }
            if (i != 10) {
                return true;
            }
            boolean flag1 = true;
            for (int objectModelID : objectModelIDs) {
                flag1 &= Model.method463(objectModelID & 0xffff);
            }

            return flag1;
        }
        for (int j = 0; j < anIntArray776.length; j++) {
            if (anIntArray776[j] == i) {
                return Model.method463(objectModelIDs[j] & 0xffff);
            }
        }

        return true;
    }

    public Model renderObject(int i, int j, int k, int l, int i1, int j1, int k1) {
        Model model = getAnimatedModel(i, k1, j);
        if (model == null) {
            return null;
        }
        if (adjustToTerrain || nonFlatShading) {
            model = new Model(adjustToTerrain, nonFlatShading, model);
        }
        if (adjustToTerrain) {
            int l1 = (k + l + i1 + j1) / 4;
            for (int i2 = 0; i2 < model.numberOfVerticeCoordinates; i2++) {
                int j2 = model.verticesXCoordinate[i2];
                int k2 = model.verticesZCoordinate[i2];
                int l2 = k + (l - k) * (j2 + 64) / 128;
                int i3 = j1 + (i1 - j1) * (j2 + 64) / 128;
                int j3 = l2 + (i3 - l2) * (k2 + 64) / 128;
                model.verticesYCoordinate[i2] += j3 - l1;
            }

            model.method467();
        }
        return model;
    }

    public boolean method579() {
        if (objectModelIDs == null) {
            return true;
        }
        boolean flag1 = true;
        for (int objectModelID : objectModelIDs) {
            flag1 &= Model.method463(objectModelID & 0xffff);
        }
        return flag1;
    }

    public ObjectDefinition method580() {
        int i = -1;
        if (varbitIndex != -1) {
            VarBit varBit = VarBit.cache[varbitIndex];
            int j = varBit.configId;
            int k = varBit.configValue;
            int l = varBit.anInt650;
            int i1 = Client.anIntArray1232[l - k];
            // System.out.println("j: " + j + " k: " + k);
            i = clientInstance.variousSettings[j] >> k & i1;
        } else if (configID != -1) {
            i = clientInstance.variousSettings[configID];
        }
        if (i < 0 || i >= configObjectIDs.length || configObjectIDs[i] == -1) {
            return null;
        } else {
            return forID(configObjectIDs[i]);
        }
    }

    private Model getAnimatedModel(int j, int k, int l) {
        Model model = null;
        long l1;
        if (anIntArray776 == null) {
            if (j != 10) {
                return null;
            }
            l1 = (type << 8) + l + ((long) (k + 1) << 32);
            Model model_1 = (Model) mruNodes2.insertFromCache(l1);
            if (model_1 != null) {
                return model_1;
            }
            if (objectModelIDs == null) {
                return null;
            }
            boolean flag1 = aBoolean751 ^ l > 3;
            int k1 = objectModelIDs.length;
            for (int i2 = 0; i2 < k1; i2++) {
                int l2 = objectModelIDs[i2];
                if (flag1) {
                    l2 += 0x10000;
                }
                model = (Model) mruNodes1.insertFromCache(l2);
                if (model == null) {
                    model = Model.fetchModel(l2 & 0xffff);
                    if (model == null) {
                        return null;
                    }
                    if (flag1) {
                        model.method477();
                    }
                    mruNodes1.removeFromCache(model, l2);
                }
                if (k1 > 1) {
                    aModelArray741s[i2] = model;
                }
            }

            if (k1 > 1) {
                model = new Model(k1, aModelArray741s);
            }
        } else {
            int i1 = -1;
            for (int j1 = 0; j1 < anIntArray776.length; j1++) {
                if (anIntArray776[j1] != j) {
                    continue;
                }
                i1 = j1;
                break;
            }

            if (i1 == -1) {
                return null;
            }
            l1 = (type << 8) + (i1 << 3) + l + ((long) (k + 1) << 32);
            Model model_2 = (Model) mruNodes2.insertFromCache(l1);
            if (model_2 != null) {
                return model_2;
            }
            if(objectModelIDs == null) {
                return null;
            }
            int j2 = objectModelIDs[i1];
            boolean flag3 = aBoolean751 ^ l > 3;
            if (flag3) {
                j2 += 0x10000;
            }
            model = (Model) mruNodes1.insertFromCache(j2);
            if (model == null) {
                model = Model.fetchModel(j2 & 0xffff);
                if (model == null) {
                    return null;
                }
                if (flag3) {
                    model.method477();
                }
                mruNodes1.removeFromCache(model, j2);
            }
        }
        boolean flag;
        flag = modelSizeX != 128 || modelSizeH != 128 || modelSizeY != 128;
        boolean flag2;
        flag2 = offsetX != 0 || offsetH != 0 || offsetY != 0;
        Model model_3 = new Model(modifiedModelColors == null, FrameReader.isNullFrame(k), l == 0 && k == -1 && !flag && !flag2, model);
        if (k != -1) {
            model_3.createBones();
            model_3.applyTransform(k);
            model_3.triangleSkin = null;
            model_3.vertexSkin = null;
        }
        while (l-- > 0) {
            model_3.method473();
        }
        if (modifiedModelColors != null) {
            for (int k2 = 0; k2 < modifiedModelColors.length; k2++) {
                model_3.method476(modifiedModelColors[k2], originalModelColors[k2]);
            }

        }
        if (flag) {
            model_3.scaleT(modelSizeX, modelSizeY, modelSizeH);
        }
        if (flag2) {
            model_3.translate(offsetX, offsetH, offsetY);
        }
        model_3.light(64 + brightness, 768 + contrast * 5, -50, -10, -50, !nonFlatShading);
        if (anInt760 == 1) {
            model_3.anInt1654 = model_3.modelHeight;
        }
        mruNodes2.removeFromCache(model_3, l1);
        return model_3;
    }

    private void readValues(ByteBuffer stream) {
        int i = -1;
        label0: do {
            int opcode;
            do {
                opcode = stream.getUnsignedByte();
                if (opcode == 0)
                    break label0;
                if (opcode == 1) {
                    int k = stream.getUnsignedByte();
                    if (k > 0)
                        if (objectModelIDs == null || lowDetail) {
                            anIntArray776 = new int[k];
                            objectModelIDs = new int[k];
                            for (int k1 = 0; k1 < k; k1++) {
                                objectModelIDs[k1] = stream.getUnsignedShort();
                                anIntArray776[k1] = stream.getUnsignedByte();
                            }
                        } else {
                            stream.position += k * 3;
                        }
                } else if (opcode == 2)
                    name = stream.getString();
                else if (opcode == 3)
                    description = stream.getBytes();
                else if (opcode == 5) {
                    int l = stream.getUnsignedByte();
                    if (l > 0)
                        if (objectModelIDs == null || lowDetail) {
                            anIntArray776 = null;
                            objectModelIDs = new int[l];
                            for (int l1 = 0; l1 < l; l1++)
                                objectModelIDs[l1] = stream.getUnsignedShort();
                        } else {
                            stream.position += l * 2;
                        }
                } else if (opcode == 14)
                    sizeX = stream.getUnsignedByte();
                else if (opcode == 15)
                    sizeY = stream.getUnsignedByte();
                else if (opcode == 17)
                    isUnwalkable = false;
                else if (opcode == 18)
                    aBoolean757 = false;
                else if (opcode == 19) {
                    i = stream.getUnsignedByte();
                    if (i == 1)
                        hasActions = true;
                } else if (opcode == 21)
                    adjustToTerrain = true;
                else if (opcode == 22)
                    nonFlatShading = false;
                else if (opcode == 23)
                    aBoolean764 = true;
                else if (opcode == 24) {
                    animationID = stream.getUnsignedShort();
                    if (animationID == 65535)
                        animationID = -1;
                } else if (opcode == 28)
                    anInt775 = stream.getUnsignedByte();
                else if (opcode == 29)
                    brightness = stream.getSignedByte();
                else if (opcode == 39)
                    contrast = stream.getSignedByte();
                else if (opcode >= 30 && opcode < 39) {
                    if (actions == null)
                        actions = new String[10];
                    actions[opcode - 30] = stream.getString();
                    if (actions[opcode - 30].equalsIgnoreCase("hidden"))
                        actions[opcode - 30] = null;
                } else if (opcode == 40) {
                    int i1 = stream.getUnsignedByte();
                    modifiedModelColors = new int[i1];
                    originalModelColors = new int[i1];
                    for (int i2 = 0; i2 < i1; i2++) {
                        modifiedModelColors[i2] = stream.getUnsignedShort();
                        originalModelColors[i2] = stream.getUnsignedShort();
                    }
                } else if (opcode == 60)
                    mapFunctionID = stream.getUnsignedShort();
                else if (opcode == 62)
                    aBoolean751 = true;
                else if (opcode == 64)
                    aBoolean779 = false;
                else if (opcode == 65)
                    modelSizeX = stream.getUnsignedShort();
                else if (opcode == 66)
                    modelSizeH = stream.getUnsignedShort();
                else if (opcode == 67)
                    modelSizeY = stream.getUnsignedShort();
                else if (opcode == 68)
                    mapSceneID = stream.getUnsignedShort();
                else if (opcode == 69)
                    plane = stream.getUnsignedByte();
                else if (opcode == 70)
                    offsetX = stream.getSignedShort();
                else if (opcode == 71)
                    offsetH = stream.getSignedShort();
                else if (opcode == 72)
                    offsetY = stream.getSignedShort();
                else if (opcode == 73)
                    aBoolean736 = true;
                else if (opcode == 74) {
                    isSolidObject = true;
                } else {
                    if (opcode != 75)
                        continue;
                    anInt760 = stream.getUnsignedByte();
                }
                continue label0;
            } while (opcode != 77);
            varbitIndex = stream.getUnsignedShort();
            if (varbitIndex == 65535)
                varbitIndex = -1;
            configID = stream.getUnsignedShort();
            if (configID == 65535)
                configID = -1;
            int j1 = stream.getUnsignedByte();
            configObjectIDs = new int[j1 + 1];
            for (int j2 = 0; j2 <= j1; j2++) {
                configObjectIDs[j2] = stream.getUnsignedShort();
                if (configObjectIDs[j2] == 65535)
                    configObjectIDs[j2] = -1;
            }

        } while (true);
        if (i == -1) {
            hasActions = objectModelIDs != null && (anIntArray776 == null || anIntArray776[0] == 10);
            if (actions != null)
                hasActions = true;
        }
        if (isSolidObject) {
            isUnwalkable = false;
            aBoolean757 = false;
        }
        if (anInt760 == -1)
            anInt760 = isUnwalkable ? 1 : 0;
    }

    private void setDefaults() {
        objectModelIDs = null;
        anIntArray776 = null;
        name = null;
        description = null;
        modifiedModelColors = null;
        originalModelColors = null;
        sizeX = 1;
        sizeY = 1;
        isUnwalkable = true;
        aBoolean757 = true;
        hasActions = false;
        adjustToTerrain = false;
        nonFlatShading = false;
        aBoolean764 = false;
        animationID = -1;
        anInt775 = 16;
        brightness = 0;
        contrast = 0;
        actions = null;
        mapFunctionID = -1;
        mapSceneID = -1;
        aBoolean751 = false;
        aBoolean779 = true;
        modelSizeX = 128;
        modelSizeH = 128;
        modelSizeY = 128;
        plane = 0;
        offsetX = 0;
        offsetH = 0;
        offsetY = 0;
        aBoolean736 = false;
        isSolidObject = false;
        anInt760 = -1;
        varbitIndex = -1;
        configID = -1;
        configObjectIDs = null;
    }

    public static void loadEvilTree(ObjectDefinition definition) {
        switch (definition.type) {

        case 11391:
            definition.objectModelIDs = new int[] { 45733, 45735 };
            definition.anIntArray776 = null;
            definition.name = "Seedling";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1694;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Nurture", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11392:
            definition.objectModelIDs = new int[] { 45733, 45731, 45735 };
            definition.anIntArray776 = null;
            definition.name = "Sapling";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1695;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Nurture", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11394:
            definition.objectModelIDs = new int[] { 45736, 45739, 45735 };
            definition.anIntArray776 = null;
            definition.name = "Young tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1697;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Nurture", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11395:
            definition.objectModelIDs = new int[] { 45739, 45741, 45735 };
            definition.anIntArray776 = null;
            definition.name = "Young tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1698;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Nurture", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 12713:
            definition.objectModelIDs = new int[] { 45759 };
            definition.anIntArray776 = null;
            definition.name = "Fallen tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = -1;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = null;
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 12714:
            definition.objectModelIDs = new int[] { 45754 };
            definition.anIntArray776 = null;
            definition.name = "Fallen tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = -1;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = null;
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 12715:
            definition.objectModelIDs = new int[] { 45752 };
            definition.anIntArray776 = null;
            definition.name = "Fallen tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = -1;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = null;
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11922:
            definition.objectModelIDs = new int[] { 45748 };
            definition.anIntArray776 = null;
            definition.name = "Elder evil tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1134;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11919:
            definition.objectModelIDs = new int[] { 45750 };
            definition.anIntArray776 = null;
            definition.name = "Evil magic tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1679;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11916:
            definition.objectModelIDs = new int[] { 45757 };
            definition.anIntArray776 = null;
            definition.name = "Evil yew tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1685;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11444:
            definition.objectModelIDs = new int[] { 45745 };
            definition.anIntArray776 = null;
            definition.name = "Evil maple tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1682;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11441:
            definition.objectModelIDs = new int[] { 45762 };
            definition.anIntArray776 = null;
            definition.name = "Evil willow tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1688;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11437:
            definition.objectModelIDs = new int[] { 45765 };
            definition.anIntArray776 = null;
            definition.name = "Evil oak tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1691;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11435:
            definition.objectModelIDs = new int[] { 45769 };
            definition.anIntArray776 = null;
            definition.name = "Evil tree";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 3;
            definition.sizeY = 3;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 1676;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11433:
            definition.objectModelIDs = new int[] { 45743 };
            definition.anIntArray776 = null;
            definition.name = "Evil root";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 353;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11432:
            definition.objectModelIDs = new int[] { 45743 };
            definition.anIntArray776 = null;
            definition.name = "Evil root";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 354;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11431:
            definition.objectModelIDs = new int[] { 45743 };
            definition.anIntArray776 = null;
            definition.name = "Evil root";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 353;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11430:
            definition.objectModelIDs = new int[] { 45743 };
            definition.anIntArray776 = null;
            definition.name = "Evil root";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 354;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11429:
            definition.objectModelIDs = new int[] { 45743 };
            definition.anIntArray776 = null;
            definition.name = "Evil root";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 353;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11428:
            definition.objectModelIDs = new int[] { 45743 };
            definition.anIntArray776 = null;
            definition.name = "Evil root";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 354;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11427:
            definition.objectModelIDs = new int[] { 45743 };
            definition.anIntArray776 = null;
            definition.name = "Evil root";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 353;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 11426:
            definition.objectModelIDs = new int[] { 45743 };
            definition.anIntArray776 = null;
            definition.name = "Evil root";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 354;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { "Chop", };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 128;
            definition.modelSizeH = 128;
            definition.modelSizeY = 128;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            break;
        case 650:
            definition.objectModelIDs = new int[] {24003};
            definition.anIntArray776 = null;
            definition.name = "Easter Egg";
            definition.modifiedModelColors = new int[] { 0 };
            definition.originalModelColors = new int[] { 1 };
            definition.sizeX = 1;
            definition.sizeY = 1;
            definition.isUnwalkable = true;
            definition.aBoolean757 = true;
            definition.hasActions = true;
            definition.adjustToTerrain = false;
            definition.nonFlatShading = false;
            definition.aBoolean764 = false;
            definition.animationID = 354;
            definition.anInt775 = 16;
            definition.brightness = 15;
            definition.contrast = 0;
            definition.actions = new String[] { null, };
            definition.mapFunctionID = -1;
            definition.mapSceneID = -1;
            definition.aBoolean751 = false;
            definition.aBoolean779 = true;
            definition.modelSizeX = 256;
            definition.modelSizeH = 256;
            definition.modelSizeY = 256;
            definition.plane = 0;
            definition.offsetX = 0;
            definition.offsetH = 0;
            definition.offsetY = 0;
            definition.aBoolean736 = false;
            definition.isSolidObject = false;
            definition.anInt760 = 1;
            definition.varbitIndex = -1;
            definition.configID = -1;
            definition.configObjectIDs = null;
            definition.description = "It's the Easter bunny's eggs!".getBytes();
            break;
            case 651:
                definition.objectModelIDs = new int[] {14414};
                definition.anIntArray776 = null;
                definition.name = "Easter Egg";
                definition.modifiedModelColors = new int[] { 0 };
                definition.originalModelColors = new int[] { 1 };
                definition.sizeX = 1;
                definition.sizeY = 1;
                definition.isUnwalkable = true;
                definition.aBoolean757 = true;
                definition.hasActions = true;
                definition.adjustToTerrain = false;
                definition.nonFlatShading = false;
                definition.aBoolean764 = false;
                definition.animationID = 354;
                definition.anInt775 = 16;
                definition.brightness = 15;
                definition.contrast = 0;
                definition.actions = new String[] { null, };
                definition.mapFunctionID = -1;
                definition.mapSceneID = -1;
                definition.aBoolean751 = false;
                definition.aBoolean779 = true;
                definition.modelSizeX = 228;
                definition.modelSizeH = 228;
                definition.modelSizeY = 228;
                definition.plane = 0;
                definition.offsetX = 0;
                definition.offsetH = 0;
                definition.offsetY = 0;
                definition.aBoolean736 = false;
                definition.isSolidObject = false;
                definition.anInt760 = 1;
                definition.varbitIndex = -1;
                definition.configID = -1;
                definition.configObjectIDs = null;
                definition.description = "It's the Easter bunny's eggs!".getBytes();
                break;
            case 652:
                definition.objectModelIDs = new int[] {24004};
                definition.anIntArray776 = null;
                definition.name = "Easter Egg";
                definition.modifiedModelColors = new int[] { 0 };
                definition.originalModelColors = new int[] { 1 };
                definition.sizeX = 1;
                definition.sizeY = 1;
                definition.isUnwalkable = true;
                definition.aBoolean757 = true;
                definition.hasActions = true;
                definition.adjustToTerrain = false;
                definition.nonFlatShading = false;
                definition.aBoolean764 = false;
                definition.animationID = 354;
                definition.anInt775 = 16;
                definition.brightness = 15;
                definition.contrast = 0;
                definition.actions = new String[] { null, };
                definition.mapFunctionID = -1;
                definition.mapSceneID = -1;
                definition.aBoolean751 = false;
                definition.aBoolean779 = true;
                definition.modelSizeX = 228;
                definition.modelSizeH = 228;
                definition.modelSizeY = 228;
                definition.plane = 0;
                definition.offsetX = 0;
                definition.offsetH = 0;
                definition.offsetY = 0;
                definition.aBoolean736 = false;
                definition.isSolidObject = false;
                definition.anInt760 = 1;
                definition.varbitIndex = -1;
                definition.configID = -1;
                definition.configObjectIDs = null;
                definition.description = "It's the Easter bunny's eggs!".getBytes();
                break;

            case 653:
                definition.objectModelIDs = new int[] {24002};
                definition.anIntArray776 = null;
                definition.name = "Easter Egg";
                definition.modifiedModelColors = new int[] { 0 };
                definition.originalModelColors = new int[] { 1 };
                definition.sizeX = 1;
                definition.sizeY = 1;
                definition.isUnwalkable = true;
                definition.aBoolean757 = true;
                definition.hasActions = true;
                definition.adjustToTerrain = false;
                definition.nonFlatShading = false;
                definition.aBoolean764 = false;
                definition.animationID = 354;
                definition.anInt775 = 16;
                definition.brightness = 15;
                definition.contrast = 0;
                definition.actions = new String[] { null, };
                definition.mapFunctionID = -1;
                definition.mapSceneID = -1;
                definition.aBoolean751 = false;
                definition.aBoolean779 = true;
                definition.modelSizeX = 228;
                definition.modelSizeH = 228;
                definition.modelSizeY = 228;
                definition.plane = 0;
                definition.offsetX = 0;
                definition.offsetH = 0;
                definition.offsetY = 0;
                definition.aBoolean736 = false;
                definition.isSolidObject = false;
                definition.anInt760 = 1;
                definition.varbitIndex = -1;
                definition.configID = -1;
                definition.configObjectIDs = null;
                definition.description = "It's the Easter bunny's eggs!".getBytes();
                break;
            case 654:
                definition.objectModelIDs = new int[] {24001};
                definition.anIntArray776 = null;
                definition.name = "Easter Egg";
                definition.modifiedModelColors = new int[] { 0 };
                definition.originalModelColors = new int[] { 1 };
                definition.sizeX = 1;
                definition.sizeY = 1;
                definition.isUnwalkable = true;
                definition.aBoolean757 = true;
                definition.hasActions = true;
                definition.adjustToTerrain = false;
                definition.nonFlatShading = false;
                definition.aBoolean764 = false;
                definition.animationID = 354;
                definition.anInt775 = 16;
                definition.brightness = 15;
                definition.contrast = 0;
                definition.actions = new String[] { null, };
                definition.mapFunctionID = -1;
                definition.mapSceneID = -1;
                definition.aBoolean751 = false;
                definition.aBoolean779 = true;
                definition.modelSizeX = 228;
                definition.modelSizeH = 228;
                definition.modelSizeY = 228;
                definition.plane = 0;
                definition.offsetX = 0;
                definition.offsetH = 0;
                definition.offsetY = 0;
                definition.aBoolean736 = false;
                definition.isSolidObject = false;
                definition.anInt760 = 1;
                definition.varbitIndex = -1;
                definition.configID = -1;
                definition.configObjectIDs = null;
                definition.description = "It's the Easter bunny's eggs!".getBytes();
                break;
            /*
            case 9263:
                definition.modelSizeX = 228;
                definition.modelSizeH = 512;
                definition.modelSizeY = 228;
                break;
*/
        }

    }

    public static void dumpObjectModels() {
        dumpObjectModels(streamIndices);
        dumpObjectModels(streamIndices667);
    }

    public static void dumpObjectModels(int[] indices) {
        int dumped = 0, exceptions = 0;
        for(int i = 0; i < indices.length-1; i++) {
            ObjectDefinition object = forID(i);
            if(object == null)
                continue;
            if(object.objectModelIDs == null)
                continue;
            for(int model : object.objectModelIDs) {
                try {
                    byte abyte[] = clientInstance.decompressors[1].decompress(model);
                    File modelFile = new File(Signlink.getCacheDirectory().toString() + "/objectModels/" + model + ".gz");
                    FileOutputStream fos = new FileOutputStream(modelFile);
                    fos.write(abyte);
                    fos.close();
                    dumped++;
                } catch(Exception e) {
                    exceptions++;
                }
            }
        }
        System.out.println("Dumped "+dumped+" object models with "+exceptions+" exceptions.");
    }
}
package scc.mcpe.ServerPlugin.Essential.NPC;

import cn.nukkit.item.Item;
import cn.nukkit.level.Location;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Qing on 2020-01-28.
 */
public class NPCBase extends Location
{
    public static HashMap<String, NPCBase> npc = new HashMap();
    public static String nametag = "";
    public static long eid = 0;
    public Item handitem = null;
    public UUID uuid = null;

    public NPCBase(String nid, String tag, Item item, double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.eid = 0;
        this.handitem = item == null ? Item.get(0) : item;
        this.uuid = new UUID(new Random().nextLong(), new Random().nextLong());
    }

}

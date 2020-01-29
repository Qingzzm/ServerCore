package scc.mcpe.ServerPlugin.Essential.Window.Window;

import cn.nukkit.network.protocol.ModalFormRequestPacket;
import cn.nukkit.player.Player;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by Qing on 2020-01-28.
 */
public abstract class GUI {

    //public boolean close = false;

    public abstract String getJson();
    public abstract int getId();
    public abstract void onClose(Player player);

    private static HashMap<Integer, GUI> windows = new HashMap<Integer, GUI>();

    public Gson gson = new Gson();

    public static GUI send(Player player, GUI gui){
        int id = gui.getId();
        String json = gui.getJson();
        ModalFormRequestPacket packet = new ModalFormRequestPacket();
        packet.formId = id;
        packet.data = json;
        addWindow(id, gui);
        player.dataPacket(packet);
        return gui;
    }

    public int toId(String args){
        int n = 1, n2 = 0, n3 = args.length();
        char[] array = args.toCharArray();
        for (int i = 0; i < n3; ++i){
            n2 += array[i] + n;
            n *= 10;
        }
        return n2;
    }

    public static void addWindow(int id, GUI gui){
        windows.put(id,gui);
    }

    public static GUI getWindow(int id){
        return windows.get(id);
    }

    public static HashMap<Integer, GUI> getWindows(){
        return windows;
    }

    public static void removeWindow(int id){
        windows.remove(id);
    }



}

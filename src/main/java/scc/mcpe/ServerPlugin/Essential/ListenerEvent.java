package scc.mcpe.ServerPlugin.Essential;

import cn.nukkit.event.Listener;
import cn.nukkit.scheduler.Task;
import scc.mcpe.ServerPlugin.Core;

import java.util.ArrayList;

/**
 * Created by Qing on 2020-01-28.
 */
public class ListenerEvent extends Task {

    private static ArrayList<Listener> listener = new ArrayList<>();
    private static Core plugin;

    public static void addListener(Listener args){
        listener.add(args);
    }

    public static void echo(String info){
        plugin.getLogger().info(info);
    }

    public ListenerEvent(Core args){
        plugin = args;
    }

    @Override
    public void onRun (int i) {
        for (Listener list : listener){
            plugin.getServer().getPluginManager().registerEvents(list, plugin);
        }
    }
}

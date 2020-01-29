package scc.mcpe.ServerPlugin;

import cn.nukkit.plugin.PluginBase;
import scc.mcpe.ServerData.Mysql.MysqlDemo;
import scc.mcpe.ServerPlugin.Essential.ListenerEvent;
import scc.mcpe.ServerPlugin.Essential.Window.WindowBase;

public class Core extends PluginBase {
    public static MysqlDemo mysql;
    public static Core core;

    public void onLoad(){
        core = this;
    }

    public void onEnable(){
        this.getServer().getScheduler().scheduleDelayedTask(new ListenerEvent(this), 100);
        mysql=new MysqlDemo("127.0.0.1",3006,"nukkit","root","scc123");
        mysql.Connection();
        new WindowBase();

    }



}

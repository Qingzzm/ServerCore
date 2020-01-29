package scc.mcpe.ServerPlugin.Essential.Window.Window;

import cn.nukkit.player.Player;

import java.util.LinkedHashMap;

/**
 * Created by Qing on 2020-01-28.
 */
public abstract class FormModal extends GUI implements FormBack {

    private GUI backwin = null;
    private String title;
    private String button1 = "";
    private String button2 = "";
    private String content = "";
    //private Gson gson = new Gson();

    private LinkedHashMap<String, Object> data = new LinkedHashMap<>();

    public abstract void onButton1(Player player);
    public abstract void onButton2(Player player);
    public abstract void onEnter(Player player, int type);

    public FormModal(String txt){
        this(txt, "确认", "取消");
    }

    public FormModal(String txt, String button1, String button2){
        this.title = txt;
        this.button1 = button1;
        this.button2 = button2;
    }

    public void setTitle(String args){
        this.title = args;
    }

    public void setContent(String args){
        this.content = args;
    }

    @Override
    public String getJson() {
        this.data.put("type", "modal");
        this.data.put("title", this.title);
        this.data.put("content", this.content);
        this.data.put("button1", this.button1);
        this.data.put("button2", this.button2);
        return this.gson.toJson(this.data);
    }

    @Override
    public int getId() {
        return toId(this.title);
    }


    @Override
    public void goBack(Player player) {
        if(this.backwin != null){
            send(player, this.backwin);
        }
    }

    @Override
    public void setBack(GUI window) {
        this.backwin = window;
    }
}

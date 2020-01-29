package scc.mcpe.ServerPlugin.Essential.Window.Window;

import cn.nukkit.player.Player;
import scc.mcpe.ServerPlugin.Essential.Window.Element.ModuleButton;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Qing on 2020-01-28.
 */
public abstract class FormSimple extends GUI implements FormBack {

    private String title = "";
    private String content = "";
    private GUI backwin = null;

    private ArrayList<ModuleButton> buttons = new ArrayList<>();
    private LinkedHashMap<String, Object> data = new LinkedHashMap<>();


    public abstract void onEnter(Player player, int index, ModuleButton button);

    public FormSimple(String txt){
        this.title = txt;
    }

    public void addButton(ModuleButton button){
        this.buttons.add(button);
    }

    public void addButton(String button){
        this.buttons.add(new ModuleButton(button));
    }

    public void addButton(String button, String type, String data){
        this.buttons.add(new ModuleButton(button, type, data));
    }

    public void setTitle(String args){
        this.title = args;
    }

    public void setContent(String args){
        this.content = args;
    }

    public ModuleButton getButton(int i){
        return this.buttons.get(i);
    }

    @Override
    public String getJson() {
        this.data.put("type", "form");
        this.data.put("title", this.title);
        this.data.put("content", this.content);
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for(ModuleButton button : this.buttons){
            arrayList.add(button.getData());
        }
        this.data.put("buttons", arrayList);
        return this.gson.toJson(this.data);
    }

    @Override
    public int getId() {
        return this.toId(this.title);
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

package scc.mcpe.ServerPlugin.Essential.Window.Window;

import cn.nukkit.player.Player;
import scc.mcpe.ServerPlugin.Essential.Window.Element.Module;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Qing on 2020-01-28.
 */
public abstract class FormCustom extends GUI implements FormBack {

    private GUI backwin = null;
    private String title;
    //private Gson gson = new Gson();

    private LinkedHashMap<String, Object> data = new LinkedHashMap<>();
    private ArrayList<Module> elements = new ArrayList<>();

    public FormCustom(String args){
        this.title = args;
    }

    public void addElement(Module args){
        elements.add(args);
    }

    public List<Module> getElements(){
        return elements;
    }

   // public abstract void onEnter(Player player, );

    public abstract void onEnter(Player player, List<Object> obj, FormCustomRes res);

    @Override
    public int getId() {
        return toId(this.title);
    }

    @Override
    public String getJson() {
        this.data.put("type", "custom_form");
        this.data.put("title", this.title);
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
        for (Module element : this.elements){
            arrayList.add(element.getData());
        }
        this.data.put("content", arrayList);
        return this.gson.toJson(this.data);
    }

    public void setBack(GUI window) {
        this.backwin = window;
    }

    public void goBack(Player player) {
        if(this.backwin != null){
            send(player, this.backwin);
        }
    }

}

package scc.mcpe.ServerPlugin.Essential.Window.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qing on 2020-01-28.
 */
public class ModuleButton {

    private String name = "";
    private HashMap<String, Object> img = new HashMap<>();

    public ModuleButton(String txt){
        this(txt, "", "");
    }

    public ModuleButton(String txt, String imgtype, String imgdata){
        this.name = txt;
        this.img.put("data", imgdata);
        this.img.put("type", imgtype);
    }

    public String getButtonName(){
        return this.name;
    }

    public Map<String, Object> getData(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("text", this.name);
        map.put("data", this.img);
        return map;
    }

}

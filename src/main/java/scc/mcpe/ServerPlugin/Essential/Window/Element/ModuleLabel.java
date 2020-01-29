package scc.mcpe.ServerPlugin.Essential.Window.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qing on 2020-01-28.
 */
public class ModuleLabel implements Module {
    private String text;

    public ModuleLabel(String string) {
        this.text = string;
    }

    public ModuleLabel setText(String string) {
        this.text = string;
        return this;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public Map<String, Object> getData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("type", "label");
        hashMap.put("text", this.text);
        return hashMap;
    }

    @Override
    public String getType() {
        return "null";
    }
}

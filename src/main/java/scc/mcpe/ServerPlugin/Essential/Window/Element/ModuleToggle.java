package scc.mcpe.ServerPlugin.Essential.Window.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qing on 2020-01-28.
 */
public class ModuleToggle implements Module {
    private String text;
    private boolean defaultValue;

    public ModuleToggle(String string) {
        this(string, false);
    }

    public ModuleToggle(String string, boolean bl) {
        this.text = string;
        this.defaultValue = bl;
    }

    public ModuleToggle setText(String string) {
        this.text = string;
        return this;
    }

    public ModuleToggle setValue(boolean bl) {
        this.defaultValue = bl;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public boolean getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public Map<String, Object> getData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("type", "toggle");
        hashMap.put("text", this.text);
        hashMap.put("default", new Boolean(this.defaultValue));
        return hashMap;
    }

    @Override
    public String getType() {
        return "boolean";
    }
}

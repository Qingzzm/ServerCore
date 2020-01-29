package scc.mcpe.ServerPlugin.Essential.Window.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qing on 2020-01-28.
 */
public class ModuleInput implements Module {
    private String text;
    private String placeHolder;
    private String defaultText;

    public ModuleInput(String string) {
        this(string, "");
    }

    public ModuleInput(String string, String string2) {
        this(string, string2, "");
    }

    public ModuleInput(String string, String string2, String string3) {
        this.text = string;
        this.placeHolder = string2;
        this.defaultText = string3;
    }

    public ModuleInput setText(String string) {
        this.text = string;
        return this;
    }

    public ModuleInput setPlaceHolder(String string) {
        this.placeHolder = string;
        return this;
    }

    public ModuleInput setDefaultText(String string) {
        this.defaultText = string;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public String getPlaceHolder() {
        return this.placeHolder;
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    @Override
    public Map<String, Object> getData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("type", "input");
        hashMap.put("text", this.text);
        hashMap.put("placeholder", this.placeHolder);
        hashMap.put("default", this.defaultText);
        return hashMap;
    }

    @Override
    public String getType() {
        return "string";
    }
}

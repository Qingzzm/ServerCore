package scc.mcpe.ServerPlugin.Essential.Window.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Qing on 2020-01-28.
 */
public class ModuleDropdown implements Module {
    private String text;
    private List<String> options = new ArrayList<String>();
    private int defaultOptionIndex = 0;

    public ModuleDropdown(String string) {
        this(string, new ArrayList<String>());
    }

    public ModuleDropdown(String string, List<String> list) {
        this(string, list, 0);
    }

    public ModuleDropdown(String string, List<String> list, int n) {
        this.text = string;
        this.options = list;
        this.defaultOptionIndex = n;
    }

    public ModuleDropdown setText(String string) {
        this.text = string;
        return this;
    }

    public ModuleDropdown setDefaultOptionIndex(int n) {
        this.defaultOptionIndex = n;
        return this;
    }

    public ModuleDropdown setOption(List<String> list) {
        this.options = list;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public int getDefaultOptionIndex() {
        return this.defaultOptionIndex;
    }

    public ModuleDropdown addOption(String string) {
        this.options.add(string);
        return this;
    }

    public ModuleDropdown removeOption(String string) {
        if (this.options.contains(string)) {
            this.options.remove(string);
        }
        return this;
    }

    public ModuleDropdown resetOption() {
        this.options.clear();
        return this;
    }

    public int getOptionSize() {
        return this.options.size();
    }

    @Override
    public Map<String, Object> getData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("type", "dropdown");
        hashMap.put("text", this.text);
        hashMap.put("options", this.options);
        hashMap.put("default", new Integer(this.defaultOptionIndex));
        return hashMap;
    }

    @Override
    public String getType() {
        return "int";
    }
}

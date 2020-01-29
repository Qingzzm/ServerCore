package scc.mcpe.ServerPlugin.Essential.Window.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Qing on 2020-01-28.
 */
public class ModuleStepSlider implements Module {
    private List<String> steps = new ArrayList<>();
    private int defaultIndex;
    private String text;

    public ModuleStepSlider(String string) {
        this(string, new ArrayList<String>());
    }

    public ModuleStepSlider(String string, List<String> list) {
        this(string, list, 0);
    }

    public ModuleStepSlider(String string, List<String> list, int n) {
        this.text = string;
        this.steps = list;
        this.defaultIndex = n;
    }

    public ModuleStepSlider setText(String string) {
        this.text = string;
        return this;
    }

    public ModuleStepSlider setSteps(List<String> list) {
        this.steps = list;
        return this;
    }

    public ModuleStepSlider setDefaultIndex(int n) {
        this.defaultIndex = n;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public List<String> getSteps() {
        return this.steps;
    }

    public int getDefaultIndex() {
        return this.defaultIndex;
    }

    public ModuleStepSlider addStep(String string) {
        if (!this.steps.contains(this.steps)) {
            this.steps.add(string);
        }
        return this;
    }

    public ModuleStepSlider removeStep(int n) {
        if (this.steps.contains(new Integer(n))) {
            this.steps.remove(new Integer(n));
        }
        return this;
    }

    public ModuleStepSlider removeSteps() {
        this.steps.clear();
        return this;
    }

    @Override
    public Map<String, Object> getData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("type", "step_slider");
        hashMap.put("text", this.text);
        hashMap.put("steps", this.steps);
        hashMap.put("default", new Integer(this.defaultIndex));
        return hashMap;
    }

    @Override
    public String getType() {
        return "int";
    }
}

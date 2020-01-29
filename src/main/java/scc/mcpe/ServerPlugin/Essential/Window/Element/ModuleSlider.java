package scc.mcpe.ServerPlugin.Essential.Window.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qing on 2020-01-28.
 */
public class ModuleSlider implements Module {
    private String text;
    private float min = 0.0f;
    private float max = 0.0f;
    private float step = 0.0f;
    private float defaultValue = 0.0f;

    public ModuleSlider(String string) {
        this(string, 0.0f);
    }

    public ModuleSlider(String string, float f) {
        this(string, 0, f);
    }

    public ModuleSlider(String string, float f, float f2) {
        this(string, f, f2, 0.0f);
    }

    public ModuleSlider(String string, float f, float f2, float f3) {
        this(string, f, f2, f3, 0.0f);
    }

    public ModuleSlider(String string, float f, float f2, float f3, float f4) {
        this.text = string;
        this.min = f;
        this.max = f2;
        this.step = f3;
        this.defaultValue = f4;
    }

    public ModuleSlider setText(String string) {
        this.text = string;
        return this;
    }

    public ModuleSlider setMin(float f) {
        this.min = f;
        return this;
    }

    public ModuleSlider setMax(float f) {
        this.max = f;
        return this;
    }

    public ModuleSlider setStep(float f) {
        this.step = f;
        return this;
    }

    public ModuleSlider setDefaultValue(float f) {
        this.defaultValue = f;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public float getMin() {
        return this.min;
    }

    public float getMax() {
        return this.max;
    }

    public float getStep() {
        return this.step;
    }

    public float getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public Map<String, Object> getData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("type", "slider");
        hashMap.put("text", this.text);
        hashMap.put("min", new Float(this.min));
        hashMap.put("max", new Float(this.max));
        if (this.step > 0) {
            hashMap.put("step", new Float(this.step));
        }
        if (this.defaultValue != this.min) {
            hashMap.put("default", new Float(this.defaultValue));
        }
        return hashMap;
    }

    @Override
    public String getType() {
        return "float";
    }
}

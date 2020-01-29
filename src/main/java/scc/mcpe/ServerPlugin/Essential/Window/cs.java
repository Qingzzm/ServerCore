package scc.mcpe.ServerPlugin.Essential.Window;

import cn.nukkit.player.Player;
import scc.mcpe.ServerPlugin.Essential.Window.Element.*;
import scc.mcpe.ServerPlugin.Essential.Window.Window.FormCustom;
import scc.mcpe.ServerPlugin.Essential.Window.Window.FormCustomRes;

import java.util.List;

/**
 * Created by Qing on 2020-01-28.
 */
public class cs extends FormCustom {

    public cs(){
        super("测试测试");
        //addElement(new ModuleDropdown("这个是啥"));
        addElement(new ModuleInput("不知道","福ID发hiu"));
        addElement(new ModuleLabel("什么标签"));
        addElement(new ModuleSlider("鬼东西",5,0));
        //addElement(new ModuleStepSlider("踩你妈"));
        addElement(new ModuleToggle("好像是开关"));
    }

    @Override
    public void onClose(Player player) {
        player.sendMessage("你关闭了这个窗口");
    }

    @Override
    public void onEnter(Player player, List<Object> obj, FormCustomRes res) {
       player.sendMessage("输出： " + res.getInputResponse(0));
    }
}

package scc.mcpe.ServerPlugin.Essential.Window;

import cn.nukkit.player.Player;
import scc.mcpe.ServerPlugin.Essential.Window.Element.ModuleButton;
import scc.mcpe.ServerPlugin.Essential.Window.Window.FormSimple;

public class cs2 extends FormSimple {


    public cs2(String txt) {
        super(txt);
        setBack(new cs());
        setContent("啦啦啦拉拉肥晚饭后覅一万佛湖问问覅维护费喷雾粉红色可拉倒吧V领不次");
        addButton("按钮1");
        addButton("返回");
        addButton("测试3");
    }

    @Override
    public void onClose(Player player) {
        player.sendMessage("你关闭了这个窗口");
        send(player,this);
    }

    @Override
    public void onEnter(Player player, int index, ModuleButton button) {
        if(button.getButtonName().equals("按钮1")){
            send(player, new cs3(button.getButtonName()));
        }else
        if(index == 1){
            goBack(player);
        }else{
            player.sendMessage("你点击了 " + button.getButtonName());
        }
    }
}

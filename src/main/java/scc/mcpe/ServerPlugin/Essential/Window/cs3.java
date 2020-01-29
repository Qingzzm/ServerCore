package scc.mcpe.ServerPlugin.Essential.Window;

import cn.nukkit.player.Player;
import scc.mcpe.ServerPlugin.Essential.Window.Window.FormModal;

public class cs3 extends FormModal {
    public cs3(String txt) {
        super(txt);
        setContent("233333但从按到");
    }

    @Override
    public void onButton1(Player player) {
        player.sendMessage("你点击了按钮111111111");
    }

    @Override
    public void onButton2(Player player) {
        player.sendMessage("你点击了按钮222222222");
    }

    @Override
    public void onEnter(Player player, int type) {
        if(type == 0){
            send(player, new cs());
        }else{
            send(player, new cs2("宜宾弯曲"));
        }
    }

    @Override
    public void onClose(Player player) {
        player.sendMessage("你关闭了这个窗口");
    }
}

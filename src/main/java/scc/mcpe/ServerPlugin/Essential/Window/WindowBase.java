package scc.mcpe.ServerPlugin.Essential.Window;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.form.response.FormResponseData;
import cn.nukkit.network.protocol.ModalFormResponsePacket;
import cn.nukkit.player.Player;
import scc.mcpe.ServerPlugin.Essential.ListenerEvent;
import scc.mcpe.ServerPlugin.Essential.Window.Element.*;
import scc.mcpe.ServerPlugin.Essential.Window.Window.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Qing on 2020-01-28.
 */
public class WindowBase implements Listener{

    public WindowBase(){
        ListenerEvent.addListener(this);
        ListenerEvent.echo("GUI功能开启中");
    }
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        //Core.mysql.getResult("");
        GUI.send(event.getPlayer(), new cs2("付社保费率"));
    }

    @EventHandler
    public void onReceive(DataPacketReceiveEvent event){
        if(!(event.getPacket() instanceof ModalFormResponsePacket)){
            return;
        }
        ModalFormResponsePacket packet = (ModalFormResponsePacket) event.getPacket();
        int id = packet.formId;
        Player player = event.getPlayer();
        GUI gui = GUI.getWindow(id);
        if(gui != null){
            String data = packet.data.trim();
            if(data.equals("null")){
                gui.onClose(player);
                return;
            }else{
                if(gui instanceof FormSimple){
                    ((FormSimple)gui).onEnter(player, Integer.valueOf(data), ((FormSimple)gui).getButton(Integer.valueOf(data)));
                }else if(gui instanceof FormModal){
                    if(data.contains("true")){
                        ((FormModal)gui).onButton1(player);
                        ((FormModal)gui).onEnter(player, 0);
                    }else{
                        ((FormModal)gui).onButton2(player);
                        ((FormModal)gui).onEnter(player, 1);
                    }

                }else if(gui instanceof FormCustom){
                    HashMap<Integer, FormResponseData> dropdownResponses = new HashMap<>();
                    HashMap<Integer, String> inputResponses = new HashMap<>();
                    HashMap<Integer, Float> sliderResponses = new HashMap<>();
                    HashMap<Integer, FormResponseData> stepSliderResponses = new HashMap<>();
                    HashMap<Integer, Boolean> toggleResponses = new HashMap<>();
                    HashMap<Integer, Object> responses = new HashMap<>();
                    HashMap<Integer, String> labelResponses = new HashMap<>();


                    String[] res = data.substring(1, data.length() -1).split(",");
                    ArrayList<Object> array = new ArrayList<Object>();
                    int count = 0;
                    for (Module element : ((FormCustom)gui).getElements()){
                        player.sendMessage(res[count]);
                        if(element instanceof ModuleDropdown){
                            String answer = ((ModuleDropdown) element).getOptions().get(Integer.parseInt(res[count]));
                            dropdownResponses.put(count, new FormResponseData(Integer.parseInt(res[count]), answer));
                            responses.put(count, answer);
                        }else if(element instanceof ModuleLabel){
                            labelResponses.put(count, ((ModuleLabel) element).getText());
                            responses.put(count, ((ModuleLabel) element).getText());
                        }else if(element instanceof ModuleInput){
                            inputResponses.put(count, res[count]);
                            responses.put(count, res[count]);
                        }else if(element instanceof ModuleSlider){
                            Float answer = Float.parseFloat(res[count]);
                            sliderResponses.put(count, answer);
                            responses.put(count, answer);
                        }else if(element instanceof ModuleStepSlider){
                            String answer = ((ModuleStepSlider) element).getSteps().get(Integer.parseInt(res[count]));
                            stepSliderResponses.put(count, new FormResponseData(Integer.parseInt(res[count]), answer));
                            responses.put(count, answer);
                        }else if(element instanceof ModuleToggle){
                            Boolean answer = Boolean.parseBoolean(res[count]);
                            toggleResponses.put(count, answer);
                            responses.put(count, answer);
                        }

                       String type = element.getType();
                        if(type.equals("string")){
                            array.add(res[count].substring(1,res[count].length() - 1));
                        }else if(type.equals("int")){
                            array.add(new Integer(Integer.parseInt(res[count])));
                        }else if(type.equals("float")){
                            array.add(new Float(Float.parseFloat(res[count])));
                        }else if(type.equals("boolean")){
                            array.add(new Boolean(Boolean.parseBoolean(res[count])));
                        }else{
                            array.add("null");
                        }
                        ++count;
                    }
                    ((FormCustom)gui).onEnter(player, array, new FormCustomRes(responses, dropdownResponses, inputResponses,
                            sliderResponses, stepSliderResponses, toggleResponses, labelResponses));
                }
                GUI.removeWindow(id);
            }


        }
    }
}

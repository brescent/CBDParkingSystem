package com.project.controller;

import com.project.entity.MessageEntity;
import com.project.entity.PublicUserEntity;
import com.project.service.CheckService;
import com.project.util.SendMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CheckController {

    @Autowired
    private CheckService checkService;

    @Autowired
    private SendMsgUtil sendMsgUtil;

    @RequestMapping("getWebAllPart")
    public String getAllWebPart() {

        String string = checkService.getAllPact();

        return string;
    }

    @RequestMapping("getPartById")
    public String getPartById(@RequestParam("partId") Integer partId) {
        String string = checkService.getPartById(partId);
        return string;
    }

    @RequestMapping("updCheckType")
    public String updCheckType(Integer partId, Integer state, Integer customerId, Integer userId) {


        try {
            checkService.updCheckType(partId, state);
            String string = null;
            if (state == 1) {
                string = "编号为" + partId + "的合同审核已经通过";
            } else {
                string = "编号为" + partId + "的合同审核被拒绝";
            }

            //发送人-->管理员
            PublicUserEntity sender = new PublicUserEntity();
            sender.setId(242);

            //接收人1 -->买家
            PublicUserEntity received = new PublicUserEntity();
            received.setId(customerId);

            //接收人2-->卖家
            PublicUserEntity received2 = new PublicUserEntity();
            received2.setId(userId);

            //给买家发送消息
            MessageEntity messageEntity = new MessageEntity(string, 1, received, sender);
            sendMsgUtil.sendMessage(messageEntity);
            //给卖家发送消息
            MessageEntity messageEntity2 = new MessageEntity(string, 1, received, sender);
            sendMsgUtil.sendMessage(messageEntity2);

            return "1";

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    /**
     * 查询所有待审核的招租信息
     *
     * @return
     */
    @RequestMapping("getAllMsg")
    public String getAllMsg() {

        String string = checkService.getAllMsg();
        return string;
    }

    /**
     * 根据id查询招租信息
     *
     * @return
     */
    @RequestMapping("getMsgById")
    public String getMsgById(int id) {
        Map map = new HashMap();
        map.put("id",id);
        String string = checkService.getMsgById(map);
        return string;

    }

    /**
     * 修改招租信息审核状态
     *
     * @return
     */
    @RequestMapping("udpMsgType")
    public String udpMsgType(Integer id, Integer state,Integer userId) {

        try {
            checkService.udpMsgType(id,state);
            String string = null;
            if (state == 1) {
                string = "编号为" + id + "的招租申请已经通过";
            } else {
                string = "编号为" + id + "的招租申请被拒绝";
            }

//            //发送人-->管理员
//            PublicUserEntity sender = new PublicUserEntity();
//            sender.setId(242);
//
//            //接收人-->出租人
//            PublicUserEntity received = new PublicUserEntity();
//            received.setId(userId);
//
//            MessageEntity messageEntity = new MessageEntity(string, 1, received, sender);
//            sendMsgUtil.sendMessage(messageEntity);

            return "1";
        } catch (Exception e) {

            return "0";
        }

    }


}

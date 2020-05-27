package com.project.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("frontService")
public interface CheckService {

    /**
     * 查询所有合同
     *
     * @return
     */
    @RequestMapping("/getAllPact")
    public String getAllPact();

    /**
     * 根据id获取合同
     * @param partId
     * @return
     */
    @RequestMapping("/getPactById")
    public String getPartById(@RequestParam("id") Integer partId);

    /**
     * 修改合同审核状态
     * @param partId
     * @param state
     * @return
     */
    @RequestMapping("/updatePact")
    public String updCheckType(@RequestParam("id") Integer partId,@RequestParam("state") Integer state );

    /**
     * 查询所有待审核的招租信息
     * @return
     */
    @RequestMapping("/getAllDeallist")
    public String getAllMsg();

    /**
     * 根据id查询招租信息
     * @return
     */
    @RequestMapping("/detDealById")
    public String getMsgById(@RequestBody Map map);

    /**
     * 修改招租信息审核状态
     * @return
     */
    @RequestMapping("/updateDealById")
    public String udpMsgType(@RequestParam("id") Integer id,@RequestParam("state") Integer state) ;

}

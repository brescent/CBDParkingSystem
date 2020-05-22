package Test;

import com.alibaba.fastjson.JSON;
import com.project.FrontServiceSystemMain;
import com.project.entity.FrontDealEntity;
import com.project.entity.FrontStallEntity;
import com.project.entity.FrontUserInfoEntity;
import com.project.service.IUserInfoService;
import com.project.service.impl.BookingServiceImpl;
import com.project.service.impl.OrderServiceIml;
import com.project.service.impl.SellServiceImpl;
import com.project.vo.ShowDealTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = FrontServiceSystemMain.class)
public class addSell {

    @Autowired
    private SellServiceImpl sellService;

    @Autowired
    private BookingServiceImpl bookingService;

    @Autowired
    private IUserInfoService iUserInfoService;

    @Autowired
    private OrderServiceIml orderServiceIml;

    @Test
    public void addsellTest(){
        FrontDealEntity frontDealEntity = new FrontDealEntity();
        FrontStallEntity stallEntity = new FrontStallEntity();

        Optional<FrontUserInfoEntity> userInfoEntity = iUserInfoService.findByIdUserinfo(3);

        stallEntity.setStallAddress("成都市天府三街15号中海兰亭小区");
        stallEntity.setStallNum("E563");
        stallEntity.setStallState(0);
        stallEntity.setStallPhoto("5.jpg");
        stallEntity.setIDNum(userInfoEntity.get().getIDNum());
        stallEntity.setStall(userInfoEntity.get());

        frontDealEntity.setDealPrice(32000);
        frontDealEntity.setDealState(0);
        frontDealEntity.setDealType(1);
        frontDealEntity.setFrontStallId(stallEntity);


        sellService.saveReleaseSell(stallEntity);
        sellService.saveDealInfo(frontDealEntity);
    }

    @Test
    public void saveSellorder(){
//        FrontOrderEntity frontOrderEntity = new FrontOrderEntity();
////        FrontDealEntity frontDealEntity = sellService.getDealById(2);
//        Optional<FrontUserInfoEntity> userInfoEntity = iUserInfoService.findByIdUserinfo(2);
//
//        frontOrderEntity.setMessage("我想购买车位");
//        frontOrderEntity.setOrderState(0);
//        frontOrderEntity.setFrontDealEntity(frontDealEntity);
//        frontOrderEntity.setFrontUserInfoId(userInfoEntity.get());
//
//        bookingService.saveOrder(frontOrderEntity);

    }
    @Test
    public  void  getAllDeal(){
//
//        List<FrontDealEntity> list = sellService.getAllByDealEndDate();
//
//        for (FrontDealEntity fr:list){
//
//        }

//        List<ShowDealDto> list = sellService.getAllDeal();
//
//        String list1 = JSON.toJSONString(list);
//
//        System.out.println(list1);

        List<ShowDealTwo.showDealTwoVo> list = sellService.getDealById(2);
        String list1 = JSON.toJSONString(list);
        System.out.println(list1);

    }

    @Test
    public void savePact(){

    }

    @Test
    public void  saveOrder(){
        orderServiceIml.saveOrder("买车位",3);
    }

}

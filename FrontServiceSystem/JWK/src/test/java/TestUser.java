import com.project.ClientMain;
import com.project.dao.DealDao;
import com.project.dao.StallDao;
import com.project.dao.UserDao;
import com.project.entity.FrontDealEntity;
import com.project.entity.FrontOrderEntity;
import com.project.entity.FrontStallEntity;
import com.project.entity.FrontUserInfoEntity;
import com.project.service.impl.DealServicempl;
import com.project.service.impl.OrderServicempl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =ClientMain.class)
public class TestUser {
    @Autowired
 public    UserDao userDao;

    @Autowired
    public StallDao stallDao;
    @Autowired
    public DealServicempl dealDao;
    @Autowired
    public OrderServicempl orderDao;
    @Test
public  void  test1(){
        FrontUserInfoEntity frontUserInfoEntity=new FrontUserInfoEntity("职业1","下明1","用小明1","211111115",null);


        userDao.save(frontUserInfoEntity);

}
@Test
    public  void  teststall(){
       Optional<FrontUserInfoEntity> frontUserInfoEntity=userDao.findById(1);
      stallDao.save(new FrontStallEntity("25541","风小区1","空闲2","4.lpg","b084",1,"5111125",frontUserInfoEntity.get()));

    }

    @Test
    public  void  testdeal() throws ParseException {
       FrontStallEntity f=   stallDao.findById(1).get();
       Date d=new Date((new SimpleDateFormat("yyyy-MM-dd")).parse("2017-10-10").getTime());
        dealDao.addDeal(new FrontDealEntity(100,d,d,0,null,0,f));
    }
    @Test
    @Transactional
    public  void  testorder()  {
//      FrontDealEntity deal= dealDao.selDeal(1);
//     FrontUserInfoEntity user=userDao.findById(1).get();
//
//      orderDao.addOrder(new FrontOrderEntity(0,"我想买",user,deal));

        System.out.println(orderDao.orderByUserid(1));

    }
}

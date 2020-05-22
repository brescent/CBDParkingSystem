package Test;

import com.project.FrontServiceSystemMain;
import com.project.entity.FrontUserInfoEntity;
import com.project.service.IUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FrontServiceSystemMain.class)
public class userInfoTest {

    @Autowired
    private IUserInfoService iUserInfoService;

    @Test
    public void getUserinfo(){
        Optional<FrontUserInfoEntity> frontUserInfoEntity = iUserInfoService.findByIdUserinfo(1);
        System.out.println(frontUserInfoEntity);
    }
}

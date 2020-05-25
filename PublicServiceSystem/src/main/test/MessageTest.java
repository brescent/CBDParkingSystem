import com.project.PublicUserServiceMain;
import com.project.entity.MessageEntity;
import com.project.util.SendMsgUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PublicUserServiceMain.class)
public class MessageTest {


    @Autowired
    private SendMsgUtil messageUtil;


    @Test
    public void t(){

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessageInfo("c测试");
        messageUtil.sendStr("messageEntity");
    }
}

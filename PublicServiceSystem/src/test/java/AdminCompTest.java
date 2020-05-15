import com.project.PublicUserServiceMain;
import com.project.Service.IAdminService;
import com.project.Service.ICompanyUserService;
import com.project.Service.IPowerService;
import com.project.Service.IUserService;
import com.project.entity.CompanyUserEntity;
import com.project.entity.PageEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PublicUserServiceMain.class)
public class AdminCompTest {
    @Autowired
    private IUserService service;
    @Autowired
    private IPowerService powerServcie;
    @Autowired
    private IAdminService adminService;
    @Autowired
    private ICompanyUserService companyUserService;

    @Test
    public  void addCompany(){

        CompanyUserEntity userEntity =  new CompanyUserEntity(
                "中石油","火星","小白","123");

        companyUserService.addCompany(userEntity,"aaa","123");
    }

    @Test
    public void delCompany(){

        companyUserService.delCompany(1);
    }


    @Test
    public  void updCompany(){


        CompanyUserEntity userEntity =  new CompanyUserEntity(
                null,"","","456");
        userEntity.setId(1);

        companyUserService.addCompany(userEntity,"aaa","123");
    }

    @Test
    public  void findAll(){



    }

    @Test
    public void findID(){
        CompanyUserEntity companyUserEntity = companyUserService.getCompanyById(1);
        System.out.println(1);
    }

    @Test
    public void findUser(){
        CompanyUserEntity companyUserEntity = companyUserService.getCompanyUserById(1);
        System.out.println();
    }

    /**
     * 测试分页
     */
    @Test
    public void testPage(){

        PageEntity p = adminService.getAllAdmin(1,2);
        System.out.println();
    }
}

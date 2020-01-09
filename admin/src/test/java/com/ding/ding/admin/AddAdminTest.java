package com.ding.ding.admin;

import com.ding.ding.common.util.bcrypt.BCryptPasswordEncoder;
import com.ding.ding.db.domain.SysAdmin;
import com.ding.ding.db.service.SysAdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AddAdminTest {

    @Autowired
    private SysAdminService adminService;

    @Test
    public void test() {
        String rawPassword = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setPassword(encodedPassword);
        sysAdmin.setUsername("admin");
        sysAdmin.setAvatar("https://www.baidu.com");
        adminService.save(sysAdmin);
    }

}

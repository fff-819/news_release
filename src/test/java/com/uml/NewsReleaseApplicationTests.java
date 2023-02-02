package com.uml;

import com.uml.mapper.AdministratorMapper;
import com.uml.pojo.Administrator;
import com.uml.pojo.User;
import com.uml.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class NewsReleaseApplicationTests {
    @Autowired
    AdministratorMapper administratorMapper;
    @Test
    void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",2);
        int i = administratorMapper.deleteByMap(map);
    }

}

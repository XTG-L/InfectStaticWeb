package team.infect.xtg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import team.infect.xtg.bean.Directory;
import team.infect.xtg.bean.Log;
import team.infect.xtg.bean.Region;
import team.infect.xtg.dao.DirectoryDAO;
import team.infect.xtg.dao.LogDAO;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;

import team.infect.xtg.model.testUser

@Controller
@RequestMapping("user")
public class IndexController {
    @RequestMapping("/list")
    public String getUserList(ModelMap map){
        List<testUser> list = new ArrayList<testUser>;
        for(int i=0;i<2;i++){
            testUser u=new testUser();
            u.setId(i+1);
            u.setName("牛"+i);
            list.add(u);
        }
        map.addAttribte("list",list)
        return "index";
    }
}

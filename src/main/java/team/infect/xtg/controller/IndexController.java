package team.infect.xtg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping(value="index.html", method=RequestMethod.GET)
    @ResponseBody
    public String index(Model model){
        model.addAttribute("name","xtg");
        return "/index";
    }
}

package team.infect.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.infect.dao.RegionDAO;
import team.infect.pojo.Region;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;


@Controller
public class IndexController {

    @RequestMapping("index")
    public String indexController(Model model) throws IOException, ParseException {
        RegionDAO regionDAO = new RegionDAO();
        List<Region> regions = regionDAO.getRegions();
        model.addAttribute("regions", regions);
        return "index";
    }

    @RequestMapping("/choseDate")
    public String choseController(Model model, @RequestParam String date) throws IOException, ParseException {
        RegionDAO regionDAO = new RegionDAO();
        List<Region> regions = regionDAO.getRegions(date);
        model.addAttribute("regions", regions);
        return "index";
    }

}

package team.infect.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.infect.dao.RegionDAO;
import team.infect.pojo.Region;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


@Controller
public class IndexController {

    @RequestMapping("index")
    public String dataController(Model model, @RequestParam String date) throws IOException, ParseException {
        RegionDAO regionDAO = new RegionDAO();
        List<Region> regions = regionDAO.getRegions(date);
        model.addAttribute("regions", regions);
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(regions);
        return "index";
    }

}

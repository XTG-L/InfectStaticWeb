package team.infect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import team.infect.dao.DirectoryDAO;
import team.infect.dao.LogDAO;
import team.infect.dao.RegionDAO;
import team.infect.pojo.Directory;
import team.infect.pojo.Log;
import team.infect.pojo.Region;
import team.infect.pojo.Type;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;


@Controller
public class IndexController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexController(Model model) throws IOException, ParseException {
        Directory directory = new Directory("src/main/log/");
        DirectoryDAO directoryDAO = new DirectoryDAO();
        directoryDAO.sortFiles(directory);
        List<Log> logs = directoryDAO.getLogList(directory);
        LogDAO logDAO = new LogDAO();
        List<Region> regions = logDAO.getRegionList(logs);
        RegionDAO regionDAO = new RegionDAO();
        regionDAO.complete(regions);
        model.addAttribute("regions", regions);
        Type[] types = {Type.ip, Type.sp, Type.dead, Type.cure};
        model.addAttribute("types", types);
        return "index";
    }

}

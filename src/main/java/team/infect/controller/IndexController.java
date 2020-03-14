package team.infect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.infect.dao.DirectoryDAO;
import team.infect.dao.LogDAO;
import team.infect.dao.RegionDAO;
import team.infect.pojo.Directory;
import team.infect.pojo.Log;
import team.infect.pojo.Region;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;


@Controller
public class IndexController {

    Directory directory;
    DirectoryDAO directoryDAO;
    List<Log> logs;
    LogDAO logDAO;
    List<Region> regions;
    RegionDAO regionDAO;

    public IndexController() throws IOException, ParseException {
        directory = new Directory("src/main/log/");
        directoryDAO = new DirectoryDAO();
        logDAO = new LogDAO();
        regionDAO = new RegionDAO();
        directoryDAO.sortFiles(directory);
        logs = directoryDAO.getLogList(directory);
        regions = logDAO.getRegionList(logs);
        regionDAO.complete(regions);
    }

    @RequestMapping("index")
    public String dataController(Model model, @RequestParam String date) throws IOException, ParseException {
        logs = directoryDAO.getLogList(directory, date);
        regions = logDAO.getRegionList(logs);
        regionDAO.complete(regions);
        model.addAttribute("regions", regions);
        model.addAttribute("logs",logs);
        model.addAttribute("para", date + ".log.txt");
        return "index";
    }

}

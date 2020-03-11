package team.infect.xtg.controller;

import org.springframework.web.bind.annotation.RequestParam;
import team.infect.xtg.bean.Directory;
import team.infect.xtg.bean.Log;
import team.infect.xtg.bean.Region;
import team.infect.xtg.dao.DirectoryDAO;
import team.infect.xtg.dao.LogDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class MapController {

    @RequestMapping(value = "map", method = RequestMethod.GET)
    public String map(Model model, @RequestParam("date") String date) throws IOException, ParseException {
        Directory directory = new Directory("src/main/log/");
        DirectoryDAO directoryDAO = new DirectoryDAO();
        directoryDAO.sortFiles(directory);
        List<Log> logs = directoryDAO.getLogList(directory, date);
        LogDAO logDAO = new LogDAO();
        List<Region> regions = logDAO.getRegionList(logs);
        model.addAttribute("regions", regions);
        return "map";
    }
}

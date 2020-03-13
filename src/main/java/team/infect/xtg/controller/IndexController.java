package team.infect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

//    @RequestMapping(value = "index", method = RequestMethod.GET)
//    public String indexController(Model model, @RequestParam("date") String date) throws IOException, ParseException {
//        Directory directory = new Directory("src/main/log/");
//        DirectoryDAO directoryDAO = new DirectoryDAO();
//        directoryDAO.sortFiles(directory);
//        List<Log> logs = directoryDAO.getLogList(directory, date);
//        LogDAO logDAO = new LogDAO();
//        List<Region> regions = logDAO.getRegionList(logs);
//        model.addAttribute("regions", regions);
//        return "index";
//    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            messages.add("message:" + i);
        }
        model.addAttribute("messages", messages);
        return "index";
    }

}
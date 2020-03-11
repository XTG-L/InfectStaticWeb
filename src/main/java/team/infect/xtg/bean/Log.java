package team.infect.xtg.bean;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    String path;
    String name;
    Date date;

    public Log(String path, String name) throws ParseException, IOException {
        this.path = path;
        this.name = name;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date = simpleDateFormat.parse(name.replaceAll(".log.txt", ""));
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}

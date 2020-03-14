package team.infect.dao;

import team.infect.pojo.Directory;
import team.infect.pojo.Log;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DirectoryDAO {

    /**
     * 将指定的文件夹类中的文件按名排序
     * @param directory 指定文件夹类
     */
    public void sortFiles(Directory directory) {
        String[] files = directory.getFiles();
        if (files.length == 0) return;
        List<String> filesList = new ArrayList<>(Arrays.asList(files));
        Collections.sort(filesList);
    }

    /**
     * 将将指定日期后的文件名替换为""
     * @param files 文件名字符串组
     * @param date 指定日期
     */
    public void rmAfter(String[] files, String date) {
        if (files.length == 0) return;
        String[] temps = files.clone();
        for (int i = 0; i <temps.length; i++) {
            if (temps[i].compareTo(date + ".log.txt") > 0) {
                files[i] = "";
            }
        }
    }

    /**
     * 读取指定文件夹类中的日志文件，返回日志列表
     * @param directory 指定文件夹类
     * @return 日志列表
     * @throws ParseException Log类构造函数进行类型转换
     * @throws IOException Log类构造函数中读取日志文件
     */
    public List<Log> getLogList(Directory directory) throws ParseException, IOException {
        return getLogList(directory, null);
    }

    /**
     * 读取指定文件夹类中指定日期前的日志文件，返回日志列表
     * @param directory 指定文件夹类
     * @param date 指定日期
     * @return 日志列表
     * @throws ParseException Log类构造函数进行类型转换
     * @throws IOException Log类构造函数中读取日志文件
     */
    public List<Log> getLogList(Directory directory, String date) throws ParseException, IOException {
        List<Log> logs = new ArrayList<>();
        String[] files = directory.getFiles();
        if (date != null)
            rmAfter(files, date);
        for (String file: files) {
            if (!file.equals(""))
                logs.add(new Log(directory.getPath(), file));
        }
        return logs;
    }
}

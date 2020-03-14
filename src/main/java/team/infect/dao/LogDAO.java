package team.infect.dao;

import team.infect.pojo.Log;
import team.infect.pojo.Region;
import team.infect.pojo.Type;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LogDAO {

    /**
     * 将日志类列表转换为地区类列表
     * @param logs 指定日志类列表
     * @return 地区类列表
     */
    public List<Region> getRegionList(List<Log> logs) throws IOException {
        List<Region> regions = new ArrayList<>();
        if (logs == null) return regions;
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        for (Log log : logs) {
            fileInputStream = new FileInputStream(log.getPath() + log.getName());
            inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
                handleLine(line, regions);
        }
        if (bufferedReader != null)
            bufferedReader.close();
        if (inputStreamReader != null)
            inputStreamReader.close();
        if (fileInputStream != null)
            fileInputStream.close();
        for (Region region : regions)
            region.count();
        return regions;
    }

    /**
     * 处理一行日志，转化为地区类并存储在地区列表中
     * @param line 日志行
     * @param regions 地区列表
     * @return 日志行分割结果
     */
    public String[] handleLine(String line, List<Region> regions) {
        String[] items = null;
        RegionDAO regionDAO = new RegionDAO();
        if (line.matches("(\\S+) 新增 感染患者 (\\d+)人")) {
            items = line.split(" 新增 感染患者 |人");
            regionDAO.update(regions, items[0], Type.ip, Integer.parseInt(items[1]));
        } else if (line.matches("(\\S+) 新增 疑似患者 (\\d+)人")) {
            items = line.split(" 新增 疑似患者 |人");
            regionDAO.update(regions, items[0], Type.sp, Integer.parseInt(items[1]));
        } else if (line.matches("(\\S+) 感染患者 流入 (\\S+) (\\d+)人")) {
            items = line.split(" 感染患者 流入 | |人");
            regionDAO.update(regions, items[0], Type.ip, Integer.parseInt(items[2]));
            regionDAO.update(regions, items[1], Type.ip, Integer.parseInt("-" + items[1]));
        } else if (line.matches("(\\S+) 疑似患者 流入 (\\S+) (\\d+)人")) {
            items = line.split(" 疑似患者 流入 | |人");
            regionDAO.update(regions, items[0], Type.sp, Integer.parseInt(items[2]));
            regionDAO.update(regions, items[0], Type.sp, Integer.parseInt("-" + items[2]));
        } else if (line.matches("(\\S+) 死亡 (\\d+)人")) {
            items = line.split(" 死亡 |人");
            regionDAO.update(regions, items[0], Type.dead, Integer.parseInt(items[1]));
        } else if (line.matches("(\\S+) 治愈 (\\d+)人")) {
            items = line.split(" 治愈 |人");
            regionDAO.update(regions, items[0], Type.cure, Integer.parseInt(items[1]));
        } else if (line.matches("(\\S+) 疑似患者 确诊感染 (\\d+)人")) {
            items = line.split(" 疑似患者 确诊感染 |人");
            regionDAO.update(regions, items[0], Type.ip, Integer.parseInt(items[1]));
            regionDAO.update(regions, items[0], Type.sp, Integer.parseInt("-" + items[1]));
        } else if (line.matches("(\\S+) 排除 疑似患者 (\\d+)人")) {
            items = line.split(" 排除 疑似患者 |人");
            regionDAO.update(regions, items[0], Type.sp, Integer.parseInt("-" + items[1]));
        }
        return items;
    }
}

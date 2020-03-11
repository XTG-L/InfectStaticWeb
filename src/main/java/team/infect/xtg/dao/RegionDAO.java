package team.infect.xtg.dao;

import team.infect.xtg.bean.Region;
import team.infect.xtg.bean.Type;

import java.util.List;

public class RegionDAO {

    /**
     * 更新指定地区列表中指定地区指定数值的数据
     * @param regions 指定地区列表
     * @param name 指定地区的名称
     * @param type 指定的类型
     * @param num 数值
     */
    public void update(List<Region> regions, String name, Type type, int num) {
        Region tmp = new Region(name);
        if (!regions.contains(new Region(name)))
            regions.add(new Region(name));
        int index = regions.indexOf(tmp);
        Region region = regions.get(index);
        if (type.equals(Type.ip)) {
            region.getIp().add(num);
        } else if (type.equals(Type.sp)) {
            region.getSp().add(num);
        } else if (type.equals(Type.cure)) {
            region.getCure().add(num);
        } else if (type.equals(Type.dead)) {
            region.getDead().add(num);
        }
    }
}

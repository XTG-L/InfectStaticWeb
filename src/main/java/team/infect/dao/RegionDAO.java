package team.infect.dao;

import team.infect.pojo.Region;
import team.infect.pojo.Type;

import java.util.List;

public class RegionDAO {

    static final String [] regionNames = {
            "北京", "天津", "上海", "重庆", "河北", "河南", "云南", "辽宁", "黑龙江",
            "湖南", "安徽", "山东", "新疆", "江苏", "浙江", "江西", "湖北", "广西",
            "甘肃", "山西", "内蒙古", "陕西", "吉林", "福建", "贵州", "广东", "青海",
            "西藏", "四川", "宁夏", "海南", "台湾", "香港", "澳门"
    };

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
        if (type.equals(Type.ip))
            region.getIp().add(num);
        else if (type.equals(Type.sp))
            region.getSp().add(num);
        else if (type.equals(Type.cure))
            region.getCure().add(num);
        else if (type.equals(Type.dead))
            region.getDead().add(num);
    }

    public void complete(List<Region> regions) {
        for (String regionName: regionNames) {
            Region region = new Region(regionName);
            if (!regions.contains(region))
                regions.add(region);
        }
    }
}

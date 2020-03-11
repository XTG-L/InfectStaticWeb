package team.infect.xtg.bean;

import java.util.ArrayList;
import java.util.List;

public class Region {
    String name;
    List<Integer> ip, sp, cure, dead;

    public Region(String name) {
        this.name = name;
        ip = new ArrayList<>();
        sp = new ArrayList<>();
        cure = new ArrayList<>();
        dead = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getIp() {
        return this.ip;
    }

    public List<Integer> getSp() {
        return this.sp;
    }

    public List<Integer>getCure() {
        return this.cure;
    }

    public List<Integer> getDead() { return this.dead; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            Region region = (Region) obj;
            return this.name.equals(region.name);
        }
        return super.equals(obj);
    }

    /**
     * 获取指定地区指定类型的数值总数
     * @param region 指定地区
     * @param type 指定类型
     * @return 数值总数
     */
    public int count(Region region, Type type) {
        int sum = 0;
        if (type.equals(Type.ip))
            for (int num : region.getIp())
                sum += num;
        else if (type.equals(Type.sp))
            for (int num : region.getSp())
                sum += num;
        else if (type.equals(Type.dead))
            for (int num : region.getDead())
                sum += num;
        else if (type.equals(Type.cure))
            for (int num : region.getCure())
                sum += num;
        return sum;
    }
}

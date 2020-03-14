package team.infect.pojo;

import java.util.ArrayList;
import java.util.List;

public class Region {
    String name;
    List<Integer> ip, sp, cure, dead;

    public Region() {};

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

    public int countIp() {
        int sum = 0;
        for (int num : this.ip) {
            sum += num;
        }
        return sum;
    }

    public int countSp() {
        int sum = 0;
        for (int num : this.sp) {
            sum += num;
        }
        return sum;
    }

    public int countDead() {
        int sum = 0;
        for (int num : this.dead) {
            sum += num;
        }
        return sum;
    }

    public int countCure() {
        int sum = 0;
        for (int num : this.cure) {
            sum += num;
        }
        return sum;
    }
    /**
     * 获取指定地区指定类型的数值总数
     * @param type 指定类型
     * @return 数值总数
     */
    public int count(Type type) {
        int sum = 0;
        if (type.equals(Type.ip)) {
            for (int num : this.ip) {
                sum += num;
            }
        }
        else if (type.equals(Type.sp)) {
            for (int num : this.sp) {
                sum += num;
            }
        }
        else if (type.equals(Type.dead)) {
            for (int num : this.dead) {
                sum += num;
            }
        }
        else if (type.equals(Type.cure)) {
            for (int num : this.cure) {
                sum += num;
            }
        }
        return sum;
    }
}

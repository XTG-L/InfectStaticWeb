package team.infect.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

public class Region {
    @JSONField
    String name;
    @JSONField
    List<Integer> ipList, spList, cureList, deadList;
    @JSONField
    int ip;
    @JSONField
    int sp;
    @JSONField
    int cure;
    @JSONField
    int dead;

    public Region() {};

    public Region(String name) {
        this.name = name;
        ipList = new ArrayList<>();
        spList = new ArrayList<>();
        cureList = new ArrayList<>();
        deadList = new ArrayList<>();
    }

    @JSONField
    public String getName() {
        return this.name;
    }

    @JSONField
    public List<Integer> getIpList() {
        return this.ipList;
    }

    @JSONField
    public List<Integer> getSpList() {
        return this.spList;
    }

    @JSONField
    public List<Integer>getCureList() {
        return this.cureList;
    }

    @JSONField
    public List<Integer> getDeadList() { return this.deadList; }

    @JSONField
    public int getIp() {
        return this.ip;
    }

    @JSONField
    public int getSp() {
        return this.sp;
    }

    @JSONField
    public int getDead() {
        return this.dead;
    }

    @JSONField
    public int getCure() {
        return this.cure;
    }

    @JSONField
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            Region region = (Region) obj;
            return this.name.equals(region.name);
        }
        return super.equals(obj);
    }

    /**
     * 统计指定地区指定类型的数值总数
     */
    @JSONField
    public void count() {
        for (int num : this.ipList) {
            ip += num;
        }
        for (int num : this.spList) {
            sp += num;
        }
        for (int num : this.deadList) {
            dead += num;
        }
        for (int num : this.cureList) {
            cure += num;
        }
    }
}

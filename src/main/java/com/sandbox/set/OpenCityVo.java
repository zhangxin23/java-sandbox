package com.sandbox.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * User: zhangxin
 * Date: 2016-12-29
 * Time: 15:36:00
 */
public class OpenCityVO  implements Comparable<OpenCityVO>{
    private String city_name;

    private String city_pinyin;

    private long city_id;

    public OpenCityVO() {
    }

    public OpenCityVO(String city_name, String city_pinyin, long city_id) {
        this.city_name = city_name;
        this.city_pinyin = city_pinyin;
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_pinyin() {
        return city_pinyin;
    }

    public void setCity_pinyin(String city_pinyin) {
        this.city_pinyin = city_pinyin;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    @Override
    public int compareTo(OpenCityVO o) {
        return this.city_pinyin.compareTo(o.city_pinyin);
    }

    @Override
    public String toString() {
        return "OpenCityVO{" +
                "city_name='" + city_name + '\'' +
                ", city_pinyin='" + city_pinyin + '\'' +
                ", city_id=" + city_id +
                '}';
    }

    public static void main(String ... args) {
        Set<OpenCityVO> cities = new TreeSet<>();
        cities.add(new OpenCityVO("SU", "SUZOU", 1));
        cities.add(new OpenCityVO("SU", "SUZOU", 1));
        cities.add(new OpenCityVO("SU", "SUZOU", 1));

        for(OpenCityVO item: cities) {
            System.out.println(item);
        }
    }
}

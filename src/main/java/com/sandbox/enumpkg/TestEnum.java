package com.sandbox.enumpkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangxin on 16/1/26.
 */

enum Color {
    Red, White, Black, Yellow;
}

enum  WmLogisticsCodeEnum {
    ZI_PEI_LOGISTICS_CODE(1, "0000"),
    JIA_MENG_LOGISTICS_CODE(5, "1001"),
    ZI_JIAN_LOGISTICS_CODE(6, "1002"),
    CHENG_SHI_DAI_LI_LOGISTICS_CODE(8, "1004"),
    KUAI_SONG_LOGISTICS_CODE(101, "2002"),
    HUN_HE_LOGISTICS_CODE(102, "3001"),
    QUAN_CHENG_LOGISTICS_CODE(103, "2010");

    private int id;
    private String code;

    WmLogisticsCodeEnum(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}

class SpArea {
    private int id;
    private String code = "";

    public SpArea(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

public class TestEnum {
    public static void main(String ... args) {
        Color color = Color.Yellow;
        switch (color) {
            case Red:
                System.out.println("Color: Red");
                break;
            case White:
                System.out.println("Color: White");
                break;
            case Black:
                System.out.println("Color: Black");
                break;
            case Yellow:
                System.out.println("Color: Yellow");
                break;
            default:
                System.out.println("Default Color");
                break;
        }


        List<SpArea> spAreas = new ArrayList<>();
        spAreas.add(new SpArea(1, "1001"));
        spAreas.add(new SpArea(2, "2010"));
        spAreas.add(new SpArea(3, "2010"));

        Iterator<SpArea> spAreaIterator = spAreas.iterator();
        while(spAreaIterator.hasNext()) {
            SpArea item = spAreaIterator.next();
            if(item.getCode().equals(WmLogisticsCodeEnum.QUAN_CHENG_LOGISTICS_CODE.getCode())) {
                System.out.println("QUAN_CHENG_CODE: 2010");
            }
        }
    }
}

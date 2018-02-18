package com.sandbox.fastjson;

import com.alibaba.fastjson.JSON;
import com.apple.eawt.AppEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhangxin
 * Date: 2016-03-21
 * Time: 15:44:00
 */
public class First {
    public static void main(String[] args) {
        String adAttr = "{\"adCtrlAreaId\":1226,\"adId\":902,\"adPos\":15,\"adSlotId\":3}";
        AdResult.AdAttr adAttrObj = JSON.parseObject(adAttr, AdResult.AdAttr.class);
        System.out.println(adAttrObj.getAdCtrlAreaId());
        System.out.println(adAttrObj.getAdId());
        System.out.println(adAttrObj.getAdPos());
        System.out.println(adAttrObj.getAdSlotId());

        AdResult result = AdResult.getAdResult(1l, 1, adAttr);
        System.out.println(JSON.toJSONString(result));
        AdResult result1 = AdResult.getAdResult(2l, 2, adAttr);
        System.out.println(JSON.toJSONString(result1));

        List<AdResult> adResultList = new ArrayList<>();
        adResultList.add(result);
        adResultList.add(result1);
        System.out.println(JSON.toJSONString(adResultList));

        List<AdResult> adResultList1 = new ArrayList<>();
        System.out.println(JSON.toJSONString(adResultList1));

        System.out.println("====================================================");

        String adAttrEmpty = "{}";
        AdResult.AdAttr adAttrObjEmpty = JSON.parseObject(adAttrEmpty, AdResult.AdAttr.class);
        if(adAttrObjEmpty == null) {
            System.out.println("adAttrObjEmpty == null");
        } else {
            System.out.println(adAttrObjEmpty.getAdCtrlAreaId());
            System.out.println(adAttrObjEmpty.getAdId());
            System.out.println(adAttrObjEmpty.getAdPos());
            System.out.println(adAttrObjEmpty.getAdSlotId());
        }

        System.out.println("====================================================");
    }
}

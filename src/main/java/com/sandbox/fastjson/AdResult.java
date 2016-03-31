package com.sandbox.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhangxin
 * Date: 2016-03-21
 * Time: 11:42:00
 */
public class AdResult {
    @JSONField(name = "id")
    private long id;
    @JSONField(name = "index")
    private int index;
    @JSONField(name = "adSlotId")
    private long adSlotId;
    @JSONField(name = "adId")
    private long adId;
    @JSONField(name = "adCtrlAreaId")
    private long adCtrlAreaId;
    @JSONField(name = "adPos")
    private long adPos;

    public static AdResult getAdResult(long id, int index, String adAttrJson) {
        if(adAttrJson == null || adAttrJson.isEmpty())
            return null;

        try {
            AdResult result = new AdResult();
            result.id = id;
            result.index = index;
            AdAttr adAttr = JSONObject.parseObject(adAttrJson, AdAttr.class);
            result.adSlotId = adAttr.getAdSlotId();
            result.adId = adAttr.getAdId();
            result.adCtrlAreaId = adAttr.getAdCtrlAreaId();
            result.adPos = adAttr.getAdPos();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getAdSlotId() {
        return adSlotId;
    }

    public void setAdSlotId(long adSlotId) {
        this.adSlotId = adSlotId;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public long getAdCtrlAreaId() {
        return adCtrlAreaId;
    }

    public void setAdCtrlAreaId(long adCtrlAreaId) {
        this.adCtrlAreaId = adCtrlAreaId;
    }

    public long getAdPos() {
        return adPos;
    }

    public void setAdPos(long adPos) {
        this.adPos = adPos;
    }

    public static class AdAttr {
        @JSONField(name = "adSlotId")
        private long adSlotId;
        @JSONField(name = "adId")
        private long adId;
        @JSONField(name = "adCtrlAreaId")
        private long adCtrlAreaId;
        @JSONField(name = "adPos")
        private int adPos;

        public long getAdSlotId() {
            return adSlotId;
        }

        public void setAdSlotId(long adSlotId) {
            this.adSlotId = adSlotId;
        }

        public long getAdId() {
            return adId;
        }

        public void setAdId(long adId) {
            this.adId = adId;
        }

        public long getAdCtrlAreaId() {
            return adCtrlAreaId;
        }

        public void setAdCtrlAreaId(long adCtrlAreaId) {
            this.adCtrlAreaId = adCtrlAreaId;
        }

        public int getAdPos() {
            return adPos;
        }

        public void setAdPos(int adPos) {
            this.adPos = adPos;
        }
    }
}

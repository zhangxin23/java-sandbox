package com.sandbox.set;

/**
 * Created by zhangxin on 2018/11/17.
 */
public class OriginBrandItem {
    private String originBrandName;
    private int originBrandId;

    public String getOriginBrandName() {
        return originBrandName;
    }

    public void setOriginBrandName(String originBrandName) {
        this.originBrandName = originBrandName;
    }

    public int getOriginBrandId() {
        return originBrandId;
    }

    public void setOriginBrandId(int originBrandId) {
        this.originBrandId = originBrandId;
    }

    @Override
    public String toString() {
        return "OriginBrandItem{" +
                "originBrandName='" + originBrandName + '\'' +
                ", originBrandId=" + originBrandId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OriginBrandItem that = (OriginBrandItem) o;

        if (originBrandId != that.originBrandId) return false;
        return originBrandName.equals(that.originBrandName);

    }

    @Override
    public int hashCode() {
        int result = originBrandName.hashCode();
        result = 31 * result + originBrandId;
        return result;
    }
}

package com.sandbox.function.designing;

/**
 * Author: zhangxin
 * Date:   15-12-17
 */
public class Asset {
    public enum AssetType {BOND, STOCK};
    private final AssetType type;
    private final int value;

    public Asset(final AssetType type, final int value) {
        this.type = type;
        this.value = value;
    }

    public AssetType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}

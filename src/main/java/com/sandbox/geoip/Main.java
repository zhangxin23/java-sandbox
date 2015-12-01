package com.sandbox.geoip;

/**
 * Author: zhangxin
 * Date:   15-12-1
 */
public class Main {
    private String filePath = this.getClass().getClassLoader().getResource("GeoLiteCity.dat").getPath();

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws Exception {
        Main driver = new Main();
        LookupService lookupService = new LookupService(driver.getFilePath());
        Location location = lookupService.getLocation("74.125.228.210");
        System.out.println("countryCode: " + location.countryCode);
        System.out.println("countryName: " + location.countryName);
        System.out.println("latitude: " + location.latitude);
        System.out.println("longitude: " + location.longitude);
        System.out.println("city: " + location.city);
    }
}

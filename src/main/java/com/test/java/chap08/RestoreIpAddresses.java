package com.test.java.chap08;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-10-9
 */

public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length() == 0) return res;
        dfs(res, s, 0, "", 1);
        return res;
    }

    void dfs(List<String> res, String s, int start, String item, int segmentIndex){
        //use segmentIndex to memorize the number of segments
        //An IP address only have 4 segments, which could be used as pruning condition
        if(start >= s.length()) {
            return;
        }
        if(segmentIndex == 4){
            String substr = s.substring(start);
            if(isValidIPAddress(substr)){
                res.add(item + "." + substr);
            }
            return;
        }
        for(int i = 1; i < 4 && ((start + i) <= s.length()); i++){
            String substr = s.substring(start, start + i);
            if(isValidIPAddress(substr)){
                if(segmentIndex == 1){
                    dfs(res, s, start + i, substr, segmentIndex + 1);
                } else {
                    //Here we can't modify the content of item
                    //Since we want item always match start
                    //When segment == 4 and return, we hope the content of item
                    //and start to restore in the same time
                    dfs(res, s, start + i, item + "." + substr, segmentIndex + 1);
                }
            }
        }
    }

    boolean isValidIPAddress(String substr){
        if(substr.length() >=4 || substr.isEmpty()) return false;
        if(substr.charAt(0) == '0' && substr.length() > 1) return false;
        int temp = Integer.parseInt(substr);
        if(temp >= 0 && temp <= 255){
            return true;
        }
        return false;
    }
}
package com.sandbox.idgenerator;

/**
 * Created by zhangxin on 15-3-24.
 */
public class GetHardwareIdFailedException extends Exception {
    GetHardwareIdFailedException(String reason){
        super(reason);
    }

    GetHardwareIdFailedException(Exception e){
        super(e);
    }
}

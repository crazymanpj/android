package com.testcenter.kingsoft.getphoneinfo;


/**
 * Created by kingsoft on 2016/4/25.
 */
public class Util {
    public String getsystemversion(){
        return android.os.Build.VERSION.RELEASE;
    }

    public String getPhoneType(){
        return android.os.Build.MODEL;
    }

    public String getBrand() {
        return android.os.Build.BRAND;
    }

    public String getManufacturer(){
        return android.os.Build.MANUFACTURER;
    }

}

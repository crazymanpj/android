package com.testcenter.kingsoft.getphoneinfo;


import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

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

    public String getTotalMemory(){
        String str1 = "proc/meminfo";
        String str2 = "";
        String[] arrayOfString;
        Float initial_memory = null;
        try{
            FileReader localFileReader = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
            str2 = localBufferedReader.readLine();
            Log.i("str2", str2);
            arrayOfString = str2.split(":");
            String number = arrayOfString[1].trim().split(" ")[0];
            Log.i("arrayOfString", number);
            for(String num : arrayOfString){
                Log.i("for", num + "/t");
            }
            initial_memory = (float)Integer.valueOf(number)/(1024*1024);
            DecimalFormat decimalFormat = new DecimalFormat(".00");
            String ret_text = decimalFormat.format(initial_memory);
            return  ret_text;
        }
        catch(IOException e){
        }
        return "";
    }

    public String[] getSDCardMemory(){
        String[] sdCardInfo = new String[2];
        String state = Environment.getExternalStorageState();
        Log.i("getExternalStorageState", state);
        if (Environment.MEDIA_MOUNTED.equals(state)){
            File sdcardDir = Environment.getExternalStorageDirectory();
            StatFs sf = new StatFs(sdcardDir.getPath());
            long bSize = sf.getBlockSizeLong();
            long bCount = sf.getBlockCountLong();
            long availBlocks = sf.getAvailableBlocksLong();

            float totalsize = (float)bSize * bCount/(1024*1024*1024);
            float availsize = (float)bSize * availBlocks/(1024*1024*1024);
            DecimalFormat decimalFormat = new DecimalFormat(".00");
            sdCardInfo[0] = decimalFormat.format(availsize);
            sdCardInfo[1] = decimalFormat.format(totalsize);
            Log.i("sdCardInfo[0]", "" + sdCardInfo[0]);
            Log.i("sdCardInfo[1]", "" + sdCardInfo[1]);
        }
        return  sdCardInfo;
}

}

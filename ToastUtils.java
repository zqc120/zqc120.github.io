package com.example.myapplication.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by shido on 2017/5/23.
 */

public  class ToastUtils {
    private static Toast toast;
    public static void Toast(Activity activity,String str){
        if (toast==null){
            toast = Toast.makeText(activity ,str,Toast.LENGTH_SHORT);
        }
        toast.setText(str);
        toast.show();
    }
}

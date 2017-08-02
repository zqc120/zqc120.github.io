package cn.bgs.dingd.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by shido on 2017/3/21.
 */

public class SharedUtils {
    private String token = "token";
    private String name="int";

    public void SaveToken(String key, String value, Context ctx){
        SharedPreferences shared = ctx.getSharedPreferences(token, 0);
        SharedPreferences.Editor edit = shared.edit();
        edit.putString(key,value);
        edit.commit();
    }
    public String GetToken(String key,Context ctx){
        String str=null;
        SharedPreferences shared = ctx.getSharedPreferences(token, 0);
        str = shared.getString(key,"");
        return str;
    }

    public void MoveToken (String key,Context ctx){
        SharedPreferences shared = ctx.getSharedPreferences(token, 0);
        SharedPreferences.Editor editor = shared.edit();
        editor.clear();
        //editor.remove(key);
        editor.commit();
    }

    /*
	 * 保存int类型数据的方法
	 * */
    public void saveShared_int(String key,String value,Context ctx){
        SharedPreferences shared=ctx.getSharedPreferences(name,0);
        SharedPreferences.Editor edit = shared.edit();
        edit.putString(key, value);
        edit.commit();
    }
    /*
     * 从本地获取int类型数据
     * */
    public String  getShared_int(String key,Context ctx){
        String str1=null;
        SharedPreferences shared = ctx.getSharedPreferences(name, 0);
        str1=shared.getString(key, "");
        return str1;
    }



}

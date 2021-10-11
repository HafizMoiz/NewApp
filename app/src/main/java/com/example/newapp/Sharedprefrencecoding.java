//package com.example.newapp;
//
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//public class Sharedprefrencecoding<context> {
//    private static android.content.SharedPreferences sharedPreferences;
//    private static android.content.SharedPreferences SharedPreferences;
//    private static android.content.Context context;
//    public static Context getContext;
//
//
//    public Sharedprefrencecoding(Context applicationContext) {
//    }
//
//    public  void  Sharedprefrencecoding(Context context){
//        this.context = context;
//
//        SharedPreferences  = context.getSharedPreferences(context.getResources().getString(R.string.login_shared_prefrence),context.MODE_PRIVATE);
//
//    }
//    public  void login_status (boolean status){
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean(context.getResources().getString(R.string.login_status_shared_prefrence),status);
//        editor.commit();
//
//    }
//    public static boolean read_login_status(){
//        boolean status =false;
//        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_shared_prefrence),false);
//        return  status;
//    }
//}

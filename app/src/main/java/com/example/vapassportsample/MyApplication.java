package com.example.vapassportsample;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.vapassportsample.database.AppDatabase;
import com.example.vapassportsample.database.table.User;

public class MyApplication extends Application {
    public static AppDatabase appDatabase;
    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "AppDataBase").build();
        initData();
    }

    //讀取資料庫的行爲被認為是耗時的，不應該在MainThread上做
    private void initData() {
        //初始化User資料表
        Thread initThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //檢查User內有沒有資料
                if(appDatabase.userDao().getUser() == null){
                    //新增一筆空資料
                    User defaultUser = new User();
                    defaultUser.number = "";
                    defaultUser.name = "";
                    defaultUser.birthday = "";

                    //insert
                    appDatabase.userDao().insertUser(defaultUser);
                }
            }
        });
        initThread.start();

        try {
            initThread.join();
        } catch (InterruptedException e) {
            Log.e("initThread", e.toString());
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

package com.temp.chart.utils;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.temp.chart.model.DaoMaster;
import com.temp.chart.model.DaoSession;
import com.temp.chart.model.MonthContent;

import java.util.List;

public class DaoUntils {

    private static DaoSession mDaoSession;

    public static void initGreenDao(Context context) {
        //创建数据库mydb.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,"mydb.db");
        //获取可写数据库
        SQLiteDatabase database = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(database);
        //获取Dao对象管理者
        mDaoSession = daoMaster.newSession();
    }

    public static void insertMonthContents(List<MonthContent> monthContents){
         mDaoSession.getMonthContentDao().insertInTx(monthContents);
    }

    public static int getSize(){
        List<MonthContent> monthContents =  mDaoSession.getMonthContentDao().queryBuilder().list();

        return monthContents.size();
    }

    public static  List<MonthContent> getData(){
        List<MonthContent> monthContents =  mDaoSession.getMonthContentDao().queryBuilder().list();

        return monthContents;
    }
//
//    public static User getUserByName(String userName){
//        List<User> users =  mDaoSession.getUserDao().queryBuilder().where(UserDao.Properties.UserName.eq(userName)).list();
//        if(users.size()>0){
//            return users.get(0);
//        }
//        return null;
//    }
//
//    public static long updatePassword(String userName,String newPassword){
//           User user =getUserByName(userName);
//           user.setPassWord(newPassword);
//          long result= mDaoSession.getUserDao().insertOrReplace(user);
//          return result;
//    }
//
//    public static long updateAva(String userName,String avaPath){
//          User user = getUserByName(userName);
//          user.setAvaPath(avaPath);
//          return  mDaoSession.getUserDao().insertOrReplace(user);
//    }

}

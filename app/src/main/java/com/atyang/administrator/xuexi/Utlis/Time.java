package com.atyang.administrator.xuexi.Utlis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/8.
 */
public class Time {
   
        /**
         * 单例对象实例
         */
        private static Time instance = null;

        public static Time getInstance() {
            if (instance == null) {
                instance = new Time();
            }
            return instance;
        }
    public String getPresentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }
}

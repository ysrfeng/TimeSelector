package com.ysr.timeselectlib;

/**
 * Created by ysr on 2017/5/10 13:33.
 * 邮箱 ysr200808@163.com
 */

public interface DateListener {
    void onReturnDate(String time, int year, int month, int day, int hour, int minute, int isShowType);

    void onReturnDate(String empty);
}

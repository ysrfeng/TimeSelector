package com.ysr.timeselector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ysr.timeselectlib.DateListener;
import com.ysr.timeselectlib.TimeConfig;
import com.ysr.timeselectlib.TimeSelectorDialog;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickDialog(TimeConfig.YEAR_MONTH_DAY_HOUR);
            }
        });
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }

    private void showDatePickDialog(int type) {
//        showDatePickDialog(TimeConfig.YEAR_MONTH_DAY_HOUR);
        TimeSelectorDialog dialog = new TimeSelectorDialog(this);
        //设置标题
        dialog.setTimeTitle("选择时间:");
        //显示类型
        dialog.setIsShowtype(TimeConfig.YEAR_MONTH_DAY_HOUR_MINUTE);
        //默认时间
        dialog.setCurrentDate("2017-01-11　14:50");
        //隐藏清除按钮
        dialog.setEmptyIsShow(false);
        dialog.setDateListener(new DateListener() {
            @Override
            public void onReturnDate(String time, int year, int month, int day, int hour, int minute, int isShowType) {
                // Toast.makeText(mContext, time, Toast.LENGTH_LONG).show();
                tv.setText(time);
            }

            @Override
            public void onReturnDate(String empty) {

            }
        });
        dialog.show();
    }

    public void logMsg(final String str) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    tv.post(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(str);
                        }
                    });

                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

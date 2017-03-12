package com.example.jh.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 本demo测试Handler用法
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int i = 0;

    private Handler handler = new Handler();
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        handler.postDelayed(runnable, 1000);  // 1s后执行计数操作
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            i++;
            textView.setText(i + "");
            handler.postDelayed(runnable, 2000);   // 2s后i自加。
        }
    };

    //button的点击事件的回调方法
    public void remove(View view) {
        if (!flag) {
            flag = true;
            handler.removeCallbacks(runnable);
        } else {
            flag = false;
            handler.postDelayed(runnable, 2000);    // 2s后执行计数操作
        }
    }

}

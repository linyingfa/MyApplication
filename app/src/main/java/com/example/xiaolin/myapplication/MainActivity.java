package com.example.xiaolin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bbbb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show(getSupportFragmentManager(), "lyf");

            }
        });
        SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {
                //Toast.makeText(getActivity(), "键盘显示 高度" + height, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void keyBoardHide(int height) {
                //Toast.makeText(getActivity(), "键盘隐藏 高度" + height, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


    }

    KeyMapDailog dialog = new KeyMapDailog("隐藏文字", new KeyMapDailog.SendBackListener() {
        @Override
        public void sendBack(String inputText) {
            //TODO  点击发表后业务逻辑
            Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();

        }
    });
}

package com.terrygjt.androidstudynote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.terrygjt.androidstudynote.JavaReflex.DemoTest;
import com.terrygjt.androidstudynote.JavaReflex.ReflexActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button JavaReflex,turn81;
//    DemoTest demo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JavaReflex=findViewById(R.id.JavaReflex);
        JavaReflex.setOnClickListener(this);
//        demo=new DemoTest();
    }

    @Override
    public void onClick(View v) {
        if (v == JavaReflex ) {
            Intent intent = new Intent(this, ReflexActivity.class);
//            String ss=connection.getsIP();
//            intent.putExtra(ImageActivity.IP_INFO, ss);
//            Log.i("线程运行","加入ip信息:"+ss);
//            intent.putExtras(data);
            startActivity(intent);
        }
        else if (v == turn81 ){

        }
    }
}

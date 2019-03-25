package com.terrygjt.androidstudynote.JavaReflex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.terrygjt.androidstudynote.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflexActivity extends AppCompatActivity {
    TextView InfoTextView;
//    DemoTest demo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflex);
//        demo=new DemoTest();
        //获取类DemoTest的Class对象
        InfoTextView=(TextView)findViewById(R.id.InfoTextView);
        Class<?> c = null;
        try {
            c = Class.forName("com.terrygjt.androidstudynote.JavaReflex.DemoTest");
            //打印该Class对象对表示的类的名称
            ShowAndLog("获取类名-"+c.getName());
            //获取该类的实例
            ShowAndLog("获取实例-"+c.newInstance());
            //获取该类实现的接口
            Class<?>[] interfaces = c.getInterfaces();
            ShowAndLog("类实现的接口0-"+interfaces[0].getName());
            //获取有参构造函数
            Constructor<?> con = c.getConstructor(String.class,int.class);
            DemoTest dt = (DemoTest)con.newInstance("xiaoming",12);
            ShowAndLog("获取有参构造函数并生成实例，再调用方法显示年龄："+dt.getAge());
            //获取类的成员变量
            Field f2 = c.getField("age");
            ShowAndLog("获取类的成员变量-"+f2);
            //获取指定对象上该字段表示的值
            ShowAndLog("指定对象上该字段表示的值"+f2.get(dt));
            //获取指定的方法
            Method m = c.getMethod("sayHello", String.class);
            //反射调用方法，非常重要
            m.invoke(dt, "hangzhou");
            
        } catch (Exception e) {
            ShowAndLog("-"+"运行异常："+e.toString());
        }
    }
    private void ShowAndLog(String s){
        InfoTextView.append(s+"\n");
        Log.i("运行 反射",s);
    }
}

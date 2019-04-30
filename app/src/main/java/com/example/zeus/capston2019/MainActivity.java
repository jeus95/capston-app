package com.example.zeus.capston2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 화면 전환 - 인텐트 날리기 (startActivity)
        //     1. 다음 넘어갈 화면을 준비한다 (layout xml, java)
        //    2. AndroidManifest.xml 에 Activity 를 등록한다
        //    3. Intent 객체를 만들어서 startActivity 한다

        Button STPower = findViewById(R.id.button1);
        Button CPower = findViewById(R.id.button2);
        STPower.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Intent intent = new Intent(
                                                   getApplicationContext(), // 현재 화면의 제어권자
                                                   MyTwo.class); // 다음 넘어갈 클래스 지정
                                           startActivity(intent); // 다음 화면으로 넘어간다
                                       }
                                   }


        );
        CPower.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(
                                                  getApplicationContext(), // 현재 화면의 제어권자
                                                  MyThree.class); // 다음 넘어갈 클래스 지정
                                          startActivity(intent); // 다음 화면으로 넘어간다
                                      }
                                  }


        );
    } // end onCreate()
} // end MainActivity

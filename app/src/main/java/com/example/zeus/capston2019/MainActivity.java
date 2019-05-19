package com.example.zeus.capston2019;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView Voice;
    ImageView CalPower;
    ImageView Schedule;
    ImageView CPower;
    ImageView Set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 5);
            Toast.makeText(getApplicationContext(),"입장권한이 필요합니다.",Toast.LENGTH_SHORT);
        }


        Set = (ImageView)findViewById(R.id.Set);
        Set.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Intent intent = new Intent(
                                                     getApplicationContext(), // 현재 화면의 제어권자
                                                     StPower.class); // 다음 넘어갈 클래스 지정
                                             startActivity(intent); // 다음 화면으로 넘어간다
                                         }
                                     }


        );
        CPower = (ImageView)findViewById(R.id.CPower);
        CPower.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(
                                                    getApplicationContext(), // 현재 화면의 제어권자
                                                    CPower.class); // 다음 넘어갈 클래스 지정
                                            startActivity(intent); // 다음 화면으로 넘어간다
                                        }
                                    }


        );
        Schedule = (ImageView)findViewById(R.id.Schedule);
        Schedule.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent intent = new Intent(
                                                      getApplicationContext(), // 현재 화면의 제어권자
                                                      Schedule.class); // 다음 넘어갈 클래스 지정
                                              startActivity(intent); // 다음 화면으로 넘어간다
                                          }
                                      }


        );
        CalPower = (ImageView)findViewById(R.id.CalPower);
        CalPower.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent intent = new Intent(
                                                      getApplicationContext(), // 현재 화면의 제어권자
                                                      Calpower.class); // 다음 넘어갈 클래스 지정
                                              startActivity(intent); // 다음 화면으로 넘어간다
                                          }
                                      }



        );

        Voice = (ImageView)findViewById(R.id.Voice);
        Voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        Voice.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });





    } // end onCreate()
} // end MainActivity

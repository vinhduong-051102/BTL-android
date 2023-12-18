package com.example.dangkymonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Intent intent = new Intent(MainActivity.this, xemhpActivity.class);
    TextView xemHocPhan;

    public void collection() {
        xemHocPhan = findViewById(R.id.xemHocPhanbtn);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collection();
        //setXemHocPhan();
    }

//    public void setXemHocPhan(){
//        xemHocPhan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(intent);
//            }
//        });
//    }
}
package com.example.monhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Intent intent;
    public Intent dkhp;
    TextView xemHocPhan;
    TextView dangKyHocPhan;

    public void collection() {
        xemHocPhan = findViewById(R.id.xemHocPhanbtn);
        dangKyHocPhan=findViewById(R.id.dangKyHocPhanbtn);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, xemHocPhan.class);
        dkhp = new Intent(MainActivity.this, dang_ky_hoc_phan.class);
        collection();
        setXemHocPhan();
    }

    public void setXemHocPhan(){
        xemHocPhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });
        dangKyHocPhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(dkhp);
            }
        });

    }
}
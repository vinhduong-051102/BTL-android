package com.example.giaodienchinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Hoc_Phan extends AppCompatActivity {
    LinearLayout danhsachhocphan;
    LinearLayout dangkyhocphan;
    public void collection(){
        danhsachhocphan = findViewById(R.id.danhsachhocphan);
        dangkyhocphan =findViewById(R.id.dkhocphan);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_phan);
        setRoundCornerLinear(dangkyhocphan);
        setRoundCornerLinear(danhsachhocphan);
    }
    void setDanhsachhocphan(){
        danhsachhocphan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    void setDangkyhocphan(){
        dangkyhocphan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
    void setRoundCornerLinear(LinearLayout textView){
        textView.setClipToOutline(true);
        textView.setOutlineProvider(new RoundOutlineProvider());
    }
}
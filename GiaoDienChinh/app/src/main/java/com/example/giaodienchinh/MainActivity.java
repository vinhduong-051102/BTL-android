package com.example.giaodienchinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView date;
    LinearLayout boxtkb;
    TextView xemtkb;
    LinearLayout diemDanhbtn;
    LinearLayout ketQuabtn;
    LinearLayout xemHPbtn;
    LinearLayout DKnghibtn;
    public void collection(){
        date = findViewById(R.id.date);
        boxtkb = findViewById(R.id.boxtkb);
        xemtkb =findViewById(R.id.xemtkb);
        diemDanhbtn = findViewById(R.id.diemDanhbtn);
        ketQuabtn = findViewById(R.id.ketQuabtn);
        xemHPbtn = findViewById(R.id.xemHPbtn);
        DKnghibtn = findViewById(R.id.DKnghibtn);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        collection();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        setRoundCornerLinear(boxtkb);
        setRoundCornerLinear(diemDanhbtn);
        setRoundCornerLinear(ketQuabtn);
        setRoundCornerLinear(xemHPbtn);
        setRoundCornerLinear(DKnghibtn);
        date.setText( day + " Tháng " + month);
        setXemtkb();
        setDKnghibtn();
        setDiemDanhbtn();
        setKetQuabtn();
        setXemHPbtn();
    }
    //Vào giao diện thời khóa biểu
    void setXemtkb(){
        xemtkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    //Vào giao diện điểm danh
    void setDiemDanhbtn(){
        diemDanhbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    //Vào giao diện xem kết quả học phần
    void setKetQuabtn(){
        ketQuabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    //Vào giao diện xem học phần
    void setXemHPbtn(){
        xemHPbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    //Vào giao diện đăng ký nghỉ
    void setDKnghibtn(){
        DKnghibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    void setRoundCorner(TextView textView){
        textView.setClipToOutline(true);
        textView.setOutlineProvider(new RoundOutlineProvider());
    }
    void setRoundCornerLinear(LinearLayout textView){
        textView.setClipToOutline(true);
        textView.setOutlineProvider(new RoundOutlineProvider());
    }
}
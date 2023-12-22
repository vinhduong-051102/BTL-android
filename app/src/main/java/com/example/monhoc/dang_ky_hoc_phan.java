package com.example.monhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dang_ky_hoc_phan extends AppCompatActivity {
    Button dkhpphu;
    Intent dkhpp;
    public void collection(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_hoc_phan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collection();

    }

}
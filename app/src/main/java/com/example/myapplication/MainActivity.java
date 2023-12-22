package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.sahana.horizontalcalendar.HorizontalCalendar;
import com.sahana.horizontalcalendar.model.DateModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private TextView mDateTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thoikhoabieu);
        HorizontalCalendar mHorizontalCalendar = findViewById(R.id.horizontalCalendar);
        mDateTextView = findViewById(R.id.dateTextView);
        mHorizontalCalendar.setOnDateSelectListener(dateModel -> {
            mDateTextView.setText(dateModel != null ?
                    dateModel.day + " " + dateModel.dayOfWeek + " " + dateModel.month + "," + dateModel.year : "");
            handleEvents(dateModel);
        });
    }
    private void handleEvents(DateModel dateModel) {
        //BE check ngày để show ra data
        ListView listView;
        ArrayAdapter<Schedule> adapter;
        ArrayList<Schedule> arrSchedule = new ArrayList<>();
        listView = findViewById(R.id.lv_thoi_khoa_bieu);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrSchedule);
        listView.setAdapter(adapter);
        for (int i=1; i<5; i++){
            Schedule schedule = new Schedule();
            schedule.setMonHoc("Triết học Mác-Lênin");
            schedule.setBuoi("Sáng");
            List<Integer> tiet = new ArrayList<>();
            tiet.add(1);
            tiet.add(2);
            schedule.setTiet(tiet.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
            schedule.setGiaoVien("Nguyễn Thị A");
            schedule.setDiaDiem("614 - A10");
            arrSchedule.add(schedule);
        }
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Schedule schedule = arrSchedule.get(position);
            new AlertDialog.Builder(this).setMessage("Bạn có muốn điểm danh")
                    .setNegativeButton("Không", ((dialog, which) -> {
                    })).setPositiveButton("Đồng ý", ((dialog, which) -> {
                        //set hành động sau khi click điểm danh
                        new AlertDialog.Builder(this).setMessage("Điểm danh thành công").show();
                        adapter.notifyDataSetChanged();
                    })).show();
        });
    }
}
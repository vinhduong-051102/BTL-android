package com.example.myapplication.lcb;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

import java.util.List;
public class SubjectAdapter extends ArrayAdapter<Subject> {

    public SubjectAdapter(Context context, List<Subject> subjects) {
        super(context, 0, subjects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_subject, parent, false);
        }
        // Get the subject at the current position
        Subject currentSubject = getItem(position);

        // Find the TextViews in your layout
        TextView tvSubjectName = convertView.findViewById(R.id.tvSubjectName);
        TextView tvRegularScore = convertView.findViewById(R.id.tvRegularScore);
        TextView tvDetail = convertView.findViewById(R.id.tvDetail);
        TextView tvMidtermScore = convertView.findViewById(R.id.tvMidtermScore);

        if (currentSubject != null) {
            // Set Subject Name
            tvSubjectName.setText(currentSubject.getName());

            // Set Regular Score or replace with dot if available
            String regularScoreText = currentSubject.getRegularScore();
            if (regularScoreText.contains("-")) {
                // Get the number of occurrences of "-"
                int count = regularScoreText.length() - regularScoreText.replace("-", "").length();

                // Replace each "-" with the score if available
                StringBuilder modifiedScore = new StringBuilder(regularScoreText);
                for (int i = 0; i < count; i++) {
                    int index = modifiedScore.indexOf("-");
                    modifiedScore.setCharAt(index, 'Đ'); // Điểm (hoặc bất kỳ ký tự nào bạn muốn)
                }
                tvRegularScore.setText(modifiedScore.toString());
            } else {
                tvRegularScore.setText(regularScoreText);
            }

            // Set Detail
            tvDetail.setText("Chi tiết");

            // Set Midterm Score
            tvMidtermScore.setText(currentSubject.getMidtermScore());
        }

        return convertView;
    }
}
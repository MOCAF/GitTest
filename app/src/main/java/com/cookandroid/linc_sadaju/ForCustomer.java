package com.cookandroid.linc_sadaju;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForCustomer extends AppCompatActivity {
    Button question, report;
    ExpandableListView expandableListView;
    List<String> listGroup;
    Map<String, List<String>> listItem;
    FAQAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_customer);

        question = findViewById(R.id.question);
        report = findViewById(R.id.report);

        expandableListView = findViewById(R.id.expandableListView);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new FAQAdapter((Context) this, listGroup, (HashMap<String, List<String>>) listItem);
        expandableListView.setAdapter(adapter);
        initListData();

        // Question 버튼 클릭 리스너
        question.setOnClickListener(view -> {
            Intent intent = new Intent(ForCustomer.this, OnebyoneInquiry.class);
            startActivity(intent);
        });

        // Report 버튼 클릭 리스너
        report.setOnClickListener(view -> {
            EditText inputReport = new EditText(ForCustomer.this);

            AlertDialog.Builder builderRpt = new AlertDialog.Builder(ForCustomer.this);
            builderRpt.setTitle("신고 내용을 작성해 보세요.");
            builderRpt.setView(inputReport);
            builderRpt.setPositiveButton("OK", (dialog, which) -> {
                String userInput = inputReport.getText().toString();
                Toast.makeText(ForCustomer.this, "당신의 신고를 확인했습니다! ", Toast.LENGTH_SHORT).show();
            });

            builderRpt.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
            builderRpt.show();
        });
    }

    private void initListData() {
        listGroup.clear();
        listItem.clear();

        listGroup.add("문제 1");
        listGroup.add("문제 2");
        listGroup.add("문제 3");


        List<String> problem1 = new ArrayList<>();
        problem1.add("답1");

        List<String> problem2 = new ArrayList<>();
        problem2.add("답2");

        List<String> problem3 = new ArrayList<>();
        problem3.add("답3");

        listItem.put(listGroup.get(0), problem1);
        listItem.put(listGroup.get(1), problem2);
        listItem.put(listGroup.get(2), problem3);

        adapter.notifyDataSetChanged();  // 데이터 변경을 어댑터에 알림
    }
}

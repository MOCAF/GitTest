package com.cookandroid.linc_sadaju;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyPage extends AppCompatActivity {

    Button editor, product, writing, list, service, logout, deleteUser;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mypage);

        // intent 창 연계 버튼
        editor = findViewById(R.id.editor);         // 프로필 편집 버튼
        product = findViewById(R.id.recentSeenProduct_button);   // 최근 본 상품 버튼
        writing = findViewById(R.id.writing_button);       // 내가 작성한 글 버튼
        list = findViewById(R.id.exchangeList);   // 거래 목록 버튼
        service = findViewById(R.id.service);       // 고객센터 버튼
        logout = findViewById(R.id.logout);         // 로그아웃 버튼
        deleteUser = findViewById(R.id.deleteUser); // 회원탈퇴

        // 거래 목록
        list.setOnClickListener(v -> {
            Intent intent = new Intent(MyPage.this, Mypage_Trade.class);
            startActivity(intent);
        });

        // 고객 센터
        service.setOnClickListener(v -> {
            Intent intent = new Intent(MyPage.this, MyPage_ForCustomer.class);
            startActivity(intent);
        });

        // 설정 편집
        editor.setOnClickListener(v -> {
            Intent intent = new Intent(MyPage.this, Mypage_Editor.class);
            startActivity(intent);
        });

        // 최근 본 목록
        product.setOnClickListener(v -> {
            Intent intent = new Intent(MyPage.this, Mypage_RecentSeenProduct.class);
            startActivity(intent);
        });

    }
}

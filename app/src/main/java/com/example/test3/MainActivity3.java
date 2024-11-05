package com.example.test3;

import android.annotation.SuppressLint;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity3 extends AppCompatActivity {

    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // 初始化测试TextView
        testTextView = findViewById(R.id.test_text_view);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);  // 加载菜单XML
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.font_size_small) {
            testTextView.setTextSize(10);
            return true;
        } else if (id == R.id.font_size_medium) {
            testTextView.setTextSize(16);
            return true;
        } else if (id == R.id.font_size_large) {
            testTextView.setTextSize(20);
            return true;
        } else if (id == R.id.normal_item) {
            Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.font_color_red) {
            testTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            return true;
        } else if (id == R.id.font_color_black) {
            testTextView.setTextColor(ContextCompat.getColor(this, android.R.color.black));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}


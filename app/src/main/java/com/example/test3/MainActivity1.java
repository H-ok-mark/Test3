package com.example.test3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity1 extends AppCompatActivity {
    private View lastClickedView = null; // 用于跟踪上一个被点击的视图
    private ListView listView;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1); // 设置布局文件
        listView = findViewById(R.id.listView); // 获取ListView控件
        setupListView(); // 初始化ListView
    }

    private void setupListView() {
        List<Map<String, Object>> data = new ArrayList<>(); // 创建数据列表
        data.add(createData("Lion", R.drawable.lion)); // 添加数据项
        data.add(createData("Tiger", R.drawable.tiger));
        data.add(createData("Monkey", R.drawable.monkey));
        data.add(createData("Dog", R.drawable.dog));
        data.add(createData("Cat", R.drawable.cat));
        data.add(createData("Elephant", R.drawable.elephant));

        simpleAdapter = new SimpleAdapter(
                this,
                data,
                R.layout.simple_item,
                new String[]{"text", "image"}, // 指定数据键和布局ID
                new int[]{R.id.textView, R.id.imageView}); // 指定视图ID

        listView.setAdapter(simpleAdapter); // 设置适配器


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> item = (Map<String, Object>) simpleAdapter.getItem(position); // 获取点击项的数据
                String text = (String) item.get("text"); // 获取文本数据
                Toast.makeText(MainActivity1.this, "Selected: " + text, Toast.LENGTH_SHORT).show(); // 显示Toast消息
                // 改变背景颜色

                if (lastClickedView != null) {
                    lastClickedView.setBackgroundColor(Color.WHITE); // 将上一个点击的视图恢复成白色
                }
                view.setBackgroundColor(Color.RED); // 当前点击的视图变成红色
                lastClickedView = view; // 更新上一个点击的视图
            }
        });
    }

    private Map<String, Object> createData(String text, int imageResId) {
        Map<String, Object> data = new HashMap<>(); // 创建数据映射
        data.put("text", text); // 添加文本数据
        data.put("image", imageResId); // 添加图片资源ID
        return data; // 返回数据映射
    }
}
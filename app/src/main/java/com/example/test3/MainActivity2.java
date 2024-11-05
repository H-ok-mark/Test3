package com.example.test3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 显示对话框的方法
        showCustomDialog();
    }

    private void showCustomDialog() {
        // 创建AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 加载自定义布局
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_custom, null);
        builder.setView(dialogView);

        // 查找自定义布局中的控件
        EditText usernameEditText = dialogView.findViewById(R.id.username);
        EditText passwordEditText = dialogView.findViewById(R.id.password);
        Button cancelButton = dialogView.findViewById(R.id.cancel_button);
        Button signInButton = dialogView.findViewById(R.id.sign_in_button);

        // 创建对话框
        AlertDialog dialog = builder.create();

        // 设置按钮点击事件
        cancelButton.setOnClickListener(v -> dialog.dismiss());
        signInButton.setOnClickListener(v -> {
            // 获取用户输入的内容
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // 处理登录逻辑，如验证用户名和密码
            if (validateLogin(username, password)) {
                // 登录成功逻辑
            } else {
                // 登录失败逻辑
            }

            // 关闭对话框
            dialog.dismiss();
        });

        // 显示对话框
        dialog.show();
    }

    // 验证登录信息的示例方法
    private boolean validateLogin(String username, String password) {
        // 添加验证逻辑，例如简单的非空检查
        return !username.isEmpty() && !password.isEmpty();
    }
}

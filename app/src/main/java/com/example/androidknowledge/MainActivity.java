package com.example.androidknowledge;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.notificationwindow)
    Button notification;

    @BindView(R.id.viewadvanced)
    Button viewadvanced;

    @BindView(R.id.exit)
    Button exit;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupListener() {
        Notification();
        ViewAdvanced();
        Exit();

    }

    @Override
    protected void populateData() {

    }

    private void Notification()
    {
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NotificationManage.class));
            }
        });
    }

    private void ViewAdvanced()
    {
        viewadvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ViewManage.class));
            }
        });
    }

    private void Exit()
    {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Question ?");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("are you sure you want to exit");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }
}
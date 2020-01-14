package com.example.projeck_login.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projeck_login.R;

public class SettingActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Setting / Logout");
        actionBar.setDisplayHomeAsUpEnabled(true);


        Button btnLogout = findViewById(R.id.buttonLogout);
        SharedPreferences prf = getSharedPreferences("user_details", MODE_PRIVATE);
        TextView textViewName = (TextView) findViewById(R.id.ValueNama);
        textViewName.setText(prf.getString("fullname", ""));



        final Intent intent = new Intent(this,MainActivity.class);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Logout Successfull", Toast.LENGTH_LONG);
                startActivity(intent);
            }
        });

    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home : finish(); return true;
        }
        return super.onOptionsItemSelected(item);
    }


}





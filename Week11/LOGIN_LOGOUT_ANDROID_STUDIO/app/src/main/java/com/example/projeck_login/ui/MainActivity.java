package com.example.projeck_login.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projeck_login.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        Button btnLogin = findViewById(R.id.btnLogin);
        final EditText formUsername = findViewById(R.id.inputUsername);
        final EditText formPassword = findViewById(R.id.inputPassword);

        final SharedPreferences pref = getSharedPreferences("user_details", MODE_PRIVATE);
        final Intent intent = new Intent(this,HomeActivity.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                if (formUsername.getText().toString().equals("rio") && formPassword.getText().toString().equals("rio")){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("fullname", " Junifer Rionaldi Manik");
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"Login Successfull", Toast.LENGTH_LONG);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}

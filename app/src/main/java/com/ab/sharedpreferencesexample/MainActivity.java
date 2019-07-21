package com.ab.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferenceConfig preferenceConfig;
    private EditText Username, UserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        Username = findViewById(R.id.user_name);
        UserPassword = findViewById(R.id.user_password);

        if (preferenceConfig.readLoginStatus())
        {
            startActivity(new Intent(this,SuccessActivity.class));
            finish();
        }

    }

    public void loginAcc(View view)
    {

        String username = Username.getText().toString();
        String userpassword = UserPassword.getText().toString();

        if (username.equals(getResources().getString(R.string.user_name)) && userpassword.equals(getResources().getString(R.string.user_password)))
        {
            startActivity(new Intent(this,SuccessActivity.class));
            preferenceConfig.writeLoginStatus(true);
            finish();
        }
        else
        {
            Toast.makeText(this,"login is failed .... try again later",Toast.LENGTH_SHORT);
            Username.setText("");
            UserPassword.setText("");
        }

    }
}

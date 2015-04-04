package edu.shubham.styles;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    EditText user;
    EditText password;
    TextView chutext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.password);
        chutext=(TextView)findViewById(R.id.chuText);
    }

    public void saveClick(View view) {
        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", user.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();
        Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();
    }

    public void displayClick(View view){
        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String n= sp.getString("username","");
        String p=sp.getString("password","");
        chutext.setText(n+" "+p);
    }

}

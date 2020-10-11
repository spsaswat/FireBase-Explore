package com.fake_era.pollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashSet;

public class loggedin extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser user;
    EditText max;
    String name="",email="";
    TextView tv2,tv3,tv4;
    LinearLayout rr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);
        Intent mIntent = getIntent();
        name = mIntent.getStringExtra("User_name");
        email = mIntent.getStringExtra("User_email");
        tv2=(TextView) findViewById(R.id.textView2);
        tv3=(TextView) findViewById(R.id.textView3);
        tv4=(TextView) findViewById(R.id.textView4);
        rr = (LinearLayout) findViewById(R.id.button_layout);
//        tv2.setText(name);
//        tv3.setText(email);
        max= (EditText) findViewById(R.id.editText);

        mAuth=FirebaseAuth.getInstance();
        user= mAuth.getCurrentUser();

        user_details();
    }

    public void user_details()
    {
        String name;
        Uri photo_url;
        String email;
        String phone;
        name=user.getDisplayName();
        phone=user.getPhoneNumber();
        photo_url=user.getPhotoUrl();
        email=user.getEmail();

        tv2.setText(name);
        tv3.setText(email);
        tv4.setText(phone);


    }
    public void logout(View view)
    {
        mAuth.signOut();
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void reload(View view) {
        finish();
        startActivity(getIntent());
    }


    public void add(View view) {
        Button button1=new Button(loggedin.this);
        button1.setText("test");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rr.addView(button1,lp);
    }
}

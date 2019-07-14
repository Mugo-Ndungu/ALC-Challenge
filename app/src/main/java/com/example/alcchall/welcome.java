package com.example.alcchall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity {
    public Button btnWebview, btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        btnWebview = (Button) findViewById(R.id.btnwebview);
        btnProfile = (Button) findViewById(R.id.btnprofile);

        // Capture button clicks
        btnWebview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(welcome.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        // Capture button clicks
        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(welcome.this,
                        profile.class);
                startActivity(myIntent);
            }
        });
    }
}

package com.gannon.ultan.lordoftheringsmapofbritainapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.select_btn);

        // Link UI elements to actions in code
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,  MapsActivity.class);
                startActivity(i);

            }
        });

        }
    }


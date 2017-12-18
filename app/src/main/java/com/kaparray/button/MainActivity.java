package com.kaparray.button;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (LinearLayout) findViewById(R.id.View);
        button.setGravity(Gravity.CENTER);  // Under the change settings button start in center

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("button",MODE_PRIVATE);
        String side = preferences.getString("buttonSide"," ");

        switch (side){
            case "lt": button.setGravity(Gravity.LEFT); break;
            case "rt": button.setGravity(Gravity.RIGHT); break;
            case "lb": button.setGravity(Gravity.BOTTOM); break;
            case "rb": button.setGravity(Gravity.BOTTOM + Gravity.RIGHT); break;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.toSettings){
            Intent toSettings = new Intent(this, Setting.class);
            startActivity(toSettings);
        }
    }
}

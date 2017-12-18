package com.kaparray.button;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Setting extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        radioGroup = (RadioGroup)findViewById(R.id.settings);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int buttonId) {
                String side = "";
                switch (buttonId){
                    case R.id.left: side = "lt";    // Send for button lt = left-top
                        break;
                    case R.id.right: side = "rt";   // Send for button rt = right-top
                        break;
                    case R.id.top: side = "lb";     // Send for button lb = left-bottom
                        break;
                    case R.id.bottom: side = "rb";  // Send for bottom rb = right-bottom
                        break;
                }
                SharedPreferences preferences = getSharedPreferences("button", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("buttonSide",side);
                editor.apply();
            }
        });

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.toMain){
            Intent toMain = new Intent(this, MainActivity.class);
            startActivity(toMain);
        }
    }


}

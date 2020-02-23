package org.techtown.travellet;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class PlanInputActivity extends AppCompatActivity {

    int hour, min;
    String place;
    String memo, category;

    TimePicker timePicker;

    Button add;
    ImageButton placeSelect;
    TextView selectTitleText;
    EditText editMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_plan_input);

        timePicker = (TimePicker) findViewById(R.id.select_time);
        if(android.os.Build.VERSION.SDK_INT>= android.os.Build.VERSION_CODES.M){
            hour = timePicker.getHour();
            min = timePicker.getMinute();
        } else{
            hour = timePicker.getCurrentHour();
            min = timePicker.getCurrentMinute();
        }

        placeSelect = (ImageButton) findViewById(R.id.SelectPlaceButton);
        placeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectPlaceActivity.class);
                startActivityForResult(intent, 103);
            }
        });

        selectTitleText = (TextView) findViewById(R.id.select_place);

        editMemo = (EditText) findViewById(R.id.memo);
        memo = editMemo.getText().toString();



        add = (Button) findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToBack();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 103){
            if(intent != null){
                place = intent.getStringExtra("selectTitle");
                selectTitleText.setText(place);
            }
        }
    }

    public void returnToBack(){
        Intent intent = new Intent();

        setResult(RESULT_OK, intent);
        finish();
    }
}

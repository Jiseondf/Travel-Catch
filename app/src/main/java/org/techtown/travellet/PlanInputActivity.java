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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class PlanInputActivity extends AppCompatActivity {

    int hour, min, category=-1;
    String place;
    String memo;

    TimePicker timePicker;

    Button add;
    ImageButton placeSelect;
    TextView selectTitleText;
    EditText editMemo;

    RelativeLayout lodging, food, shopping, tourism, etc;
    ImageButton selectLodging, selectFood, selectShopping, selectTourism, selectEtc;
    TextView lodgingText, foodText, shoppingText, tourismText, etcText;

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

        lodging = (RelativeLayout) findViewById(R.id.lodging);
        food = (RelativeLayout) findViewById(R.id.food);
        shopping = (RelativeLayout) findViewById(R.id.shopping);
        tourism = (RelativeLayout) findViewById(R.id.tourism);
        etc = (RelativeLayout) findViewById(R.id.etc);

        selectLodging = (ImageButton) findViewById(R.id.selectLodging);
        selectFood = (ImageButton) findViewById(R.id.selectFood);
        selectShopping = (ImageButton) findViewById(R.id.selectShopping);
        selectTourism = (ImageButton) findViewById(R.id.selectTourism);
        selectEtc = (ImageButton) findViewById(R.id.selectETC);

        lodgingText = (TextView) findViewById(R.id.lodgingText);
        foodText = (TextView) findViewById(R.id.foodText);
        shoppingText = (TextView) findViewById(R.id.shoppingText);
        tourismText = (TextView) findViewById(R.id.tourismText);
        etcText = (TextView) findViewById(R.id.etcText);


        lodging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(category !=-1 && category != 1){
                    category = 1;
                    selectLodging.setBackgroundResource(R.drawable.ic_lodging_24px);
                }
            }
        });

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

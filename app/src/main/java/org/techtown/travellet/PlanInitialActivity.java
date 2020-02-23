package org.techtown.travellet;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class PlanInitialActivity extends AppCompatActivity {

    Button addButton, placeSearch;

    ListView listView;
    ArrayList<PlanInitialSubItem> items = new ArrayList<PlanInitialSubItem>();
    PlanSubAdapter adapter = new PlanSubAdapter();

    String time, name, memo, tbText, tText;
    int tIc, tBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_plan_initial);

        listView = (ListView) findViewById(R.id.con);
        listView.setAdapter(adapter);

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlanInputActivity.class);
                startActivityForResult(intent, 101);

            }
        });

        placeSearch = (Button) findViewById(R.id.placeSearch);
        placeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), placeSearchActivity.class);

                startActivity(intent);
            }
        });
    }

    class PlanSubAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(PlanInitialSubItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            PlanInitailSubItemView view= new PlanInitailSubItemView(getApplicationContext());
            PlanInitialSubItem item = items.get(position);
            view.setPlaceTime(item.getPlaceTime());
            view.setPlaceName(item.getPlaceName());
            view.setPlaceMemo(item.getPlaceMemo());
            view.setTransBudgetText(item.getTransBudgetText());
            view.setTransportText(item.getTransportText());
            view.setTransportIc(item.getTransportIc());
            view.setTransportBudget(item.getTransportBudget());

            ImageButton del = (ImageButton) view.findViewById(R.id.deleteButton);
            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent intent = new Intent(getApplicationContext(), DeleteActivity.class);
                    //startActivity(intent);
                }
            });

            return view;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 101){
            if(intent != null){
                adapter.addItem(new PlanInitialSubItem(time, name, memo, tbText, tText, tIc, tBudget));
            }
        }
    }
}

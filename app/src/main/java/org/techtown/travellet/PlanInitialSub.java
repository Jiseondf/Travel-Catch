package org.techtown.travellet;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class PlanInitialSub extends LinearLayout {

    public PlanInitialSub(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public PlanInitialSub(Context context) {
        super(context);

        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.plan_initial_sub, this, true);
    }
}

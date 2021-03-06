package org.techtown.travellet;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog extends Dialog
{

    private Context context;
    boolean del=false;

    CustomDialog m_oDialog;
    public CustomDialog(Context context)
    {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.5f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.custom_dialog);

        m_oDialog = this;

        Button oBtn = (Button)this.findViewById(R.id.button);
        oBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickBtn(v);
            }
        });
    }

    public void onClickBtn(View _oView)
    {
        del = true;
        this.dismiss();
    }

    public boolean getDelete() {
        return del;
    }
}

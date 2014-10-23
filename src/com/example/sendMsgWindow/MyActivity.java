package com.example.sendMsgWindow;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final int height = getResources().getDisplayMetrics().heightPixels;
        Log.d("", "height = " + height);

        final RelativeLayout rlSpace = (RelativeLayout) findViewById(R.id.rl_space);

        rlSpace.postDelayed(new Runnable() {
            @Override
            public void run() {
                int[] position = new int[2];
                rlSpace.getLocationInWindow(position);
                Log.d("", "rlSpace x=" + position[0]);
                Log.d("", "rlSpace y=" + position[1]);

                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height - position[1]);
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
                rlSpace.setLayoutParams(params);
            }
        }, 1000);

    }
}

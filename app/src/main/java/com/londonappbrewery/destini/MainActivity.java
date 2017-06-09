package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mupperButton;
    Button mlowerButton;
    TextView mtextStory;
    int upper = 0;
    int lower = 0;
    int mStoryIndex = 0;
    boolean left = false;
    boolean right = false;

    private int[] UpperButtonStr = new int[]{
           R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1
    };

    private int[] LowerButtonStr = new int[]{
            R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2
    };

    private int[] TextStr = new int[]{
            R.string.T1_Story, R.string.T2_Story, R.string.T3_Story,
            R.string.T4_End, R.string.T5_End, R.string.T6_End
    };

    final int UPPER_OPT = UpperButtonStr.length;
    final int LOWER_OPT = LowerButtonStr.length;
    final int TEXT_OPT = TextStr.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mupperButton = (Button) findViewById(R.id.buttonTop);
        mlowerButton = (Button) findViewById(R.id.buttonBottom);
        mtextStory = (TextView) findViewById(R.id.storyTextView);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mupperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++upper;
                Log.d("lower=" +lower, "upper=" +upper);
                if(left == true)
                {
                    updateAsLeft();
                }
                else{
                    updateAsRight();
                }


            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mlowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++lower;
                Log.d("lower=" +lower, "upper=" +upper);
                if(right == true)
                {
                    updateAsRight();
                }
                else{
                    updateAsLeft();
                }
            }
        });

        if((upper != 0) && (mStoryIndex ==0)){
           left = true;
        }else{
            right = true;
        }

        ++ mStoryIndex;

    }

    private void updateAsLeft(){
        if((upper == 1) && (lower == 0))
        {
            mupperButton.setText(UpperButtonStr[2]);
            mlowerButton.setText(LowerButtonStr[2]);
            mtextStory.setText(TextStr[2]);
        }
        else if((upper == 2) && (lower == 0))
        {
            mtextStory.setText(TextStr[5]);
        }
        else if((upper == 1) && (lower == 1)){
            mtextStory.setText(TextStr[4]);
        }

    }

    private void updateAsRight()
    {
        if((upper == 0) && (lower == 1))
        {
            mupperButton.setText(UpperButtonStr[1]);
            mlowerButton.setText(LowerButtonStr[1]);
            mtextStory.setText(TextStr[1]);
        }
        else if((upper == 0) && (lower == 2))
        {
            mtextStory.setText(TextStr[3]);
        }
        else if((upper == 1) && (lower == 1)){
            mupperButton.setText(UpperButtonStr[2]);
            mlowerButton.setText(LowerButtonStr[2]);
            mtextStory.setText(TextStr[2]);
        }
        else if((upper == 2) && (lower == 1)){
            mtextStory.setText(TextStr[5]);
        }
        else if((upper == 1) && (lower == 2)){
            mtextStory.setText(TextStr[4]);
        }

    }

}

package com.example.xyploteg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class Parameters extends Activity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    Button mCheatButton;


    TextView mQuestionTextView;

    TextView XXXQuestionTextView;
    TextView TTTQuestionTextView;

    private String xxxdim   ;    
    private String tttdim   ;    

    int mCurrentIndex = 0;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.parameters);


        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
	String hello = "Parameters of simulation"  ;
	mQuestionTextView.setText(hello);

	//
	//  load lattice volume
	//

        XXXQuestionTextView = (TextView)findViewById(R.id.XXX_view);
	xxxdim = "4"  ;
	String xdim = "nx = " + xxxdim  ;
	XXXQuestionTextView.setText(xdim);


        TTTQuestionTextView = (TextView)findViewById(R.id.TTT_view);
	tttdim = "8"  ;
	String tdim = "nt = " + tttdim  ;
	TTTQuestionTextView.setText(tdim);


	//
	//  Run simulation
	//

        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "cheat button clicked");
		// need to rename MainActivity.java
                Intent i = new Intent(Parameters.this, RunLQCD.class);
                Log.d(TAG, "intent created");


		EditText editText = (EditText) findViewById(R.id.XXX_edit_message);
		xxxdim = editText.getText().toString();


		i.putExtra("Xdim", xxxdim);
		i.putExtra("Tdim", tttdim);
                startActivityForResult(i, 0);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	//        mIsCheater = data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }
    
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }

}

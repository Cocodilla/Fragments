package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.fragments.R;
import com.example.fragments.fragments.FirstFragment;
import com.example.fragments.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    Button fragmentButton1, fragmentButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentButton1 = (Button) findViewById(R.id.ButtonOfFragment1);
        fragmentButton2 = (Button) findViewById(R.id.ButtonOfFragment2);

        // Fragment specific
// get fragment Manager to work with fragments
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // add fragment to the screen
        FirstFragment firstFragment = FirstFragment.newInstance("1","2");
        fragmentTransaction.add(R.id.container, firstFragment, "String");
        fragmentTransaction.commit();


        fragmentButton1.setOnClickListener(onButtonClickListener);
        fragmentButton2.setOnClickListener(onButtonClickListener);
    }
    Button.OnClickListener onButtonClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment newFragment = null;
            if(v== fragmentButton1){
                newFragment = new FirstFragment();
            }else{
                newFragment = new SecondFragment();
            }
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }
    };

}
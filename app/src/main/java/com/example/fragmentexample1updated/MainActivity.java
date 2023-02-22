package com.example.fragmentexample1updated;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private Boolean isFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.open_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFragmentDisplayed) {
                    displayFragment();
                }
                else {
                    closeFragment();
                }
            }
        });
    }

    public void displayFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SimpleFragment simpleFragment = SimpleFragment.newInstance();

        fragmentTransaction.add(R.id.frame_container, simpleFragment).addToBackStack(null).commit();

        isFragmentDisplayed = true;
        mButton.setText(R.string.close);
    }

    public void closeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.frame_container);

        if (simpleFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();
        }

        mButton.setText(R.string.open);
        isFragmentDisplayed = false;
    }
}
package com.example.fragmenttest3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements ColorFragment.OnColorChangeListener{

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.main_layout_id);
        ColorFragment colorFragment = new ColorFragment();
       // FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,colorFragment,null);
        fragmentTransaction.commit();

    }

    @Override
    public void colorChanged(String color_name) {

        if(color_name.equals("RED"))
        {
           linearLayout.setBackgroundColor(Color.RED);
        }
        else if(color_name.equals("BLUE"))
        {
            linearLayout.setBackgroundColor(Color.BLUE);
        }
        else if(color_name.equals("GREEN"))
        {
            linearLayout.setBackgroundColor(Color.GREEN );
        }

    }
}

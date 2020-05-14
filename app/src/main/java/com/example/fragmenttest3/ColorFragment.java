package com.example.fragmenttest3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ColorFragment extends Fragment {

    RadioGroup Color_group;
    OnColorChangeListener onColorChangeListener;


    public View onCreateView(LayoutInflater inflater, ViewGroup container , Bundle savedInstanceState)
    {
       View view;
       view = inflater.inflate(R.layout.color_fragment_layout,container,false);

    Color_group=view.findViewById(R.id.color_group);
    Color_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId)
            {
                case R.id.red_id:

                    onColorChangeListener.colorChanged("RED");
                    break;
                case R.id.blue_id:
                    onColorChangeListener.colorChanged("BLUE");
                    break;
                case R.id.green_id:
                    onColorChangeListener.colorChanged("GREEN");
                    break;
            }
        }
    });
    return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            onColorChangeListener = (OnColorChangeListener) context;
        }catch(ClassCastException e)
        {

        }
    }

    public interface OnColorChangeListener
    {
        public void colorChanged(String color_name);

    }

}

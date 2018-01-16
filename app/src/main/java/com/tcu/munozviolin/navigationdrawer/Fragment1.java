package com.tcu.munozviolin.navigationdrawer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener{
    View v;
    Button b;
    Button b1;
    Button b2;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_fragment1, container, false);
        b = (Button) v.findViewById(R.id.button);
        b1 = (Button) v.findViewById(R.id.button1);
        b2 = (Button) v.findViewById(R.id.mar);
        b.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        Intent i;
        int b = view.getId();
        int a = R.id.button;
        int k = R.id.button1;
        int c = R.id.mar;

        if (b == a){
            i = new Intent(view.getContext(), palabra1.class);
            startActivity(i);
        } else if (b == k){
            i = new Intent(view.getContext(), palabra2.class);
            startActivity(i);
        } else if (b == c){
            i = new Intent(view.getContext(), palabra3.class);
            startActivity(i);
        }

        /*switch (v.getId()){
            case R.id.button:
                i = new Intent(view.getContext(), palabra1.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(view.getContext(), palabra2.class);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(view.getContext(), palabra3.class);
                startActivity(i);
                break;
        }*/

    }
}

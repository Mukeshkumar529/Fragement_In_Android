package com.mukeshsah.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final

    String ROOT_FRAGMENT_TAG = String.valueOf(0);
    Button btnFragA, btnFragB, btnFragC;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);

        //Default Frag open

        loadFrag(new BFragment(), 0);

        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loadFrag(new AFragment(),1);



            }
        });

        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loadFrag(new BFragment(),1);
            }
        });

        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            loadFrag(new CFragment(),1);
            }
        });
    }

    public  void loadFrag(Fragment fragment,int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

//                AFragment  aFragment = new AFragment();

        if(flag==0){
            ft.add(R.id.Container,fragment);
            fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);

        }else
        {
            ft.replace(R.id.Container,fragment);

            ft.addToBackStack(null);
        }
        ft.commit();
    }
}

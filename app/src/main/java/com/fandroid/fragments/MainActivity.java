package com.fandroid.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;



public class MainActivity extends Activity implements Fragment1.onContactsClickListener,Fragment2.onBackClickListener,
        Fragment2.onContactClickListener,Fragment3.OnHomeClickListener,Fragment3.OnBackClick{

    Fragment1 frag1;
    Fragment2 frag2;
    Fragment3 frag3;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();
        frag1 = Fragment1.newInstance();
        frag1.setOnContactsClickListener(this);
        fm.beginTransaction().replace(R.id.frgmCont, frag1).addToBackStack(null).commit();
    }

    @Override
    public void onContactsClick() {
        fm= getFragmentManager();
        frag2=Fragment2.newInstance();
        frag2.setOnContactClickListener(this);
        fm.beginTransaction().replace(R.id.frgmCont, frag2).addToBackStack(null).commit();
    }

    @Override
    public void onBack() {
        fm= getFragmentManager();
        fm.popBackStack();
    }
    String name;
    String phone_number;
    @Override
    public void onContactClick(ItemData item) {
        fm = getFragmentManager();
        name=item.getName();
        phone_number=item.getNumber_phone();
        frag3 = Fragment3.newInstance(name, phone_number);
        fm.beginTransaction().replace(R.id.frgmCont, frag3).addToBackStack(null).commit();
    }
    @Override
    public void onHomeClick() {
        fm = getFragmentManager();
        frag3=Fragment3.newInstance1();
        frag3.setOnHomeClickListener(this);
        fm.beginTransaction().replace(R.id.frgmCont, frag1).addToBackStack(null).commit();
    }

    @Override
    public void onBackClickListener() {
        fm= getFragmentManager();
        fm.popBackStack();
    }
}






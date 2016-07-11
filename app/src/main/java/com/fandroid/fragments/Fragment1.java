package com.fandroid.fragments;



import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment1 extends Fragment implements View.OnClickListener {
    public interface onContactsClickListener  {
        void onContactsClick();
    }
  private onContactsClickListener contactsClickListener;
    Button btn_contact;
    public Fragment1(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1,container,false);
        btn_contact = (Button) v.findViewById(R.id.btn_contact);
        btn_contact.setOnClickListener(this);
        return v;
    }

    public static Fragment1 newInstance() {
     Fragment1 fragment=new Fragment1();
        return fragment;
    }
    public void setOnContactsClickListener(onContactsClickListener onContactsClickListener){
        contactsClickListener=onContactsClickListener;
    }

    @Override
    public void onAttach(Activity activity) {
        try {
            contactsClickListener = (onContactsClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onContactsClickListener");
        }
        super.onAttach(activity);
    }
    @Override
    public void onClick(View v) {

        if (contactsClickListener == null) return;
       contactsClickListener.onContactsClick();

    }

    @Override
    public void onDetach() {
        contactsClickListener=null;
        super.onDetach();
    }
}








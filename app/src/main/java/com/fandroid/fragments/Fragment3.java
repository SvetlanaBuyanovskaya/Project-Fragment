package com.fandroid.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

public class Fragment3 extends Fragment {
    public interface OnBackClick{
        void onBackClickListener();
    }

    public interface OnHomeClickListener {
        void onHomeClick();
    }

    TextView tv_recName,tv_recNumber,tv_nContact;

    ImageView im_tel;
    Button btn_back2,btn_home,btn_sendM,btn_sendC;
    private String name;
    private String number;
    private OnHomeClickListener HomeClickListener;
    private OnBackClick BackClick;
    public Fragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment3, container, false);
        tv_recName = (TextView) v.findViewById(R.id.tv_recName);
        tv_recNumber = (TextView) v.findViewById(R.id.tv_recNumber);
        tv_nContact = (TextView) v.findViewById(R.id.tv_nContact);
        im_tel = (ImageView) v.findViewById(R.id.im_tel);
        btn_back2 = (Button) v.findViewById(R.id.btn_back2);
        btn_sendM = (Button) v.findViewById(R.id.btn_sendM);
        btn_sendC = (Button) v.findViewById(R.id.btn_sendC);
        btn_home = (Button) v.findViewById(R.id.btn_home);
        btn_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BackClick == null) return;
                BackClick.onBackClickListener();

            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HomeClickListener == null) return;
                HomeClickListener.onHomeClick();

            }
        });
        name = getArguments().getString("name");
        tv_recName.setText(name);
        number = getArguments().getString("numberPhone");
        tv_recNumber.setText(number);
        return v;
    }

    public static Fragment3 newInstance(String name, String number_phone) {
        Fragment3 frag = new Fragment3();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("numberPhone", number_phone);
        frag.setArguments(bundle);
        return frag;
    }

    public static Fragment3 newInstance1() {
        Fragment3 fragment = new Fragment3();
        return fragment;
    }

    public void setOnHomeClickListener(OnHomeClickListener OnHomeClickListener) {
        HomeClickListener = OnHomeClickListener;
    }

    @Override
    public void onAttach(Activity activity) {
        try {
            HomeClickListener = (OnHomeClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onHomeClickListener");
        }try{
            BackClick=(OnBackClick)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onBackClick");

    }
        super.onAttach(activity);
    }
    @Override
    public void onDetach() {
        HomeClickListener=null;
        BackClick=null;
        super.onDetach();
    }
}



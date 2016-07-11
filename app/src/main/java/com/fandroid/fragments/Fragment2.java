package com.fandroid.fragments;



import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment2 extends Fragment  implements View.OnClickListener{
    public interface onContactClickListener{
        void onContactClick(ItemData item);
    }

    public interface onBackClickListener  {
         void onBack();
    }

    public Fragment2(){
    }
    private onBackClickListener myListener;
    private onContactClickListener contactListener;
    Button btn_back;
    private RecyclerView recView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager lvManager;
    final ItemData items[] = {new ItemData("Bob", R.drawable.icon_default2, "+30509993929"),
            new ItemData("Ben", R.drawable.icon_default2, "+30509993930"),
            new ItemData("Steven", R.drawable.icon_default2, "+30509993931"),
            new ItemData("Tom", R.drawable.icon_default2, "+30509993932"),
            new ItemData("Tim", R.drawable.icon_default2, "+30509993933"),
            new ItemData("Gary", R.drawable.icon_default2, "+30509993934"),
            new ItemData("Kim", R.drawable.icon_default2, "+30509993935"),
            new ItemData("Kely", R.drawable.icon_default2, "+30509993936"),
            new ItemData("Gary", R.drawable.icon_default2, "+30509993937")};

    public static Fragment2 newInstance( ) {
        Fragment2 fragm=new Fragment2();
        return fragm;
    }

    public void setOnContactClickListener(onContactClickListener onContactClickListener){
        contactListener=onContactClickListener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment2, container, false);
        btn_back = (Button) v.findViewById(R.id.btn_back);
        recView = (RecyclerView) v.findViewById(R.id.recView);
        btn_back.setOnClickListener(this);
        lvManager = new LinearLayoutManager(getActivity());
        recView.setLayoutManager(lvManager);
        myAdapter = new MyAdapter(items);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("@@@@@",""+position);
                contactListener.onContactClick(items[position]);
            }
        });
                recView.setAdapter(myAdapter);
                return v;
            }

    @Override
    public void onAttach(Activity activity) {
        try {
            myListener = (onBackClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onBackClickListener");
        }
        super.onAttach(activity);
    }

    @Override
    public void onClick(View v) {
        if (myListener == null) return;
        myListener.onBack();
        myListener = null;
    }

}
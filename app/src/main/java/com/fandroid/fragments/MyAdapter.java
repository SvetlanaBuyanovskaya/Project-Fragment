package com.fandroid.fragments;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    public interface OnItemClickListener {
        void onItemClick( int position);

    }

    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private ItemData[] items;
    public MyAdapter(ItemData[] items) {
        this.items = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        final ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_Name.setText(items[position].getName());
        holder.im_View.setImageResource(items[position].getImage());
        holder.tv_number.setText(items[position].getNumber_phone());
        holder.rl_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
    class ViewHolder extends RecyclerView.ViewHolder  {
        TextView tv_Name;
        TextView tv_number;
        ImageView im_View;
        RelativeLayout rl_contact;
        public ViewHolder(View v) {
            super(v);
            tv_Name = (TextView) v.findViewById(R.id.tv_Name);
            im_View = (ImageView) v.findViewById(R.id.im_View);
            tv_number = (TextView) v.findViewById(R.id.tv_number);
            rl_contact=(RelativeLayout)v.findViewById(R.id.rl_contact);

        }
    }

    }




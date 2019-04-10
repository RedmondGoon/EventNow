package com.example.redmo.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.redmo.myapplication.R;

import java.util.List;

public class CategoryViewAdapter extends RecyclerView.Adapter<CategoryViewAdapter.ViewHolder> {

    private List<String> catList;
    private List<String> catImgList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    public Context context;

    // data is passed into the constructor
    public CategoryViewAdapter(Context context, List<String> catList, List<String> catImgList) {
        this.mInflater = LayoutInflater.from(context);
        this.catList = catList;
        this.catImgList = catImgList;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull

    //public Context getContext(){
       // return context;
    //}
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.category, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { ;
        String text = catList.get(position%catList.size());
        String img = catImgList.get(position%catImgList.size());
        int id = getImageId(context,img);
        holder.myTextView.setText(text);
        holder.myView.setImageResource(id);
        //holder.myView.setImageResource(catImgList);

        //holder.myView.setImageResource();
    }
    private static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
    // total number of rows
    @Override
    public int getItemCount() {
        return catList.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myView;
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myView = itemView.findViewById(R.id.catImg);
            myTextView = itemView.findViewById(R.id.catName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return catImgList.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
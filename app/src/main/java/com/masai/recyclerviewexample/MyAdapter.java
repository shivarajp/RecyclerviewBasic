package com.masai.recyclerviewexample;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    ArrayList<DataModel> myNames = new ArrayList<>();
    Context context;
    OnNameItemClicked mListener;

    MyAdapter(ArrayList<DataModel> names, Context context, OnNameItemClicked listener){
        myNames = names;
        this.context = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view1 = inflater.inflate(R.layout.names_item, parent, false);
        View view2 = inflater.inflate(R.layout.item_type_two, parent, false);

        if (viewType == 1){
            return new ViewHolder(view1);
        }else {
            return new ViewHolder2(view2);
        }
    }

    @Override
    public int getItemViewType(int position) {
        DataModel currentRow = myNames.get(position);
        if (currentRow.getType() == 1){
            return 1;
        }else {
            return 2;
        }

        //return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DataModel dataModel = myNames.get(position);

        if (dataModel.getType() == 1){
            //We have to load viewholder 1
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.nameTv.setText(dataModel.getName());
        }else {
            //we have to load viewholder2
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.name.setText(dataModel.getName());
            holder2.lastName.setText(dataModel.getLastName());
        }

    }

    @Override
    public int getItemCount() {
        return myNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameTv;
        ImageView closeImage;

        public ViewHolder(@NonNull View view) {
            super(view);

            nameTv = view.findViewById(R.id.textView);
            closeImage = view.findViewById(R.id.deleteImage);

        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder{

        TextView name;
        TextView lastName;
        ImageView image;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            lastName = itemView.findViewById(R.id.textView2);
            image = itemView.findViewById(R.id.image);
        }
    }
}

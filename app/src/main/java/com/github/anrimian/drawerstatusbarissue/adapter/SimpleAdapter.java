package com.github.anrimian.drawerstatusbarissue.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.anrimian.drawerstatusbarissue.R;
import com.github.anrimian.drawerstatusbarissue.utils.OnTransitionItemClickListener;

/**
 * Created on 12.10.2017.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder>{

    private OnTransitionItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnTransitionItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_card, parent, false);
        return new SimpleViewHolder(itemView, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }
}

package com.github.anrimian.drawerstatusbarissue.adapter;

import android.content.Context;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.anrimian.drawerstatusbarissue.R;
import com.github.anrimian.drawerstatusbarissue.utils.OnTransitionItemClickListener;

/**
 * Created on 12.10.2017.
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {



    public SimpleViewHolder(View itemView, final OnTransitionItemClickListener itemClickListener) {
        super(itemView);
        if (itemClickListener != null) {
            View clickableItem = itemView.findViewById(R.id.card_view);
            String transitionName = getContext().getString(R.string.card_transition_element);
            final Pair<View, String> transitionInfo = new Pair<>(clickableItem, transitionName);
            clickableItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(null, transitionInfo);
                }
            });
        }
    }

    private Context getContext() {
        return itemView.getContext();
    }
}

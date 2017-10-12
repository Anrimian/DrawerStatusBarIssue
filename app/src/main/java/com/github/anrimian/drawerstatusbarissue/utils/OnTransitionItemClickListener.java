package com.github.anrimian.drawerstatusbarissue.utils;

import android.support.v4.util.Pair;
import android.view.View;

/**
 * Created on 17.01.2017.
 */

public interface OnTransitionItemClickListener<T> {
    void onItemClick(T data, Pair<View, String> transitionInfo);
}

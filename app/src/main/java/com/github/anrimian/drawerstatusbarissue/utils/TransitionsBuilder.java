package com.github.anrimian.drawerstatusbarissue.utils;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class TransitionsBuilder {

    private static final String LOG_TAG = TransitionsBuilder.class.getSimpleName();

    private Activity activity;

    private List<Pair<View, String>> sharedItems = new ArrayList<>();

    public static TransitionsBuilder with(Activity activity) {
        return new TransitionsBuilder(activity);
    }

    private TransitionsBuilder(Activity activity) {
        this.activity = activity;
    }

    public TransitionsBuilder shared(@NonNull View view, @StringRes int transitionNameId) {
        return shared(view, activity.getString(transitionNameId));
    }

    public TransitionsBuilder shared(@NonNull View view,@NonNull String transitionName) {
        sharedItems.add(new Pair<>(view, transitionName));
        return this;
    }

    public TransitionsBuilder shared(@NonNull Pair<View, String> transitionElement) {
        sharedItems.add(transitionElement);
        return this;
    }

    public TransitionsBuilder shared(@IdRes int viewRes, @StringRes int transitionNameId) {
        return shared(viewRes, activity.getString(transitionNameId));
    }

    public TransitionsBuilder shared(@IdRes int viewRes, @NonNull String transitionName) {
        View view = activity.findViewById(viewRes);
        if (view != null) {
            return shared(view, transitionName);
        }
        Log.e(LOG_TAG, "can't find view by id: " + transitionName);
        return this;
    }

    public TransitionsBuilder shared(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return shared(view, view.getTransitionName());
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    public ActivityOptionsCompat build() {
        Pair[] array = sharedItems.toArray(new Pair[sharedItems.size()]);
        return ActivityOptionsCompat.makeSceneTransitionAnimation(activity, array);
    }
}

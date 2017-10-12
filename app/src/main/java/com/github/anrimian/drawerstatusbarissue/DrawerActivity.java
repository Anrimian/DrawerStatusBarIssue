package com.github.anrimian.drawerstatusbarissue;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.github.anrimian.drawerstatusbarissue.adapter.SimpleAdapter;
import com.github.anrimian.drawerstatusbarissue.utils.OnTransitionItemClickListener;
import com.github.anrimian.drawerstatusbarissue.utils.TransitionsBuilder;

public class DrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleAdapter adapter = new SimpleAdapter();
        adapter.setOnItemClickListener(new OnTransitionItemClickListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void onItemClick(Object data, Pair transitionInfo) {
                goToSecondActivity(transitionInfo);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void goToSecondActivity(Pair<View, String> transitionInfo) {
        ActivityOptionsCompat options = TransitionsBuilder.with(this)
                .shared(R.id.toolbar, R.string.toolbar_transition_element)
                .shared(transitionInfo)
                .shared(android.R.id.statusBarBackground, Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME)//statusBarBackground is null
                .shared(android.R.id.navigationBarBackground, Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME)
                .build();
        Intent intent = SecondActivity.newIntent(this);
        startActivity(intent, options.toBundle());
    }
}

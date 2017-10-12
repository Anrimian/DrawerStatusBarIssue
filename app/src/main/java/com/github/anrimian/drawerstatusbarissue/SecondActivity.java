package com.github.anrimian.drawerstatusbarissue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created on 12.10.2017.
 */

public class SecondActivity extends AppCompatActivity {

    public static Intent newIntent(Context ctx) {
        return new Intent(ctx, SecondActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}

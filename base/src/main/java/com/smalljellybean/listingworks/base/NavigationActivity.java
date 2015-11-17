package com.smalljellybean.listingworks.base;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

public abstract class NavigationActivity extends AppCompatActivity {

    protected ViewStub navigationView;
    protected DrawerLayout drawerLayout;
    private DrawerLayout.DrawerListener drawerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        navigationView = ((ViewStub) findViewById(R.id.navigation));
        navigationView.setLayoutResource(getDrawerLayoutResId());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                if (drawerListener != null) {
                    drawerListener.onDrawerClosed(drawerView);
                }
            }
        };
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);
    }

    protected void setDrawerListener(DrawerLayout.DrawerListener listener){
        this.drawerListener = listener;
    }

    protected abstract int getDrawerLayoutResId();

    @Override
    public void setContentView(int layoutResID) {
        FrameLayout content = (FrameLayout) findViewById(R.id.fragment_content);
        getLayoutInflater().inflate(layoutResID, content);
    }
}

package com.example.mysubmission3bfaa.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mysubmission3bfaa.R;
import com.example.mysubmission3bfaa.adapter.SectionPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private int[] tabIcon = {
            R.drawable.baseline_movie_creation_white_24dp,
            R.drawable.baseline_live_tv_white_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionPagerAdapter);

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        setupTabIcons();
        getSupportActionBar().setElevation(0);
    }

    private void setupTabIcons() {
        tabs.getTabAt(0).setIcon(tabIcon[0]);
        tabs.getTabAt(1).setIcon(tabIcon[1]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}

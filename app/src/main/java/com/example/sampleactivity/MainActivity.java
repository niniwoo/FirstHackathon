package com.example.sampleactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.sampleactivity.view.MainViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private ViewPager mPager;
    private TabLayout mTabLayout;
    Button toggle1,toggle2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // For cardview on JOURNAL Page

        // buttons
        toggle1 = findViewById(R.id.btn_src1);
        toggle2 = findViewById(R.id.btn_src2);
        Button selfAssessment = (Button)findViewById(R.id.btn_dsa);
        Button dailyChallenge = (Button)findViewById(R.id.btn_dc);
        Button ineedhelp = (Button)findViewById(R.id.btn_inh);


        ineedhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Ineedhelp.class));
            }
        });

        // Main menu bar
        mPager = findViewById(R.id.main_activity_pager);
        mTabLayout = findViewById(R.id.main_activity_pager_tab_layout);
        MainViewPagerAdapter mPagerAdapter = new MainViewPagerAdapter(getApplicationContext());
        mPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mPager);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    public void clickOne(View view){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        LearningFrag lf = new LearningFrag();
        ft.add(R.id.framelayout,lf);
        ft.commit();
    }
    public void clickTwo(View view){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        SelfcareFrag sf = new SelfcareFrag();
        ft.add(R.id.framelayout,sf);
        ft.commit();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_menu, menu);
        return true;
    }
}
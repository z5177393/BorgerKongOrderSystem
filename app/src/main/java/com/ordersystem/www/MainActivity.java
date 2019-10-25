package com.ordersystem.www;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FrameLayout mFlContain;
    private Button mBtnHome;
    private Button mBtnOrder;
    private FragmentManager supportFragmentManager;
    private HomeFragment homeFragment;
    private MyOrderCarFragment myOrderCarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlContain = findViewById(R.id.fl_contain);
        mBtnHome = findViewById(R.id.btn_home);
        mBtnOrder = findViewById(R.id.btn_order);
        mBtnHome.setOnClickListener(this);
        mBtnOrder.setOnClickListener(this);
        initFragment();
    }

    private void initFragment() {
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        myOrderCarFragment = new MyOrderCarFragment();
        currFramgment = homeFragment;
        fragmentTransaction.add(R.id.fl_contain, homeFragment, "home");
        fragmentTransaction.commit();
        mBtnHome.setEnabled(false);
        mBtnOrder.setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home:
                switchFragment(homeFragment);
                mBtnOrder.setEnabled(true);
                mBtnHome.setEnabled(false);
                break;
            case R.id.btn_order:
                switchFragment(myOrderCarFragment);
                mBtnHome.setEnabled(true);
                mBtnOrder.setEnabled(false);
                break;
        }
    }


    private Fragment currFramgment;

    private void switchFragment(Fragment addFragment) {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        if (addFragment.isAdded()) {
            fragmentTransaction.hide(currFramgment).show(addFragment);
        } else {
            fragmentTransaction.add(R.id.fl_contain, addFragment);
            fragmentTransaction.hide(currFramgment);

        }
        currFramgment = addFragment;
        fragmentTransaction.commit();
    }
}

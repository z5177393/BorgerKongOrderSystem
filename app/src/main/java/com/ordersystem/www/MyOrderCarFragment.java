package com.ordersystem.www;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

public class MyOrderCarFragment extends Fragment {
    private RecyclerView mRvCar;
    private TextView mTvAllmoney;
    private TextView tvNoselect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View carView = View.inflate(getContext(),R.layout.activity_myoder,null);
        mRvCar = carView.findViewById(R.id.rv_my_order);
        mTvAllmoney = carView.findViewById(R.id.tv_allmoney);
        tvNoselect = carView.findViewById(R.id.tv_noselect);
        Button btn_sure = carView.findViewById(R.id.btn_sure);
        Button btn_del_all = carView.findViewById(R.id.btn_del_all);
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Confirmed",Toast.LENGTH_SHORT ).show();
            }
        });

        btn_del_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarData.orderCarList.clear();
                initData();
            }
        });

        return carView;

    }

    private void initData() {
        List<OrderCarsBean> orderCarList = CarData.orderCarList;
        if (orderCarList != null && orderCarList.size() != 0) {
            mRvCar.setVisibility(View.VISIBLE);
            LinearLayoutManager manager = new LinearLayoutManager(getContext());
            mRvCar.setLayoutManager(manager);
            CarRVAdapter foodsRVAdapter = new CarRVAdapter(getContext(), orderCarList);
            mRvCar.setAdapter(foodsRVAdapter);
            double allMoney = 0;
            for (int i = 0; i < orderCarList.size(); i++) {
                allMoney += orderCarList.get(i).getFoodMenuBean().getFoodPrice() * orderCarList.get(i).getFoodNum();
            }
            DecimalFormat df = new DecimalFormat("#.0");
            String allmoneystr = df.format(allMoney);
            mTvAllmoney.setText("$"+allmoneystr);
            tvNoselect.setVisibility(View.GONE);
        }else {
            mRvCar.setVisibility(View.GONE);
            tvNoselect.setVisibility(View.VISIBLE);
            mTvAllmoney.setText("$"+"0.0");
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }
}

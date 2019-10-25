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

public class HomeFragment extends Fragment {
    private RecyclerView mRvFoodsMenu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeView = View.inflate(getContext(),R.layout.fragment_home,null);
        mRvFoodsMenu = homeView.findViewById(R.id.rv_foods_menu);
        initData();
        return homeView;
    }
    private void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvFoodsMenu.setLayoutManager(manager);
        FoodsRVAdapter foodsRVAdapter = new FoodsRVAdapter(getContext(), FoodMenuData.getFoodMenuData());
        mRvFoodsMenu.setAdapter(foodsRVAdapter);
    }

}

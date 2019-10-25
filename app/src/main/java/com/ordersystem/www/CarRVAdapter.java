package com.ordersystem.www;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarRVAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<OrderCarsBean> orderCarsBeanList;

    public CarRVAdapter(Context context, List<OrderCarsBean> foodMenuList){
        this.mContext = context;
        this.orderCarsBeanList = foodMenuList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_car_order, viewGroup, false);
        return new FoodItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        OrderCarsBean orderCarsBean = orderCarsBeanList.get(i);
        FoodMenuBean foodMenuBean = orderCarsBean.getFoodMenuBean();
        ((FoodItemHolder)viewHolder).mTvFoodsTitle.setText(foodMenuBean.getFoodName());
        ((FoodItemHolder)viewHolder).mTvFoodsPrice.setText("$"+foodMenuBean.getFoodPrice());
        ((FoodItemHolder)viewHolder).mTvFoodnum.setText("X"+orderCarsBean.getFoodNum());
        ((FoodItemHolder)viewHolder).mIvImg.setImageDrawable(mContext.getResources().getDrawable(foodMenuBean.getFoodImg()));

    }

    @Override
    public int getItemCount() {
        return orderCarsBeanList.size();
    }

    private class FoodItemHolder extends RecyclerView.ViewHolder{

        private TextView mTvFoodsTitle;
        private TextView mTvFoodsPrice;
        private ImageView mIvImg;
        private TextView mTvFoodnum;

        public FoodItemHolder(View itemView) {
            super(itemView);
            mTvFoodsTitle = (TextView) itemView.findViewById(R.id.tv_foods_title);
            mTvFoodsPrice = (TextView) itemView.findViewById(R.id.tv_foods_price);
            mTvFoodnum = (TextView) itemView.findViewById(R.id.tvfoodnum);

            mIvImg = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }
}

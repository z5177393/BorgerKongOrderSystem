package com.ordersystem.www;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodsRVAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<FoodMenuBean> foodMenuList;

    public FoodsRVAdapter (Context context, List<FoodMenuBean> foodMenuList){
        this.mContext = context;
        this.foodMenuList = foodMenuList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_food_meun, viewGroup, false);
        return new FoodItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final FoodMenuBean foodMenuBean = foodMenuList.get(i);
        ((FoodItemHolder)viewHolder).mTvFoodsTitle.setText(foodMenuBean.getFoodName());
        ((FoodItemHolder)viewHolder).mTvFoodsPrice.setText("$"+foodMenuBean.getFoodPrice());
        ((FoodItemHolder)viewHolder).mIvImg.setImageDrawable(mContext.getResources().getDrawable(foodMenuBean.getFoodImg()));
        ((FoodItemHolder)viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FoodDetailActivity.class);
                intent.putExtra("foodItem",foodMenuBean);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodMenuList.size();
    }

    private class FoodItemHolder extends RecyclerView.ViewHolder{

        private TextView mTvFoodsTitle;
        private TextView mTvFoodsPrice;
        private ImageView mIvImg;

        public FoodItemHolder(View itemView) {
            super(itemView);
            mTvFoodsTitle = (TextView) itemView.findViewById(R.id.tv_foods_title);
            mTvFoodsPrice = (TextView) itemView.findViewById(R.id.tv_foods_price);
            mIvImg = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }
}

package com.ordersystem.www;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FoodDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_food;
    private TextView tv_foods_des;
    private TextView tv_foods_price;
    private ActionBar actionBar;
    private TextView mTvNum;
    private Button btn_add;
    private Button btn_del;
    private Button btn_addtoorder;
    private FoodMenuBean foodItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetail);
        img_food = findViewById(R.id.img_food);
        tv_foods_des = findViewById(R.id.tv_foods_des);
        tv_foods_price = findViewById(R.id.tv_foods_price);
        mTvNum = findViewById(R.id.tv_num);
        btn_add = findViewById(R.id.btn_add);
        btn_del = findViewById(R.id.btn_del);
        btn_addtoorder = findViewById(R.id.btn_addtoorder);
        btn_add.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_addtoorder.setOnClickListener(this);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        foodItem = (FoodMenuBean) intent.getSerializableExtra("foodItem");
        img_food.setImageDrawable(getResources().getDrawable(foodItem.getFoodImg()));
        tv_foods_des.setText(foodItem.getFoodDes());
        tv_foods_price.setText("$" + foodItem.getFoodPrice());
        if (actionBar != null) {
            actionBar.setTitle(foodItem.getFoodName());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private int foodNum = 1;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add: {
                mTvNum.setText("" + ++foodNum);

                btn_del.setEnabled(true);

                break;
            }
            case R.id.btn_del: {
                mTvNum.setText("" + --foodNum);
                if (foodNum == 1) {
                    btn_del.setEnabled(false);
                }
                else if (foodNum <= 1){
                    btn_del.setEnabled(false);

                }
                break;
            }
            case R.id.btn_addtoorder: {

                List<OrderCarsBean> orderCarList = CarData.orderCarList;
                if (orderCarList == null) {
                    orderCarList = new ArrayList<OrderCarsBean>();
                    orderCarList.add(new OrderCarsBean(foodItem, foodNum));
                }else {
                    boolean isContain = false;
                    for (int i = 0; i < orderCarList.size(); i++) {
                        if (orderCarList.get(i).getFoodMenuBean().getFoodName().equals(foodItem.getFoodName())){
                           int num =  orderCarList.get(i).getFoodNum()+ foodNum;
                            orderCarList.set(i,new OrderCarsBean(foodItem, num));
                            isContain = true;
                            break;
                        }

                    }
                    if (!isContain){
                        orderCarList.add(new OrderCarsBean(foodItem, foodNum));
                    }
                }

                CarData.orderCarList = orderCarList;

                //Toast.makeText(this,"add car "+ foodItem.getFoodName()+" "+foodNum+" dish",Toast.LENGTH_SHORT ).show();
                //finish();
                Toast.makeText(this,""+foodNum+" dishes of "+ foodItem.getFoodName()+" have been added into orderlist",Toast.LENGTH_SHORT ).show();
                finish();
                break;
            }
        }
    }
}

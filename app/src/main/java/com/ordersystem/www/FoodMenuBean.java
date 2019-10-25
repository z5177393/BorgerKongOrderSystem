package com.ordersystem.www;

import java.io.Serializable;

public class FoodMenuBean implements Serializable {
    private String foodName;
    private double foodPrice;
    private String foodDes;
    private int foodImg;

    public FoodMenuBean() {
    }

    public FoodMenuBean(String foodName, double foodPrice, String foodDes, int foodImg) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodDes = foodDes;
        this.foodImg = foodImg;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodDes() {
        return foodDes;
    }

    public void setFoodDes(String foodDes) {
        this.foodDes = foodDes;
    }

    public int getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(int foodImg) {
        this.foodImg = foodImg;
    }

    @Override
    public String toString() {
        return "FoodMenuBean{" +
                "foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", foodDes='" + foodDes + '\'' +
                ", foodImg='" + foodImg + '\'' +
                '}';
    }
}

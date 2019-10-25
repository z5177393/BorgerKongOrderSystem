package com.ordersystem.www;

public class OrderCarsBean {
    private FoodMenuBean foodMenuBean;
    private int foodNum;

    public OrderCarsBean() {
    }

    public OrderCarsBean(FoodMenuBean foodMenuBean, int foodNum) {
        this.foodMenuBean = foodMenuBean;
        this.foodNum = foodNum;
    }

    public FoodMenuBean getFoodMenuBean() {
        return foodMenuBean;
    }

    public void setFoodMenuBean(FoodMenuBean foodMenuBean) {
        this.foodMenuBean = foodMenuBean;
    }

    public int getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(int foodNum) {
        this.foodNum = foodNum;
    }
}

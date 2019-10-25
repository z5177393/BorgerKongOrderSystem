package com.ordersystem.www;

import java.util.ArrayList;
import java.util.List;

public class FoodMenuData {
    public static List<FoodMenuBean>  getFoodMenuData(){
        List<FoodMenuBean> foodMenuBeans = new ArrayList<>();
        foodMenuBeans.add(new FoodMenuBean("Braised Pork",10.5,"Braised pork is a famous popular dish, which belongs to Shandong cuisine. It uses streaky pork as the main material. It's best to choose three layers of fat and thin meat (streaky pork) to do it. There are as many as 20 or 30 ways to do it.",R.drawable.img_braisedpork));
        foodMenuBeans.add(new FoodMenuBean("Pizza",5.2, "Pizza, also known as pizza, pizza, pizza, pizza, is a kind of food originated in Italy, which is very popular in the world. The usual way to make pizza is to cover it with ketchup, cheese and other ingredients and bake it in an oven.",R.drawable.img_pizza));
        foodMenuBeans.add(new FoodMenuBean("Pasta",15.1, "Fried spaghetti with bacon and vegetables is a delicacy, mainly made of spaghetti, bacon, cabbage, onion, carrot, etc.",R.drawable.img_pasta));
        foodMenuBeans.add(new FoodMenuBean("Corn Salad",7, "With Western methods, this salad made of Chinese raw materials is rich in color, fresh, palatable, convenient and simple. The main ingredients are: frozen peas, sweet corn, red pepper, cucumber, crab stick, pine nuts, white vinegar, oil, salt, white pepper.",R.drawable.img_corn_salad));
        foodMenuBeans.add(new FoodMenuBean("Stewed chicken leg rice",12, "A delicious braised chicken leg rice needs fresh, tender and soft chicken, full of gravy, fried chicken skin to scorched yellow, hung with sauce shining in the light, and rich enough sauce.",R.drawable.img_stewd_chicken));
        foodMenuBeans.add(new FoodMenuBean("Mushroom sauce and pepper salad",6.2, "This dish is a combination of traditional mushroom sauce and Western style salad. It's served with delicious, crispy peanuts. It's rich in taste, sweet, crispy and slightly spicy. It can be recommended by Ziyu's mother's list of Chinese and Western dishes",R.drawable.img_mushroom_salad));
        foodMenuBeans.add(new FoodMenuBean("Japanese tofu in Thai Sauce",12.5, "Japanese tofu is cut into round pieces, wrapped with cornflour, and then dipped with egg white. Deep fry in warm oil until slightly yellow.",R.drawable.img_japanese_tofu));
        foodMenuBeans.add(new FoodMenuBean("KoreanDishes",14, "Add 1 spoon salt and 1 spoon sugar and mix well. Refrigerate for more than 30 minutes.",R.drawable.img_korean_dishes));
        foodMenuBeans.add(new FoodMenuBean("Sashimi salmon",9, "Salmon sashimi is a kind of sashimi made of salmon. Sashimi is a traditional Japanese food. It's the lightest dish in Japanese cuisine, and it's very popular with Japanese.",R.drawable.img_sashimi));
        foodMenuBeans.add(new FoodMenuBean("Orange shrimp salad",18.2, "Orange shrimp salad is a kind of food made of orange, shrimp and other ingredients",R.drawable.img_orange_shirmp_salad));
        foodMenuBeans.add(new FoodMenuBean("Miso soup",9.9, "The big sauce soup is an indispensable traditional dish for the daily dining table from the president to the common people. Originating from the Korean Peninsula, it has a long history on the Korean peninsula since ancient times.",R.drawable.img_miso_soup));
        foodMenuBeans.add(new FoodMenuBean("Vietnam Spring rolls",10.8, "This is a rice skin package made of rice ground pulp. The filling is mainly shrimp meat, pork and local vegetables. It is a quite popular dish in Vietnam.",R.drawable.img_vietnam_spring));
        foodMenuBeans.add(new FoodMenuBean("Tiramisu",6, "Tiramisu, in English, is an Italian dessert with coffee and wine flavor.",R.drawable.img_tiramisu));
        foodMenuBeans.add(new FoodMenuBean("Korean cold noodles",11.2, "The official name of Korean cold noodles is Korean cold noodles, which is one of the traditional Korean cuisines.",R.drawable.img_korean_noodles));
        foodMenuBeans.add(new FoodMenuBean("Fruit Tower",13.6, "Fruit Tower. English tea, full of wheat flavor, crisp texture, fresh and delicious fruit;",R.drawable.img_fruit_tower));
        foodMenuBeans.add(new FoodMenuBean("Taste added radish",16.8, "The flavored radish is a side dish. It is made by washing the kunbu and boiling the bonito flower for half a minute. Its raw materials are Changbai radish and kunbu. It is a delicacy after people's tea.",R.drawable.img_taste_radish));
        return foodMenuBeans;
    }
}

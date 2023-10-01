package model;

import utils.Demonstrate;

public class Dish implements Demonstrate {
    private int dishId;
    private String dishName;
    private int dishPrice;

    public Dish(String dishName, int dishPrice) {
        this.dishId = (int)(Math.random()*1000);
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }

    public Dish(){
        this.dishId = (int)(Math.random()*1000);
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }

    @Override
    public void demonstrate() {
        System.out.println(dishId + " " + dishName + " " + dishPrice + "г");
        System.out.println("____________________________");
    }
}

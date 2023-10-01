package model;

import utils.Demonstrate;

public class CafeteriaDish implements Demonstrate {
    private int id;
    private int dishId;
    private String dishName;
    private int cafId;
    private String cafName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getCafName() {
        return cafName;
    }

    public void setCafName(String cafName) {
        this.cafName = cafName;
    }

    public CafeteriaDish(Dish dish, Cafeteria cafeteria) {
        this.id = (int)(Math.random()*1000);
        this.dishId = dish.getDishId();
        this.dishName = dish.getDishName();
        this.cafId = cafeteria.getCafId();
        this.cafName = cafeteria.getCafName();
    }

     public CafeteriaDish() {
         this.id = (int) (Math.random() * 1000);
     }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getCafId() {
        return cafId;
    }

    public void setCafId(int cafId) {
        this.cafId = cafId;
    }

    @Override
    public void demonstrate() {
        System.out.println(dishId + " " + dishName + " " + cafId + " " + cafName);
        System.out.println("____________________________");
    }
}

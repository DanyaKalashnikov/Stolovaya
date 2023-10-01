package repository;

import model.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishRepo implements Repository<Dish>{
    private final String id = "d";
    List<Dish> dishes = new ArrayList<>();

    @Override
    public List getAllEntity() {
        return dishes;
    }

    @Override
    public String getRepoId() {
        return id;
    }

    @Override
    public Dish getEntityById(int id) {
        for (Dish dish : dishes){
            if (dish.getDishId() == id) return dish;
        }
        return null;
    }

    @Override
    public void deleteEntityById(int id) {
        for (Dish dish : dishes){
            if (dish.getDishId() == id) dishes.remove(dish);
        }
    }

    @Override
    public void saveEntity(Dish entity) {
        dishes.add(entity);
    }
}

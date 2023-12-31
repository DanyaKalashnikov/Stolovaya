package repository;

import model.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishRepo implements Repository<Dish>{
    private List<Dish> dishes = new ArrayList<>();

    @Override
    public List<Dish> getAllEntity() {
        return dishes;
    }

    @Override
    public Dish getEntityById(int id) {
        for (Dish dish : dishes){
            if (dish.getDishId() == id) return dish;
        }
        return null;
    }

    @Override
    public void deleteEntity(Dish entity) {
        dishes.remove(entity);
    }



    @Override
    public void saveEntity(Dish entity) {
        dishes.add(entity);
    }
}

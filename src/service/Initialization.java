package service;

import model.Cafeteria;
import model.CafeteriaDish;
import model.Dish;
import repository.CafeteriaDishRepo;
import repository.CafeteriaRepo;
import repository.DishRepo;
import repository.Repository;

import java.util.List;

public class Initialization {
    public void init(List<Repository> list){
        Repository<Dish> dishRepo = new DishRepo();
        Repository<Cafeteria> cafRepo = new CafeteriaRepo();
        Repository<CafeteriaDish> cafDishRepo = new CafeteriaDishRepo();

        Cafeteria cafeteria = new Cafeteria("ВПузо", "ул. Домодедова, 66");
        Dish dish = new Dish("Шаурма сырная", 200);
        CafeteriaDish cafDish = new CafeteriaDish(dish, cafeteria);

        cafRepo.saveEntity(cafeteria);
        dishRepo.saveEntity(dish);
        cafDishRepo.saveEntity(cafDish);

        list.add(cafRepo);
        list.add(dishRepo);
        list.add(cafDishRepo);
    }
}

package service;

import model.Dish;
import repository.DishRepo;

import java.util.List;
import java.util.Scanner;

public class DishService implements Service {
    private DishRepo dishRepo;

    public DishRepo getDishRepo() {
        return dishRepo;
    }

    public DishService(DishRepo dishRepo) {
        init(dishRepo);
        this.dishRepo = dishRepo;
    }

    private void init(DishRepo dishRepo) {
        Dish dish = new Dish("Шаурма сырная", 200);
        dishRepo.saveEntity(dish);
    }

    @Override
    public List demonstrate() {
        return dishRepo.getAllEntity();
    }

    @Override
    public void add(String one, String two) {
        dishRepo.saveEntity(new Dish(one, Integer.parseInt(two)));
    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id блюда для удаления:");
        int id = scanner.nextInt();
        for (Dish dish : dishRepo.getAllEntity()){
            if(dish.getDishId() == id) dishRepo.deleteEntity(dish);
        }
    }
}

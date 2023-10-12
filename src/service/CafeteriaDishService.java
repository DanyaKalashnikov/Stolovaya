package service;

import model.Cafeteria;
import model.CafeteriaDish;
import model.Dish;
import repository.CafeteriaDishRepo;
import repository.CafeteriaRepo;
import repository.DishRepo;
import repository.Repository;
import utils.Demonstrate;

import java.util.Scanner;

public class CafeteriaDishService implements Service {
    private CafeteriaDishRepo cafeteriaDishRepo;

    public CafeteriaDishService(CafeteriaDishRepo cafeDishRepo, CafeteriaService cafeService, DishService dishService) {
        init(cafeDishRepo, cafeService, dishService);
        this.cafeteriaDishRepo = cafeDishRepo;
    }

    public void init(CafeteriaDishRepo cafeDishRepo, CafeteriaService cafeService, DishService dishService) {
        Cafeteria cafeteria = cafeService.getCafeRepo().getAllEntity().get(0);
        Dish dish = dishService.getDishRepo().getAllEntity().get(0);
        CafeteriaDish cafeteriaDish = new CafeteriaDish(cafeteria, dish);
        cafeDishRepo.saveEntity(cafeteriaDish);
    }

    @Override
    public void demonstrate() {
        for (Demonstrate demo : cafeteriaDishRepo.getAllEntity()) demo.demonstrate();
    }

    public void addCafeteriaDishRepo(CafeteriaService cafeteriaService, DishService dishService) {
        Scanner scanner = new Scanner(System.in);
        Dish dish;
        Cafeteria cafeteria;
        CafeteriaDish cafeteriaDish = new CafeteriaDish();

        System.out.println("Выберите существующий кафетерий:");

        cafeteriaService.demonstrate();

        System.out.println("Введите индекс кафетерия:");
        int cafId = scanner.nextInt();

        System.out.println("Выберите существующее блюдо:");

        dishService.demonstrate();

        System.out.println("Введите индекс блюда:");
        int dishId = scanner.nextInt();

        cafeteria = cafeteriaService.getCafeRepo().getEntityById(cafId);
        dish = dishService.getDishRepo().getEntityById(dishId);

        cafeteriaDish.setCafId(cafeteria.getCafId());
        cafeteriaDish.setCafName(cafeteria.getCafName());
        cafeteriaDish.setDishId(dish.getDishId());
        cafeteriaDish.setDishName(dish.getDishName());
        cafeteriaDishRepo.saveEntity(cafeteriaDish);
        System.out.println("Успешно!");
    }

    @Override
    public void add() {

    }
}

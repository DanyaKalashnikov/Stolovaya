package service;

import model.Cafeteria;
import model.CafeteriaDish;
import model.Dish;
import repository.CafeteriaDishRepo;

import java.util.List;
import java.util.Scanner;

public class CafeteriaDishService implements Service {
    private CafeteriaDishRepo cafeteriaDishRepo;
    private CafeteriaService cafeService;
    private DishService dishService;

    public CafeteriaDishService(CafeteriaDishRepo cafeDishRepo, CafeteriaService cafeService, DishService dishService) {
        init(cafeDishRepo, cafeService, dishService);
        this.cafeteriaDishRepo = cafeDishRepo;
        this.cafeService = cafeService;
        this.dishService = dishService;

    }

    public void init(CafeteriaDishRepo cafeDishRepo, CafeteriaService cafeService, DishService dishService) {
        Cafeteria cafeteria = cafeService.getCafeRepo().getAllEntity().get(0);
        Dish dish = dishService.getDishRepo().getAllEntity().get(0);
        CafeteriaDish cafeteriaDish = new CafeteriaDish(cafeteria, dish);
        cafeDishRepo.saveEntity(cafeteriaDish);
    }

    public CafeteriaService getCafeService() {
        return cafeService;
    }

    public DishService getDishService() {
        return dishService;
    }

    @Override
    public List<CafeteriaDish> demonstrate() {
        return cafeteriaDishRepo.getAllEntity();
    }

    @Override
    public void add(String one, String two) {
        Dish dish;
        Cafeteria cafeteria;
        CafeteriaDish cafeteriaDish = new CafeteriaDish();

        cafeteria = cafeService.getCafeRepo().getEntityById(Integer.parseInt(one));
        dish = dishService.getDishRepo().getEntityById(Integer.parseInt(two));

        cafeteriaDish.setCafId(cafeteria.getCafId());
        cafeteriaDish.setCafName(cafeteria.getCafName());
        cafeteriaDish.setDishId(dish.getDishId());
        cafeteriaDish.setDishName(dish.getDishName());
        cafeteriaDishRepo.saveEntity(cafeteriaDish);
    }

    @Override
    public void delete() {

    }

    public void deleteCafebyId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id кафетерия для удаления:");
        int id = scanner.nextInt();
        for (CafeteriaDish cafeteriaDish : cafeteriaDishRepo.getAllEntity()){
            if(cafeteriaDish.getCafId() == id) {
                cafeteriaDishRepo.deleteEntity(cafeteriaDish);
            }
        }
    }

    public void deleteDishbyId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id блюда для удаления:");
        int id = scanner.nextInt();
        for (CafeteriaDish cafeteriaDish : cafeteriaDishRepo.getAllEntity()){
            if(cafeteriaDish.getDishId() == id) {
                cafeteriaDishRepo.deleteEntity(cafeteriaDish);
            }
        }
    }
}

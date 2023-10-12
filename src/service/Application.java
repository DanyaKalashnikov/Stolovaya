package service;

import model.Cafeteria;
import model.CafeteriaDish;
import model.Dish;
import repository.CafeteriaDishRepo;
import repository.CafeteriaRepo;
import repository.DishRepo;
import repository.Repository;
import utils.Demonstrate;
import utils.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public void start() {
        CafeteriaRepo cafeRepo = new CafeteriaRepo();
        CafeteriaService cafeService = new CafeteriaService(cafeRepo);
        DishRepo dishRepo = new DishRepo();
        DishService dishService = new DishService(dishRepo);
        CafeteriaDishRepo cafeteriaDishRepo = new CafeteriaDishRepo();
        CafeteriaDishService cafeteriaDishService = new CafeteriaDishService(cafeteriaDishRepo, cafeService, dishService);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu.showMainMenu();
            int a = scanner.nextInt();

            switch (a) {
                case 11:
                    cafeService.demonstrate();
                    break;
                case 12:
                    dishService.demonstrate();
                    break;
                case 13:
                    cafeteriaDishService.demonstrate();
                    break;
                case 21:
                    cafeService.add();
                    break;

                case 22:
                    dishService.add();
                    break;

                case 23:
                    cafeteriaDishService.addCafeteriaDishRepo(cafeService, dishService);
                    break;

                case 3:
                    System.exit(3);
            }
        }
    }
}

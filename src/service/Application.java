package service;

import View.CafeteriaDishView;
import View.CafeteriaView;
import View.DishView;
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
        CafeteriaView cafeView = new CafeteriaView(cafeService);
        DishView dishView = new DishView(dishService);
        CafeteriaDishView cafeDishView = new CafeteriaDishView(cafeteriaDishService, cafeView, dishView);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu.showMainMenu();
            int a = scanner.nextInt();

            switch (a) {
                case 11:
                    cafeView.demonstrate();
                    break;
                case 12:
                    dishView.demonstrate();
                    break;
                case 13:
                    cafeDishView.demonstrate();
                    break;
                case 21:
                    cafeView.add();
                    break;
                case 22:
                    dishView.add();
                    break;
                case 23:
                    cafeDishView.add();
                    break;
                case 31:
                    cafeService.delete();
                    cafeteriaDishService.deleteCafebyId();
                    break;
                case 32:
                    dishService.delete();
                    cafeteriaDishService.deleteDishbyId();
                    break;
                case 4:
                    System.exit(3);
            }
        }
    }
}

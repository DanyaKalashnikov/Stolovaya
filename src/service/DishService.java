package service;

import model.Dish;
import repository.DishRepo;
import utils.Demonstrate;

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
    public void demonstrate() {
        for (Demonstrate demo : dishRepo.getAllEntity()) demo.demonstrate();
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название блюда:");
        String dishName = scanner.next();
        System.out.println("Введите его цену:");
        scanner.nextLine();
        int dishPrice = scanner.nextInt();

        dishRepo.saveEntity(new Dish(dishName, dishPrice));
        System.out.println("Успешно");
    }
}

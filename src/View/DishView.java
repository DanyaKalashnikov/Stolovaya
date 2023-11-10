package View;

import model.Dish;
import service.DishService;

import java.util.List;
import java.util.Scanner;

public class DishView implements View {
    private DishService dishService;
    private Scanner scanner;

    public DishService getDishService() {
        return dishService;
    }

    public DishView(DishService dishService) {
        this.dishService = dishService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void demonstrate() {
        //dishService.demonstrate();
        List<Dish> demo = dishService.demonstrate();
        for (Dish dish : demo) {
            System.out.println(dish.getDishId() + " " + dish.getDishName() + " " + dish.getDishPrice() + "р");
            System.out.println("____________________________");
        }
    }

    @Override
    public void add() {
        System.out.println("Введите название блюда:");
        String dishName = scanner.next();
        System.out.println("Введите его цену:");
        scanner.nextLine();
        int dishPrice = scanner.nextInt();
        dishService.add(dishName, Integer.toString(dishPrice));
        System.out.println("Успешно!");
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}

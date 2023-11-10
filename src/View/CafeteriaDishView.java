package View;

import model.CafeteriaDish;
import service.CafeteriaDishService;

import java.util.List;
import java.util.Scanner;

public class CafeteriaDishView implements View {
    private CafeteriaDishService cafeteriaDishService;
    private CafeteriaView cafeteriaView;
    private DishView dishView;
    Scanner scanner;

    public CafeteriaDishService getCafeteriaDishService() {
        return cafeteriaDishService;
    }

    public CafeteriaDishView(CafeteriaDishService cafeteriaDishService, CafeteriaView cafeteriaView, DishView dishView) {
        this.cafeteriaDishService = cafeteriaDishService;
        this.cafeteriaView = cafeteriaView;
        this.dishView = dishView;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void demonstrate() {
        //cafeteriaDishService.demonstrate();
        List<CafeteriaDish> cafeteriaDishes = cafeteriaDishService.demonstrate();
        for (CafeteriaDish demo : cafeteriaDishes){
            System.out.println(demo.getDishId() + " " + demo.getDishName() + " " + demo.getCafId() + " " + demo.getCafName());
            System.out.println("____________________________");
        }
    }

    @Override
    public void add() {
        System.out.println("Выберите существующий кафетерий:");

        cafeteriaView.demonstrate();

        System.out.println("Введите индекс кафетерия:");
        int cafId = scanner.nextInt();

        System.out.println("Выберите существующее блюдо:");

        dishView.demonstrate();

        System.out.println("Введите индекс блюда:");
        int dishId = scanner.nextInt();

        cafeteriaDishService.add(Integer.toString(cafId), Integer.toString(dishId));

        System.out.println("Успешно!");
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}

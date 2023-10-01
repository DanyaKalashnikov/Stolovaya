package service;

import jdk.jshell.Diag;
import model.Cafeteria;
import model.CafeteriaDish;
import model.Dish;
import repository.Repository;
import utils.Demonstrate;
import utils.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public void start(){
        Initialization initialization = new Initialization();
        List<Repository> repo = new ArrayList<>();
        initialization.init(repo);

        List<Demonstrate> list = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        while (true){
            Menu.showMainMenu();
            int a = scanner.nextInt();

            switch (a){
                case 11:
                    for (Repository repository : repo){
                        if(repository.getRepoId().equals("c")){
                            list = repository.getAllEntity();
                            for (Demonstrate demo : list){
                                demo.demonstrate();
                            }
                        }
                    }
                    break;
                case 12:
                    for (Repository repository : repo){
                        if(repository.getRepoId().equals("d")){
                            list = repository.getAllEntity();
                            for (Demonstrate demo : list){
                                demo.demonstrate();
                            }
                        }
                    }
                    break;
                case 13:
                    for (Repository repository : repo){
                        if(repository.getRepoId().equals("cd")){
                            list = repository.getAllEntity();
                            for (Demonstrate demo : list){
                                demo.demonstrate();
                            }
                        }
                    }
                    break;
                case 21:
                    System.out.println("Введите название кафетерия:");
                    String cafName = scanner.next();
                    System.out.println("Введите её адрес:");
                    String addres1 = scanner.next();
                    int addres2 = scanner.nextInt();
                    String addres = addres1 + ", " + addres2;

                    for (Repository repository : repo){
                        if(repository.getRepoId().equals("c")){
                            repository.saveEntity(new Cafeteria(cafName, addres));
                            System.out.println("Успешно");
                        }
                    }
                    break;

                case 22:
                    System.out.println("Введите название блюда:");
                    String dishName = scanner.next();
                    System.out.println("Введите его цену:");
                    scanner.nextLine();
                    int dishWeight = scanner.nextInt();

                    for (Repository repository : repo){
                        if(repository.getRepoId().equals("d")){
                            repository.saveEntity(new Dish(dishName, dishWeight));
                            System.out.println("Успешно");
                        }
                    }
                    break;

                case 23:
                    Dish dish = new Dish();
                    Cafeteria cafeteria = new Cafeteria();
                    CafeteriaDish cafeteriaDish = new CafeteriaDish();

                    System.out.println("Выберите существующий кафетерий:");

                    for (Repository repository : repo){
                        if(repository.getRepoId().equals("c")){
                            list = repository.getAllEntity();
                            for (Demonstrate demo : list){
                                demo.demonstrate();
                            }
                            break;
                        }
                    }

                    System.out.println("Введите индекс кафетерия:");
                    int cafId = scanner.nextInt();

                    System.out.println("Выберите существующее блюдо:");

                    for (Repository repository : repo){
                        if(repository.getRepoId().equals("d")){
                            list = repository.getAllEntity();
                            for (Demonstrate demo : list){
                                demo.demonstrate();
                            }
                            break;
                        }
                    }

                    System.out.println("Введите индекс блюда:");
                    int dishId = scanner.nextInt();

                    for (Repository repository : repo){
                        if(repository.getRepoId().equals("c")){
                            cafeteria = (Cafeteria)repository.getEntityById(cafId);
                        }
                        if(repository.getRepoId().equals("d")){
                            dish = (Dish)repository.getEntityById(dishId);
                        }
                        if(repository.getRepoId().equals("cd")){
                            cafeteriaDish.setCafId(cafeteria.getCafId());
                            cafeteriaDish.setCafName(cafeteria.getCafName());
                            cafeteriaDish.setDishId(dish.getDishId());
                            cafeteriaDish.setDishName(dish.getDishName());
                            repository.saveEntity(cafeteriaDish);
                            System.out.println("Успешно!");
                        }
                    }
                    break;

                case 3:
                    System.exit(3);
            }
        }
    }
}

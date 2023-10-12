package service;

import model.Cafeteria;
import repository.CafeteriaRepo;
import utils.Demonstrate;

import java.util.Scanner;

public class CafeteriaService implements Service {
    private CafeteriaRepo cafeRepo;

    public CafeteriaRepo getCafeRepo() {
        return cafeRepo;
    }

    public CafeteriaService(CafeteriaRepo cafeRepo) {
        init(cafeRepo);
        this.cafeRepo = cafeRepo;
    }

    private void init(CafeteriaRepo cafeRepo) {
        Cafeteria cafeteria = new Cafeteria("ВПузо", "Домодедова, 66");
        cafeRepo.saveEntity(cafeteria);
    }

    @Override
    public void demonstrate() {
        for (Demonstrate demo : cafeRepo.getAllEntity()) demo.demonstrate();
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название кафетерия:");
        String cafName = scanner.next();
        System.out.println("Введите её адрес:");
        String addres1 = scanner.next();
        int addres2 = scanner.nextInt();
        String addres = addres1 + ", " + addres2;

        cafeRepo.saveEntity(new Cafeteria(cafName, addres));
        System.out.println("Успешно");
    }
}

package service;

import model.Cafeteria;
import repository.CafeteriaRepo;

import java.util.List;
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
    public List demonstrate() {
        return cafeRepo.getAllEntity();
    }

    @Override
    public void add(String one, String two) {
        cafeRepo.saveEntity(new Cafeteria(one, two));
    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id кафетерия для удаления:");
        int id = scanner.nextInt();
        for (Cafeteria caf : cafeRepo.getAllEntity()){
            if(caf.getCafId() == id) {
                cafeRepo.deleteEntity(caf);
            }
        }
    }
}

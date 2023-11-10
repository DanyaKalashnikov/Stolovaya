package View;

import model.Cafeteria;
import service.CafeteriaService;

import java.util.List;
import java.util.Scanner;

public class CafeteriaView implements View {
    private CafeteriaService cafeService;
    private Scanner scanner;

    public CafeteriaService getCafeService() {
        return cafeService;
    }

    public CafeteriaView(CafeteriaService cafeService) {
        this.cafeService = cafeService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void demonstrate() {
        //cafeService.demonstrate();
        List<Cafeteria> cafeterias = cafeService.demonstrate();
        for (Cafeteria demo : cafeterias){
            System.out.println(demo.getCafId() + " " + demo.getCafName() + " ул." + demo.getCafAddres());
            System.out.println("____________________________");
        }
    }

    @Override
    public void add() {
        System.out.println("Введите название кафетерия:");
        String cafName = scanner.next();
        System.out.println("Введите её адрес:");
        String addres1 = scanner.next();
        int addres2 = scanner.nextInt();
        String addres = addres1 + ", " + addres2;
        cafeService.add(cafName, addres);
        System.out.println("Успешно!");
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}

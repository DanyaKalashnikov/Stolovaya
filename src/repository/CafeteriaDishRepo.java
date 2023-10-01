package repository;

import model.Cafeteria;
import model.CafeteriaDish;
import model.Dish;

import java.util.ArrayList;
import java.util.List;

public class CafeteriaDishRepo implements Repository<CafeteriaDish>{
    private final String id = "cd";
    private List<CafeteriaDish> cafeteriaDishes = new ArrayList<>();

    @Override
    public List<CafeteriaDish> getAllEntity() {
        return cafeteriaDishes;
    }

    @Override
    public String getRepoId() {
        return id;
    }

    @Override
    public CafeteriaDish getEntityById(int id) {
        for (CafeteriaDish cafeteriaDish : cafeteriaDishes){
            if (cafeteriaDish.getId() == id) return cafeteriaDish;
        }
        return null;
    }
    public CafeteriaDish getEntityByCafetDishId(Cafeteria caf, Dish dish){
        for (CafeteriaDish cafeteriaDish : cafeteriaDishes){
            if(cafeteriaDish.getCafId() == caf.getCafId() &&
                    cafeteriaDish.getDishId() == dish.getDishId()) return cafeteriaDish;
        }
        return null;
    }

    @Override
    public void deleteEntityById(int id) {
        for (CafeteriaDish cafeteriaDish : cafeteriaDishes){
            if (cafeteriaDish.getId() == id) cafeteriaDishes.remove(cafeteriaDish);
        }
    }

    @Override
    public void saveEntity(CafeteriaDish entity) {
        cafeteriaDishes.add(entity);
    }
}
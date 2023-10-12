package repository;

import model.Cafeteria;

import java.util.ArrayList;
import java.util.List;

public class CafeteriaRepo implements Repository<Cafeteria> {
    private List<Cafeteria> cafeterias = new ArrayList<>();


    @Override
    public List<Cafeteria> getAllEntity() {
        return cafeterias;
    }

    @Override
    public Cafeteria getEntityById(int id) {
        for (Cafeteria caf : cafeterias){
            if(caf.getCafId() == id) return caf;
        }
        return null;
    }

    @Override
    public void deleteEntityById(int id) {
        for (Cafeteria caf : cafeterias){
            if(caf.getCafId() == id) cafeterias.remove(caf);
        }
    }

    @Override
    public void saveEntity(Cafeteria entity) {
        cafeterias.add(entity);
    }
}

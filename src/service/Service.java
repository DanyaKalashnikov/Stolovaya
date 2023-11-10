package service;

import java.util.List;

public interface Service<Repository>{
    List demonstrate();
    void add(String one, String two);
    void delete();
}

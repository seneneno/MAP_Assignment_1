package repo;

import model.Vehicle;

public interface Repo {
    int getlen();
    void add(Vehicle v);
    void remove(Vehicle v);
    Vehicle[] getAll();
    Vehicle[] getByColor(String s);
}

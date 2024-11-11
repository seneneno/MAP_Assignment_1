package controller;

import model.Vehicle;
import repo.Repo;

public class Controller{
    Repo repo;
    public Controller(Repo r){
        this.repo=r;
    }
    public void add_item(Vehicle v){
        try{
            repo.add(v);
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public void remove_item(Vehicle v){
        try{
            repo.remove(v);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public Vehicle[] get_all(){
        return repo.getAll();
    }
    public Vehicle[] get_by_color(String s){
        Vehicle[] copy = new Vehicle[repo.getlen()];
        try{
            copy = repo.getByColor(s);
        }catch(Exception e){
            System.out.println(e);
        }
        return copy;
    }
}

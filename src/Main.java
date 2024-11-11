//1. Intr-o parcare exista masini, motociclete
//si biciclete. Sa se afiseze toate vehiculele
//de culoare rosie.

import controller.Controller;
import model.Bicycle;
import model.Car;
import model.Motorcycle;
import model.Vehicle;
import repo.InMemoryRepo;
import repo.Repo;
import view.View;

public class Main {
    public static void main(String[] args) {
        Repo r= new InMemoryRepo();
        Motorcycle m1 = new Motorcycle("red","Honda");
        Motorcycle m2 = new Motorcycle("blue","Suzuki");
        Motorcycle m3 = new Motorcycle("yellow","Kawasaki");
        Car c1 =new Car("red","Toyota");
        Car c2=new Car("red","Volkswagen");
        Car c3 = new Car("pink","Subaru");
        Bicycle b1=new Bicycle("orange","Cannondale");
        Bicycle b2=new Bicycle("white","Orbea");
        Bicycle b3 = new Bicycle("purple","Trek");
        Bicycle b4 =new Bicycle("magenta","Giant");
        r.add(m1);
        r.add(m2);
        r.add(m3);
        r.add(c1);
        r.add(c2);
        r.add(c3);
        r.add(b1);
        r.add(b2);
        r.add(b3);
        r.add(b4);
        Controller c = new Controller(r);
        View v = new View(c);
        v.actual_view();

    }
}
package view;

import controller.Controller;
import model.Bicycle;
import model.Car;
import model.Motorcycle;
import model.Vehicle;

import java.util.Scanner;

public class View {
    Controller controller;
    Scanner input = new Scanner(System.in);
    public View(Controller c){
        this.controller = c;
    }

    public void menu(){
        System.out.println("\nHello!\n" +
                "1.Show all vehicles\n" +
                "2.Add vehicle\n" +
                "3.Remove vehicle\n" +
                "4.Filter vehicles by color\n" +
                "0.Exit\n"+
                "Enter your command:");
    }

    public void print_all(){
        for(Vehicle c:controller.get_all()){
            System.out.println(c.toString());
        }
    }

    public void add_view(){
        System.out.println("Vehicle type:");
        String veh = input.nextLine();
        System.out.println("Name of vehicle:");
        String name = input.nextLine();
        System.out.println("Color of vehicle:");
        String color = input.nextLine();
        switch(veh){
            case "Motorcycle":
                Vehicle v= new Motorcycle(color,name);
                controller.add_item(v);
                break;
            case "Car":
                Vehicle v2= new Car(color,name);
                controller.add_item(v2);
                break;
            case "Bicycle":
                Vehicle v1= new Bicycle(color,name);
                controller.add_item(v1);
                break;
        }

    }

    public void filter(){
//        Vehicle[] all = controller.get_all();
//        for(Vehicle v: all){
//            if(v.isRed()){
//                System.out.println(v);
//            }
//        }
        Vehicle[] array = new Vehicle[100];
        array = controller.get_by_color("blue");
        for(Vehicle v: array){
                System.out.println(v);
        }
    }

    public void commands(){
        String comm = input.nextLine();
        switch(comm){
            case "1":
                print_all();
                break;
            case "2":
                add_view();
                break;
            case "3":
                System.out.println("Removing later.......");
                break;
            case "4":
                filter();
                break;
            case "0":
                return;
            default:
                break;
        }
    }

    public void actual_view(){
            menu();
            commands();

    }
}

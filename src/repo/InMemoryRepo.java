package repo;

import model.Vehicle;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class InMemoryRepo implements Repo{
    private Vehicle[] vehicles;
    int counter;

    public InMemoryRepo(){
        vehicles=new Vehicle[100];
        counter=0;
    }

    @Override
    public int getlen() {
        return vehicles.length;
    }

    @Override
    public void add(Vehicle v) {
        if(counter== vehicles.length){
            throw new ArrayIndexOutOfBoundsException("Cannot add any more vehicles");
        }

//        for(int i=0;i< vehicles.length;i++){
//            if(vehicles[i].equals(v))
//                throw new ArrayStoreException("Duplicate element");
//        }
        vehicles[counter++]=v;
    }

    @Override
    public void remove(Vehicle v) {
        int index=-1;
        for(int i=0;i<vehicles.length;i++){
            if(vehicles[i].equals(v)){
                index=i;
                break;
            }
        }
        if(index!=-1){
            Vehicle[] copy=new Vehicle[vehicles.length-1];
            int counter=0;
            for(int i=0;i<vehicles.length;i++){
                if(i!=index)
                    copy[counter++]=vehicles[i];
            }
            vehicles=copy;
        }
        else
            throw new IndexOutOfBoundsException("Element not in list");
    }

    @Override
    public Vehicle[] getAll() {
        int newCounter=0;
        Vehicle[] copy = new Vehicle[counter];
        for (int i = 0; i < counter; i++) {
            copy[i] = vehicles[i];
        }
        return copy;
    }

    @Override
    public Vehicle[] getByColor(String s) {
        Vehicle[] vcopy = new Vehicle[counter];
        int copyc = 0;
        for (int i = 0; i < counter; i++) {
            Vehicle v = vehicles[i];
            if (Objects.equals(v.getColor(), s)) {
                vcopy[copyc++] = v;
            }
        }
        if(vcopy.length==0){
            throw new NoSuchElementException("No vehicles of this color");
        }
        return Arrays.copyOf(vcopy,copyc);
    }
}

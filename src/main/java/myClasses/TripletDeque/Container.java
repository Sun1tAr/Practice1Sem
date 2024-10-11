package myClasses.TripletDeque;

import java.util.ArrayList;

public class Container<T> {
    private int volume;
    private ArrayList<T> values;
    private Container<T> left = new Container<>();
    private Container<T> right = new Container<>();

    public Container() {
        this.volume = 5;
        this.left = null;
        this.right = null;
        this.values = new ArrayList<T>(this.volume);
    }
    public Container(int volume) {
        this.volume = volume;
        this.left = null;
        this.right = null;
        this.values = new ArrayList<T>(this.volume);
    }


    public Container<T> getLeft() {
        return left;
    }

    public void setLeft(Container<T> left) {
        this.left = left;
    }

    public Container<T> getRight() {
        return right;
    }

    public void setRight(Container<T> right) {
        this.right = right;
    }

    public boolean isFull(){
        for (int i = 0; i < this.volume; i++){
            if (values.get(i) == null){
                return true;
            }
        }
        return false;
    }

}

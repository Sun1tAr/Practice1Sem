package myClasses.TripletDeque;

import java.util.Arrays;

public class Container<T> {
    private int volume;
    private T[] values;
    private int index;
    private Container<T> left;
    private Container<T> right;

    public Container(int index) {
        this.volume = 5;
        this.values = (T[]) new Object[this.volume];
        this.index = index;

    }

    public T[] getValues() {
        return values;
    }
    public int getVolume(){return this.volume;}
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
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public T getBeginElement(){
        for (int i = this.volume - 1; i >= 0; i--){
            if (values[i] == null){
                return values[i+1];
            }
        }
        return null;
    }
    public T getLastElement(){
        for (int i = 0; i < this.volume; i++){
            if (values[i] == null){
                return values[i-1];
            }
        }
        return null;
    }
    public void setElementByIndex(int index, T element) {
        this.values[index] = element;
    }
    public boolean isNotFullLast(){
        for (int i = 0; i < this.volume; i++){
            if (values[i] == null){
                return true;
            }
        }
        return false;
    }
    public boolean isNotFullBegin(){
        for (int i = this.volume - 1; i >= 0; i--){
            if (this.values[i] == null){
                return true;
            }
        }
        return false;
    }
    public void setLastElement(T t){
        for (int i = 0; i < this.volume; i++){
            if (this.values[i] == null){
                this.values[i] = t;
                return;
            }
        }
    }
    public void setBeginElement(T t){
        for (int i = this.volume - 1; i >= 0; i--){
           if (this.values[i] == null){
               this.values[i] = t;
               return;
           }
        }
    }
    public boolean isEmpty(){
        int count = 0;
        for (T e : values){
            if (e == null){
                count++;
            }
        }
        return count == volume-1;
    }
    public void delBeginElem(){
        for (int i = this.volume - 1; i >= 0; i--){
            if (values[i] == null){
                values[i+1] = null;
                return;
            }
        }

    }
    public void delLastElem(){
        for (int i = 0; i < this.volume; i++){
            if (values[i] == null){
                values[i-1] = null;
                return;
            }
        }
    }
    public void delete(){
        this.values = null;
        this.index = Integer.parseInt(null);
        this.left = null;
        this.right = null;

    }
    public void deleteLeft(){
        this.left = null;
    }
    public void deleteRight(){
        this.right = null;
    }
    public boolean contains(Object o){
        for (int i = 0; i < this.volume; i++){
            if (this.values[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    public boolean containsL(Object o){
        for (int i = this.volume - 1; i >= 0; i--){
            if (this.values[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    public int getElementIndexFirst(Object o){
        for (int i = 0; i < this.volume; i++){
            if (this.values[i].equals(o)) return i;
        }
        throw new NullPointerException("Ошибка поиска индекса элемента");
    }
    public void deleteByIndex(int eIndex){
        this.values[eIndex] = null;

    }

    @Override
    public String toString() {
        return "Container{" +
                "volume=" + volume +
                ", values=" + Arrays.toString(values) +
                ", index=" + index +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

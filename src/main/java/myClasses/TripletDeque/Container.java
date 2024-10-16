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
        for (int i = 0; i < this.volume; i++){
            if (this.values[i] != null) return this.values[i];
        }
        return null;
    }
    public T getLastElement(){
        for (int i = this.volume - 1; i >= 0; i--){
            if (this.values[i] != null) return this.values[i];
        }
        return null;
    }

    public boolean isNotFullLast(){
        if (this.isEmpty()) return true;
        if (values[this.volume - 1] == null) return true;
        for (int i = this.volume - 1; i > 0; i--){
            if (this.values[i] == null && this.values[i-1] != null){
                return true;
            }
        }
        return false;
    }
    public boolean isNotFullBegin(){
        if (this.isEmpty()) return true;
        if (values[0] != null) return false;
        for (int i = 0; i < this.volume - 1; i++){
            if (this.values[i] == null && this.values[i+1] != null){
                return true;
            }
        }
        return false;
    }

    public void setLastElement(T t){
        if (this.isEmpty()){
            this.values[0] = t;
            return;
        }
        for (int i = 0; i < this.volume - 1; i++){
            if (this.values[i] != null && this.values[i+1] == null){
                this.values[i+1] = t;
                return;
            }
        }
    }
    public void setBeginElement(T t){
        if (this.isEmpty()){
            this.values[this.volume - 1] = t;
            return;
        }
        for (int i = this.volume - 1; i > 0; i--){
            if (this.values[i] != null && this.values[i-1] == null){
                this.values[i-1] = t;
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
        return count == volume;
    }
    public void delBeginElem(){
        for (int i = 0; i < this.volume; i++){
            if (this.values[i] != null){
                this.values[i] = null;
                return;
            }
        }

    }
    public void delLastElem(){
        for (int i = this.volume - 1; i >= 0; i--){
            if (this.values[i] != null) {
                this.values[i] = null;
                return;
            }
        }
    }
    public void delete(){
        this.values = null;
        this.index = Integer.MIN_VALUE;
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
            if (this.values[i] == null) continue;
            if (this.values[i].equals(o)){
                return true;
            }
        }
        return false;
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

package ru;

public class SteriodArray {

    private int length;
    private final String[] array;

    public SteriodArray(int length){
        this.array = new String[length];
    }

    public boolean add(String s){
        for (int i = 0; i < this.array.length; i++){
            if (this.array[i] == null){
                this.array[i] = s;
                return true;
            }
        }
        return false;
    }
public boolean remove(String s){
        int i = 0;
        for (String elem : this.array){
            if (elem == s){
                return this.remove(i);
            } else {
                return false;
            }
        }
    }
    public boolean remove2(String s){

        for (int i = 0; i < this.array.length - 1; i++) {

            if (this.array[i] == s) {
                this.array[i] = null;
                if (this.array[i + 1] != null) {
                    while (this.array[i + 1] != null) {
                        this.array[i] = this.array[i + 1];
                        i++;
                    }

                }
            }
        }
        return true;
    }

    public boolean remove(int i){
        if (i+1 < this.array.length) {
            return false;
        } else if (i+1 == this.array.length || this.array[i+1] == null) {
            this.array[i] = null;
            return true;
        } else {
            int j = i;
            while(j != this.array.length - 2){
                this.array[j] = this.array[j+1];
                j++;
            }
            return true;
        }
    }

    public String get(int i){
        return this.array[i];
    }

    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < this.array.length; i++){
            s += this.array[i] + " / ";
        }
        return s;
    }

    public int length(){
        return this.length;
    }

    public int maxLength(){
        return Integer.MAX_VALUE;
    }
}

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
            boolean flag = false;
            for (String elem : this.array){
                if (elem == s){
                    flag = this.remove(i);
                    i++;

                }
            }
            return flag;
        }

    public boolean remove(int i){
        if (i+1 > this.array.length) {
            return false;
        } else if (i+1 == this.array.length || this.array[i+1] == null) {
            this.array[i] = null;
            return true;
        } else {
            int j = i;
            while(j != this.array.length - 1){
                this.array[j] = this.array[j+1];
                this.array[j+1] = null;
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
        int stringLength = 0;
        for (String elem : this.array){
            if (elem != null) {
                String[] s = elem.split("");
                for (String ss : s) stringLength++;
            }
        }
        return stringLength;
    }

    public int maxLength(){
        return Integer.MAX_VALUE;
    }
}

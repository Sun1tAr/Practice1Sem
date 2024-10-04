package myClasses;

public interface Validator<Type> {

    public default boolean noEmptyData(Type data){
        return ((data != null) && (data != ""));
    }

    public default boolean knownCharacters(Type data){
        String str = data.toString();
        char[] chars = str.toCharArray();
        int count = 0;
        // цифры от 0 до 9 ~ 48-57 юникода, английские 65-90, 97-122
        for (char ch : chars){
            if(((ch >= 48) && (ch <= 57)) || ((ch >= 69) && (ch <= 90)) || ((ch >= 97) && (ch <= 122))) count++;
        }
        return count == chars.length;
    }

    public default boolean equals(Type data1, Type data2){
        return data1 == data2;
    }
}

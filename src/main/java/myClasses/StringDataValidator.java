package myClasses;

import exceptions.EmptyDataException;
import exceptions.UnknownCharacterException;

public class StringDataValidator implements Validator<String> {
    public String s1, s2;

    private StringDataValidator(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public static boolean validate(String s1, String s2) throws EmptyDataException, UnknownCharacterException {
        StringDataValidator sdv = new StringDataValidator(s1, s2);

        if (!(sdv.noEmptyData(sdv.s1) && sdv.noEmptyData(sdv.s2))) {
            throw new EmptyDataException();
        } else if (!(sdv.knownCharacters(sdv.s1) && sdv.knownCharacters(sdv.s2))) {
            throw new UnknownCharacterException();
        } else {
            return sdv.equals(sdv.s1, sdv.s2);
        }
    }
}



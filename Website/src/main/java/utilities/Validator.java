package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Validator validate = new Validator();

    public static Validator getInstance(){
        return validate;
    }

    public boolean EmailValidation(String regEmail){
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(regEmail);
          return matcher.matches();
    }

}

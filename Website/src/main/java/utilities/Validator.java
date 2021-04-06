package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Validator validate = new Validator();

    public static Validator getInstance(){
        return validate;
    }

    public boolean EmailValidation(String regEmail){
        String emailRegex = "(^[A-Za-z0-9._-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$)| [ \\t\\n]*";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(regEmail);
          return matcher.matches();
    }

}

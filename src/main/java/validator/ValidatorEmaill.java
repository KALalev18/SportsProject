package validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorEmaill implements ConstraintValidator<ValidEmail, String>{
    private static String REGEX_EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$";
    private static Pattern PATTERN = Pattern.compile(REGEX_EMAIL_PATTERN);

    private boolean validateEmail(String email)
    {
        Matcher matcher = PATTERN.matcher(email);
        return matcher.matches();
    }
    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext context)
    {
        return (validateEmail(email));
    }

}

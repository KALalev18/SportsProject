package validator;

import java.lang.annotation.Annotation;

public interface ValidPassword extends Annotation {
    default String message()
    {
        return "Invalid email";
    }
}

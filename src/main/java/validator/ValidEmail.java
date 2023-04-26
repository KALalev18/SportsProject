package validator;


import jakarta.validation.Constraint;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

public interface ValidEmail extends Annotation {
    default String message()
    {
        return "Invalid email";
    }
}

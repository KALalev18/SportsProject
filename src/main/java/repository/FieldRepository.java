package repository;

import model.Field;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Integer> {
    Field getFieldByStartedWorkingTimeAndFinishedWorkingTime(String startedTime, String finishedTime);

    Field findByField(String field);
}

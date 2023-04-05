package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Fields")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fieldId", columnDefinition = "int", nullable = false)
    private int fieldId;
    @Column(name = "fieldLocation", columnDefinition = "nvarchar(100)", nullable = false)
    private int fieldLocation;
    @Column(name = "startedWorkingTime", columnDefinition = "time(7)", nullable = false)
    private String startedWorkingTime;
    @Column(name = "finishedWorkingTime", columnDefinition = "time(7)", nullable = false)
    private int finishedWorkingTime;
    @Column(name = "priceByHour", columnDefinition = "float", nullable = true)
    private float priceByHour;

    public Field(int fieldId, int fieldLocation, String startedWorkingTime, int finishedWorkingTime, float priceByHour) {
        this.fieldId = fieldId;
        this.fieldLocation = fieldLocation;
        this.startedWorkingTime = startedWorkingTime;
        this.finishedWorkingTime = finishedWorkingTime;
        this.priceByHour = priceByHour;
    }

    public Field() {

    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getFieldLocation() {
        return fieldLocation;
    }

    public void setFieldLocation(int fieldLocation) {
        this.fieldLocation = fieldLocation;
    }

    public String getStartedWorkingTime() {
        return startedWorkingTime;
    }

    public void setStartedWorkingTime(String startedWorkingTime) {
        this.startedWorkingTime = startedWorkingTime;
    }

    public int getFinishedWorkingTime() {
        return finishedWorkingTime;
    }

    public void setFinishedWorkingTime(int finishedWorkingTime) {
        this.finishedWorkingTime = finishedWorkingTime;
    }

    public float getPriceByHour() {
        return priceByHour;
    }

    public void setPriceByHour(float priceByHour) {
        this.priceByHour = priceByHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return fieldId == field.fieldId && fieldLocation == field.fieldLocation && finishedWorkingTime == field.finishedWorkingTime && Float.compare(field.priceByHour, priceByHour) == 0 && Objects.equals(startedWorkingTime, field.startedWorkingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldId, fieldLocation, startedWorkingTime, finishedWorkingTime, priceByHour);
    }

    @Override
    public String toString() {
        return "Field{" +
                "fieldId=" + fieldId +
                ", fieldLocation=" + fieldLocation +
                ", startedWorkingTime='" + startedWorkingTime + '\'' +
                ", finishedWorkingTime=" + finishedWorkingTime +
                ", priceByHour=" + priceByHour +
                '}';
    }
}

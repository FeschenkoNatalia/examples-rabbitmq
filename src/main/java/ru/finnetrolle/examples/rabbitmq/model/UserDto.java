package ru.finnetrolle.examples.rabbitmq.model;

import java.math.BigDecimal;

/**
 * Created by finnetrolle on 11.02.2016.
 */
public class UserDto {

    private String name;
    private String surname;
    private BigDecimal cash;
    private Double weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public UserDto() {

    }

    public UserDto(String name, String surname, BigDecimal cash, Double weight) {

        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cash=" + cash +
                ", weight=" + weight +
                '}';
    }
}

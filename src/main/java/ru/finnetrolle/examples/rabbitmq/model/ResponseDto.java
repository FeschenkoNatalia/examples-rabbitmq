package ru.finnetrolle.examples.rabbitmq.model;

/**
 * Created by finnetrolle on 11.02.2016.
 */
public class ResponseDto {

    private UserDto user;
    private String md5;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}

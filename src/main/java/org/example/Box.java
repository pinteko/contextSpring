package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")    // singleton    prototype    session
public class Box {
    private String color;

    public Box() {}

    @PostConstruct
    public void init () {
        this.color = "Blue";
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

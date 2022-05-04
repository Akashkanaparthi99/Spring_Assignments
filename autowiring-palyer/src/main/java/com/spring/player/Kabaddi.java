package com.spring.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class Kabaddi implements ISports{
    @Override
    public List<String> showPlayers() {
        return Arrays.asList("Naveen","Rahul","Harish","Dhanesh","Murli"
        );
    }
}

package com.spring.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class FootBall implements ISports{
    @Override
    public List<String> showPlayers() {
        return Arrays.asList("Aditya",
                "Vicky",
                "Gaurav",
                "Kaushik",
                "Ankush"
        );
    }
}

package com.spring.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EventDetails {
    @Autowired
            @Qualifier("cricket")
    ISports sports;
    public List<String> printEvent(){
        System.out.println("Printing Sports:");
        List<String> players=sports.showPlayers();
        return players;
    }
}


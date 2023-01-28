package com.team.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.pojo.Player;
import com.team.pojo.TeamRCB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReader {

    public void readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TeamRCB rcb = mapper.readValue(new File("src/main/team.json"), TeamRCB.class);
        System.out.println(rcb.getLocation());
        ArrayList<Player> pl = rcb.getPlayer();
        for(int i =0; i< pl.size(); i++)
        {
            Player play = pl.get(i);
            System.out.println(play.getName());
            System.out.println(play.getCountry());
            System.out.println(play.getPrice());
            System.out.println(play.getRole());
        }


    }

    public static void main(String[] args) throws IOException {
        JsonReader js = new JsonReader();
        js.readJson();
    }


}

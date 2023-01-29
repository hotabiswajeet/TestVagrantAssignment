package com.team.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.pojo.Player;
import com.team.pojo.TeamRCB;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReader {

    public ArrayList<Player> readJson() throws IOException //Deserialization of Json file into Object
    {
        ObjectMapper mapper = new ObjectMapper();
        TeamRCB rcb = mapper.readValue(new File("src/main/team.json"), TeamRCB.class);
        ArrayList<Player> pl = rcb.getPlayer();
        return pl;

    }

    public Long actualForeignPlayersInTeamCount(ArrayList<Player> pl)//fetching no of foreign players in actual
    {
       Long count =  pl.stream().filter(s->!s.getCountry().equals("India")).count();
       return count;

    }

    public Long actualWicketKeeperInTeamCount(ArrayList<Player> pl)//fetching actual wicket keeper in team
    {

        Long count = pl.stream().filter(s->s.getRole().equalsIgnoreCase("Wicket-keeper")).count();
        return count;

    }


}

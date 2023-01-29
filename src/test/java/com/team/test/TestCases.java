package com.team.test;

import com.team.logic.JsonReader;
import com.team.pojo.Player;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class TestCases {

    public static Properties prop;
    JsonReader read;

    @BeforeTest
    public void configFileReader() throws IOException
    {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/team/config/configuration.properties");
        prop.load(fis);
        read = new JsonReader();

    }
    @Test
    public void foreignPlayersValidationTest() throws IOException
    {
        ArrayList<Player> pl = read.readJson();
       Long actualForeignPlayerCount = read.actualForeignPlayersInTeamCount(pl);
       Long maxForeignPlayerCount = Long.valueOf(prop.getProperty("AllowedForeignPlayers"));
       if(actualForeignPlayerCount<=maxForeignPlayerCount)
       {
           Assert.assertTrue(true,"Condition Matched");
       }
       else
       {
           Assert.fail("Foreign Player condition not met, Allowed count is "+maxForeignPlayerCount+" where as actual count is "+actualForeignPlayerCount+"");
       }
    }

    @Test
    public void wicketKeeperValidationTest() throws IOException
    {
        ArrayList<Player> pl = read.readJson();
        Long actualWicketKeeperCount = read.actualWicketKeeperInTeamCount(pl);
        Long minimumWicketKeeperCount = Long.valueOf(prop.getProperty("MinimumWicketKeeperCount"));
        if(actualWicketKeeperCount>=minimumWicketKeeperCount)
        {
            Assert.assertTrue(true,"Condition Matched");
        }
        else
        {
            Assert.fail("WicketKeeper condition not met, Minimum count is "+minimumWicketKeeperCount+" where as actual count is "+actualWicketKeeperCount+"");
        }

    }
}

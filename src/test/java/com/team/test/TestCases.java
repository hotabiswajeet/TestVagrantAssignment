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
    public void configFileReader() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/team/config/configuration.properties");
        prop.load(fis);

    }
    @Test
    public void foreignPlayersValidationTest() throws IOException {
       read = new JsonReader();
       ArrayList<Player> pl = read.readJson();
       Long actualCount = read.actualForeignPlayersNumbers(pl);
       System.out.println(actualCount);
       Long expectedCount = Long.valueOf(prop.getProperty("AllowedForeignPlayers"));
       if(actualCount<=expectedCount)
       {
           Assert.assertTrue(true,"Condition Matched");
       }
       else {Assert.fail("Foreign Player condition not met, Expected count is "+prop.getProperty("AllowedForeignPlayers")+"");}
    }
}

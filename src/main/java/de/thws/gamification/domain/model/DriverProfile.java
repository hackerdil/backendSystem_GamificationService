package de.thws.gamification.domain.model;

import org.yaml.snakeyaml.events.Event.ID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class DriverProfile {
    private final UUID id;
    private String username;
    private int totalPoints;
    private final List<DriverAchievement> earnedAchievements=new ArrayList<>();
public DriverProfile(UUID id,String username,int totalPoints){
    if(id==null){
        throw new IllegalArgumentException("id  0 olamaz");
    }
    if (username==null||username.isBlank()){
        throw new IllegalArgumentException("username must not be blank");
    }
    if(totalPoints<0){
        throw new IllegalArgumentException("totalPoints must not be negative ");

    }
    this.id=UUID.randomUUID();
    this.username=username;
    this.totalPoints=totalPoints;}

    public static  DriverProfile newDriver(String username) {
        return new DriverProfile(UUID.randomUUID(),username,0);
    }

    public void addPoints(int pointsAdd){
    if (pointsAdd<0){
        throw new IllegalArgumentException("pointsToAdd must not be negative");

    }
    this.totalPoints+=pointsAdd;
    }

    public void addAchievement(DriverAchievement achievement){
    if(achievement==null){
        throw new IllegalArgumentException("achievement 0 olmaz");
    }
    this.earnedAchievements.add(achievement);
    }
    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getTotalPoints() {
        return totalPoints;
    }


    public List<DriverAchievement> getEarnedAchievements(){
    return Collections.unmodifiableList(earnedAchievements);
    }


    public void changeUsername(String username){
        if (username==null||username.isBlank()){
            throw new IllegalArgumentException("username must not be blank");
        }
        this.username=username;
    }
    @Override
    public String toString() {
        return "DriverProfile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", totalPoints=" + totalPoints +
                ", earnedAchievements=" + earnedAchievements.size() +
                '}';
    }

}

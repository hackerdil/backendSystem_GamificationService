package de.thws.gamification.domain.service;

import de.thws.gamification.domain.model.DriverAchievement;
import de.thws.gamification.domain.model.DriverProfile;

import java.util.Collections;
import java.util.List;

public class GamificationResult {
    private final DriverProfile updatedDriver;
    private final int pointsAdded;
    private final List<DriverAchievement> newAchievements;

    public GamificationResult(DriverProfile updatedDriver,
                              int pointsAdded,
                              List<DriverAchievement> newAchievements) {

        this.updatedDriver = updatedDriver;
        this.pointsAdded = pointsAdded;
        this.newAchievements = List.copyOf(newAchievements);
    }
    public DriverProfile getUpdatedDriver() {
        return updatedDriver;
    }

    public int getPointsAdded() {
        return pointsAdded;
    }

    public List<DriverAchievement> getNewAchievements() {
        return Collections.unmodifiableList(newAchievements);
    }
}

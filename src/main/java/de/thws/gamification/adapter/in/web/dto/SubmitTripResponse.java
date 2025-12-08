package de.thws.gamification.adapter.in.web.dto;

import java.util.List;

public class SubmitTripResponse {


    public int pointsAdded;
    public int newTotalPoints;
    public List<AchievementDTO> newAchievements;

    public SubmitTripResponse() {
    }

    public SubmitTripResponse(int pointsAdded, int newTotalPoints, List<AchievementDTO> newAchievements) {
        this.pointsAdded = pointsAdded;
        this.newTotalPoints = newTotalPoints;
        this.newAchievements = newAchievements;
    }
}

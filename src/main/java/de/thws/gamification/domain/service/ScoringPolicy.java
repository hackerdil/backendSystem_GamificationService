package de.thws.gamification.domain.service;

import de.thws.gamification.domain.model.DriverProfile;
import de.thws.gamification.domain.model.TripReport;

public interface ScoringPolicy {
    //bir tripten kaç puan kazandığımızı belirler

    int calculatePoints(TripReport report, DriverProfile driverProfile);

}

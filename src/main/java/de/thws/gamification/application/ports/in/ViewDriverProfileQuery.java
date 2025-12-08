package de.thws.gamification.application.ports.in;

import de.thws.gamification.domain.model.DriverProfile;

import java.util.UUID;

public interface ViewDriverProfileQuery {

    DriverProfile getProfile(UUID driverId);
}

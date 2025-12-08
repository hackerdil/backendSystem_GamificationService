package de.thws.gamification.application.ports.out;


import de.thws.gamification.domain.model.TripReport;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TripReportRepository {
    void save(TripReport report);
    Optional<TripReport> findById(UUID tripId);
    List<TripReport> findByDriverId(UUID driverId);
}

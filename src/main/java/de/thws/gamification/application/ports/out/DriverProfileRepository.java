package de.thws.gamification.application.ports.out;
import de.thws.gamification.domain.model.DriverProfile;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface DriverProfileRepository {
    Optional <DriverProfile> findById(UUID id);

    List<DriverProfile> findAllOrderByTotalPointsDesc();

    DriverProfile save(DriverProfile driverProfile);
}
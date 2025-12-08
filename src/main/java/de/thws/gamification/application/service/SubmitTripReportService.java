package de.thws.gamification.application.service;

import de.thws.gamification.application.ports.in.SubmitTripReportUseCase;
import de.thws.gamification.application.ports.out.DriverAchievementRepository;
import de.thws.gamification.application.ports.out.DriverProfileRepository;
import de.thws.gamification.application.ports.out.TripReportRepository;
import de.thws.gamification.domain.model.DriverProfile;
import de.thws.gamification.domain.model.TripReport;
import de.thws.gamification.domain.service.GamificationEngine;
import de.thws.gamification.domain.service.GamificationResult;

import java.util.NoSuchElementException;
import java.util.UUID;

public class SubmitTripReportService implements SubmitTripReportUseCase {
    private final DriverProfileRepository driverProfileRepository;
    private final TripReportRepository tripReportRepository;
    private final DriverAchievementRepository driverAchievementRepository;
    private  final GamificationEngine gamificationEngine;

    public SubmitTripReportService(DriverProfileRepository driverProfileRepository,
                                   TripReportRepository tripReportRepository,
                                   DriverAchievementRepository driverAchievementRepository,
                                   GamificationEngine gamificationEngine) {
        this.driverProfileRepository = driverProfileRepository;
        this.tripReportRepository = tripReportRepository;
        this.driverAchievementRepository = driverAchievementRepository;
        this.gamificationEngine = gamificationEngine;
    }
public GamificationResult submitTrip(UUID driverId, TripReport report){
        if(driverId==null){throw new IllegalArgumentException("driverId muss nicht null sein");}
        if(report==null){throw new IllegalArgumentException("report must not be null");}
        if (!driverId.equals(report.getDriverId())) {
            throw new IllegalArgumentException("driverId and report.driverId must match");
        }
            //1 sürücüyü repositoryden ejle
    DriverProfile driver = driverProfileRepository.findById(driverId)
            .orElseThrow(() -> new RuntimeException("Driver not found"));


    //2 tripi kaydet
            tripReportRepository.save(report);
            // domain beynini çağır
            GamificationResult result =gamificationEngine.applyTrip(driver,report);
            //4 güncellenmiş driveri yeni achievementa kaydet
            driverProfileRepository.save(result.getUpdatedDriver());
            if (!result.getNewAchievements().isEmpty()){
                driverAchievementRepository.saveAll(result.getNewAchievements());
            }
            return result;
        }
}

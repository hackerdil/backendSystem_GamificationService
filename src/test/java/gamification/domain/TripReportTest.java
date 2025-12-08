package gamification.domain;

import de.thws.gamification.domain.model.TripReport;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TripReportTest {
    @Test
    void newReport_shouldCreateValidTripWithRandomId() {
        UUID driverId = UUID.randomUUID();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(30);


        TripReport report = TripReport.newReport(
                driverId,
                50,
                1,
                2,
                false,
                start,
                end
        );


        assertNotNull(report.getId(), "id null olmamalı");
        assertEquals(driverId, report.getDriverId());
        assertEquals(50, report.getDistanceKm());
        assertFalse(report.isVoided(), "yeni oluşturulan trip voided olmamalı");
    }

    @Test
    void getDuration_shouldReturnCorrectDurationInMinutes() {
        UUID driverId = UUID.randomUUID();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(45);

        TripReport report = TripReport.newReport(
                driverId,
                30,
                0,
                0,
                false,
                start,
                end
        );


        Duration duration = report.getDuration();


        assertEquals(45, duration.toMinutes(), "süre 45 dakika olmalı");
    }

    @Test
    void isSafeTrip_shouldBeTrueWhenNoBrakesAndNoHardAcceleration() {
        TripReport safeTrip = TripReport.newReport(
                UUID.randomUUID(),
                20,
                0,
                0,
                false,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10)
        );

        assertTrue(safeTrip.isSafeTrip(), "fren ve ani hızlanma yoksa safe olmalı");

        TripReport unsafeTrip = TripReport.newReport(
                UUID.randomUUID(),
                20,
                1,
                0,
                false,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10)
        );

        assertFalse(unsafeTrip.isSafeTrip(), "en az bir fren varsa safe olmamalı");
    }

    @Test
    void markVoided_shouldSetVoidedFlagTrue() {
        TripReport report = TripReport.newReport(
                UUID.randomUUID(),
                10,
                0,
                0,
                false,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(5)
        );

        assertFalse(report.isVoided(), "başta voided false olmalı");


        report.markVoided();


        assertTrue(report.isVoided(), "markVoided sonrası true olmalı");
    }
}

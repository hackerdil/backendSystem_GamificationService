package de.thws.gamification.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class DriverAchievement {
    private final UUID id;
    private final UUID driverId;
    private final Achievement achievement;
    private final LocalDateTime earnedAt;

    public DriverAchievement(UUID id, UUID driverId,
                             Achievement achievement, LocalDateTime earnedAt) {

        if (id == null) throw new IllegalArgumentException("id must not be null");
        if (driverId == null) throw new IllegalArgumentException("driverId must not be null");
        if (achievement == null) throw new IllegalArgumentException("achievement must not be null");
        if (earnedAt == null) throw new IllegalArgumentException("earnedAt must not be null");

        this.id = id;
        this.driverId = driverId;
        this.achievement = achievement;
        this.earnedAt = earnedAt;
    }
    public static DriverAchievement of(UUID driverId, Achievement achievement, LocalDateTime earnedAt) {
        return new DriverAchievement(UUID.randomUUID(), driverId, achievement, earnedAt);
    }
    public UUID getId() {
        return id;
    }

    public UUID getDriverId() {
        return driverId;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public LocalDateTime getEarnedAt() {
        return earnedAt;
    }
    @Override
    public String toString() {
        return "DriverAchievement{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", achievement=" + achievement.getCode() +
                ", earnedAt=" + earnedAt +
                '}';
    }
}

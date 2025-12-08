package de.thws.gamification.adapter.in.web.dto;

import java.time.LocalDateTime;

public class SubmitTripRequest {
    public double distanceKm;
    public int brakeCount;
    public int hardAccelerationCount;
    public boolean nightTrip;
    public LocalDateTime startTime;
    public LocalDateTime endTime;

    public SubmitTripRequest() {
    }
}

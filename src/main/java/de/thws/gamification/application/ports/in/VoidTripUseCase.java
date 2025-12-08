package de.thws.gamification.application.ports.in;

import java.util.UUID;

public interface VoidTripUseCase {
//Hatalı veya iptal edilen bir trip'i geçersiz kılmak için kullanılan use-case.
void voidTrip(UUID tripId);
}

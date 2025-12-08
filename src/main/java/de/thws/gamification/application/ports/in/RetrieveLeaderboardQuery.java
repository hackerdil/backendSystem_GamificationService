package de.thws.gamification.application.ports.in;

import de.thws.gamification.domain.model.LeaderboardEntry;
import de.thws.gamification.domain.model.Period;

import java.util.List;

public interface RetrieveLeaderboardQuery {
//Belirli bir zaman dilimi için leaderboard'ı döndüren use-case.
    //verilen  period için sıralanmış Ladeboard listesi döndürücek

  List<LeaderboardEntry> getLeaderboard(Period period);

}

package de.thws.gamification.adapter.in.web.dto;

public class AchievementDTO {
    public String code;
    public String name;
    public String description;

public AchievementDTO() {
}


    public AchievementDTO(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }



}

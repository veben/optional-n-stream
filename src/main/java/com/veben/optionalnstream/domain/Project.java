package com.veben.optionalnstream.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Project {
    private String name;
    private Team devTeam;

    public Optional<Team> getTeamOrEmpty() {
        return Optional.ofNullable(devTeam);
    }
}

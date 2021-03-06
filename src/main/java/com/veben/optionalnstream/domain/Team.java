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
public class Team {
    private String name;
    private Developer teamLead;

    public Optional<Developer> getTeamLeadOrEmpty() {
        return Optional.ofNullable(teamLead);
    }
}

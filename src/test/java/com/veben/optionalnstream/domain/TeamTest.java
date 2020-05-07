package com.veben.optionalnstream.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class TeamTest {

    @Test
    void should_get_empty_team_lead() {
        // given
        final var givenTeam = Team.builder().build();

        // when
        final Optional<Developer> maybeTeamLead = givenTeam.getTeamLeadOrEmpty();

        // then
        assertThat(maybeTeamLead).isEmpty();
    }

    @Test
    void should_get_team_lead() {
        // given
        final var givenTeam = Team.builder()
                .teamLead(Developer.builder().build()).build();

        // when
        final Optional<Developer> maybeTeamLead = givenTeam.getTeamLeadOrEmpty();

        // then
        assertThat(maybeTeamLead).isNotEmpty();
    }
}
package com.veben.optionalnstream.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectTest {

    @Test
    void should_get_empty_team() {
        // given
        final var givenProject = Project.builder().build();

        // when
        final Optional<Team> maybeProject = givenProject.getTeamOrEmpty();

        // then
        assertThat(maybeProject).isEmpty();
    }

    @Test
    void should_get_team() {
        // given
        final var givenProject = Project.builder()
                .devTeam(Team.builder().build()).build();

        // when
        final Optional<Team> maybeTeam = givenProject.getTeamOrEmpty();

        // then
        assertThat(maybeTeam).isNotEmpty();
    }
}
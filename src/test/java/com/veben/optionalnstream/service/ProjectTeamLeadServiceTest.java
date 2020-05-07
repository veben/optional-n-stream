package com.veben.optionalnstream.service;

import com.veben.optionalnstream.domain.Developer;
import com.veben.optionalnstream.domain.Project;
import com.veben.optionalnstream.domain.Team;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProjectTeamLeadServiceTest extends AbstractServiceTest {

    @InjectMocks
    private ProjectTeamLeadService projectTeamLeadService;

    @Nested
    class should_throw_exception_when_no_project {
        @Test
        void should_throw_exception_with_old_way() {
            // when then
            assertThrows(NoSuchElementException.class, () -> projectTeamLeadService.getTeamLeadOldWay(null));
        }

        @Test
        void should_throw_exception_with_dirty_way() {
            // when then
            assertThrows(NoSuchElementException.class, () -> projectTeamLeadService.getTeamLeadDirtyWay(null));
        }

        @Test
        void should_throw_exception() {
            // when then
            assertThrows(NoSuchElementException.class, () -> projectTeamLeadService.getTeamLead(null));
        }
    }

    @Nested
    class should_throw_exception_when_no_team {
        private final Project PROJECT = Project.builder().build();

        @Test
        void should_throw_exception_with_old_way() {
            // when then
            assertThrows(NoSuchElementException.class, () -> projectTeamLeadService.getTeamLeadOldWay(PROJECT));
        }

        @Test
        void should_throw_exception_with_dirty_way() {
            // when then
            assertThrows(NoSuchElementException.class, () -> projectTeamLeadService.getTeamLeadDirtyWay(PROJECT));
        }

        @Test
        void should_throw_exception() {
            // when then
            assertThrows(NoSuchElementException.class, () -> projectTeamLeadService.getTeamLead(PROJECT));
        }
    }

    @Nested
    class should_throw_exception_when_no_team_lead {
        private final Project PROJECT = Project.builder()
                .devTeam(Team.builder().build())
                .build();

        @Test
        void should_throw_exception_with_old_way() {
            // when then
            assertThrows(NoSuchElementException.class, () -> projectTeamLeadService.getTeamLeadOldWay(PROJECT));
        }

        @Test
        void should_throw_exception_with_dirty_way() {
            // when then
            assertThrows(NoSuchElementException.class, () -> projectTeamLeadService.getTeamLeadDirtyWay(PROJECT));
        }

        @Test
        void should_throw_exception() {
            // when then
            assertThrows(NoSuchElementException.class, () -> projectTeamLeadService.getTeamLead(PROJECT));
        }
    }

    @Nested
    class should_get_team_lead {
        private final Project PROJECT = Project.builder()
                .devTeam(Team.builder()
                        .teamLead(Developer.builder().build()).build()).build();

        @Test
        void should_throw_exception_with_old_way() {
            // when
            final Developer result = projectTeamLeadService.getTeamLeadOldWay(PROJECT);

            // then
            assertThat(result).isNotNull();
        }

        @Test
        void should_throw_exception_with_dirty_way() {
            // when
            final Developer result = projectTeamLeadService.getTeamLeadDirtyWay(PROJECT);

            // then
            assertThat(result).isNotNull();
        }

        @Test
        void should_throw_exception() {
            // when
            final Developer result = projectTeamLeadService.getTeamLead(PROJECT);

            // then
            assertThat(result).isNotNull();
        }
    }
}
package com.veben.optionalnstream.service;

import com.veben.optionalnstream.domain.Developer;
import com.veben.optionalnstream.domain.Project;
import com.veben.optionalnstream.domain.Team;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProjectTeamLeadService {

    // Before Java 8
    public Developer getTeamLeadOldWay(Project project) {
        if(project != null) {
            final Team team = project.getDevTeam();
            if(team != null) {
                final Developer teamLead = team.getTeamLead();
                if(teamLead != null) {
                    return teamLead;
                }
            }
        }
        throw new NoSuchElementException();
    }

    // Java 8+: Dirty way to use Optional
    public Developer getTeamLeadDirtyWay(Project project) {
        final var maybeProject = Optional.ofNullable(project);

        if(maybeProject.isPresent()) {
            final Optional<Team> maybeTeam = maybeProject.get().getTeamOrEmpty();
            if(maybeTeam.isPresent()) {
                final Optional<Developer> maybeTeamLead = maybeTeam.get().getTeamLeadOrEmpty();
                if (maybeTeamLead.isPresent()) {
                    return maybeTeamLead.get();
                }
            }
        }
        throw new NoSuchElementException();
    }

    // Java 8+: Good way to use Optional
    public Developer getTeamLead(Project project) {
        return Optional.ofNullable(project)
                .flatMap(Project::getTeamOrEmpty)
                .flatMap(Team::getTeamLeadOrEmpty)
                .orElseThrow(NoSuchElementException::new);
    }
}

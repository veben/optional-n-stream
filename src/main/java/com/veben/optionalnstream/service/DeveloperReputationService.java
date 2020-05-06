package com.veben.optionalnstream.service;

import com.veben.optionalnstream.domain.Developer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperReputationService {

    public static final int HIGH_REP_SCORE = 100000;
    public static final String NO_PLAYER_NICKNAME = "no_one";

    // Before Java 5
    public String getFirstHighReputationDeveloperNameOlderWay(List<Developer> developers) {
        for(int i = 0 ; i <developers.size() ; i++) {
            final Developer developer = developers.get(i);
            if (developer.getReputation() > HIGH_REP_SCORE) {
                return developer.getNickname();
            }
        }

        return NO_PLAYER_NICKNAME;
    }
    // Before Java 8
    public String getFirstHighReputationDeveloperNameOldWay(List<Developer> developers) {
        for (final Developer developer : developers) {
            if (developer.getReputation() > HIGH_REP_SCORE) {
                return developer.getNickname();
            }
        }

        return NO_PLAYER_NICKNAME;
    }
    // Java 8+: Good way to use Optional
    public String getFirstHighReputationDeveloperName(List<Developer> developers) {
        return developers.stream()
                .filter(developer -> developer.getReputation() > HIGH_REP_SCORE)
                .findFirst()
                .map(Developer::getNickname)
                .orElse(NO_PLAYER_NICKNAME);
    }
    // Java 8+: Bad way to use Optional
    public String getFirstHighReputationDeveloperNameBadWay(List<Developer> developers) {
        final Optional<Developer> firstHighReputationDeveloper = developers.stream()
                .filter(user -> user.getReputation() > HIGH_REP_SCORE)
                .findFirst();

        if(firstHighReputationDeveloper.isPresent()) {
            return firstHighReputationDeveloper.get().getNickname();
        }
        else {
            return NO_PLAYER_NICKNAME;
        }
    }
}

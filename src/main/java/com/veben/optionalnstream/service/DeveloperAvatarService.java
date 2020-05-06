package com.veben.optionalnstream.service;

import com.veben.optionalnstream.domain.Avatar;
import com.veben.optionalnstream.domain.DefaultAvatar;
import com.veben.optionalnstream.domain.Developer;

import java.util.Optional;

public class DeveloperAvatarService {

    // Before Java 8
    public Avatar getAvatarOldWay(Developer developer) {
        return developer != null ? developer.getAvatar() : new DefaultAvatar();
    }
    // Java 8+: Good way to use Optional
    public Avatar getAvatar(Developer developer) {
        return Optional.ofNullable(developer)
                .map(Developer::getAvatar)
                .orElse(new DefaultAvatar());
    }
    // Java 8+: Bad way to use Optional
    public Avatar getAvatarBadWay(Developer developer) {
        Optional<Developer> maybeDeveloper = Optional.ofNullable(developer);

        return maybeDeveloper.isPresent() ? maybeDeveloper.get().getAvatar() : new DefaultAvatar();
    }
}

package com.veben.optionalnstream.domain;

import lombok.Getter;

@Getter
public class DefaultAvatar extends Avatar {

    public DefaultAvatar() {
        this.gravatarUrl = "defaultUrl";
        this.wording = "defaultWording";
    }
}

package com.veben.optionalnstream.domain;

import lombok.Getter;

@Getter
public class DefaultAvatar extends Avatar {

    public static final String DEFAULT_URL = "defaultUrl";
    public static final String DEFAULT_WORDING = "defaultWording";

    public DefaultAvatar() {
        this.gravatarUrl = DEFAULT_URL;
        this.wording = DEFAULT_WORDING;
    }
}

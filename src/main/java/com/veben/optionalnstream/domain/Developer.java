package com.veben.optionalnstream.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Developer {
    private String nickname;
    private String location;
    private String speciality;
    private Avatar avatar;
    private int reputation;
    private String websiteUrl;
    private String stackOverflowUrl;
    private String githubUrl;
}


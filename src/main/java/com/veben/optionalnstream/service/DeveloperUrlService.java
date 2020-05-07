package com.veben.optionalnstream.service;

import com.veben.optionalnstream.domain.Developer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeveloperUrlService {

    public static final String DEFAULT_URL = "";

    // Before Java 8
    String getDeveloperUrlOldWay(Developer developer) {
        String url = DEFAULT_URL;
        final String websiteUrl = developer.getWebsiteUrl();
        if (websiteUrl != null) {
            url = websiteUrl;
        } else {
            final String stackOverflowUrl = developer.getStackOverflowUrl();
            if (stackOverflowUrl != null) {
                url = stackOverflowUrl;
            } else {
                final String githubUrl = developer.getGithubUrl();
                if (githubUrl != null) {
                    url = githubUrl;
                }
            }
        }

        return url;
    }

    // Before Java 8 : dirty triple ternary operator
    String getDeveloperUrlOldAnotherWay(Developer developer) {
        return developer.getWebsiteUrl() != null
                ? developer.getWebsiteUrl()
                : (developer.getStackOverflowUrl() != null
                    ? developer.getStackOverflowUrl()
                    : (developer.getGithubUrl() != null
                        ? developer.getGithubUrl()
                        : DEFAULT_URL));
    }

    // Java 8+
    String getDeveloperUrl(Developer developer) {
        return Optional.ofNullable(developer.getWebsiteUrl())
                .orElse(Optional.ofNullable(developer.getStackOverflowUrl())
                        .orElse(Optional.ofNullable(developer.getGithubUrl())
                                .orElse(DEFAULT_URL)));
    }

    // Java 9+
    String getDeveloperUrlYoungerWay(Developer developer) {
        return Optional.ofNullable(developer.getWebsiteUrl())
                .or(() -> Optional.ofNullable(developer.getStackOverflowUrl()))
                .or(() -> Optional.ofNullable(developer.getGithubUrl()))
                .orElse(DEFAULT_URL);
    }
}

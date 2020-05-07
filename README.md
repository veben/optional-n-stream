# Optional & Stream

>*Last updated: 2020/05/07*

## ⚙ Required technologies
- JDK: openjdk-14
    - Download: [Binary](https://jdk.java.net/14/)
    - Create environment variable: **JAVA_HOME**=`‪C:\Env\tools\jdk\openjdk-14`
    - Add `%JAVA_HOME%\bin` to **Path** env var
    > Know your version:
    ```sh
     java --version
    ```

## 🚀 Launch unit tests
```sh
mvnw clean test
```

## Optional
Old way versus dirty way versus good way to use `Optional`

> Example 1:
```java
@Service
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
    // Java 8+: Dirty way to use Optional
    public Avatar getAvatarDirtyWay(Developer developer) {
        Optional<Developer> maybeDeveloper = Optional.ofNullable(developer);

        return maybeDeveloper.isPresent() ? maybeDeveloper.get().getAvatar() : new DefaultAvatar();
    }
}
```
> Example 2:
```java
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
    // Java 8+: Dirty way to use Optional
    public String getFirstHighReputationDeveloperNameDirtyWay(List<Developer> developers) {
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
```

> Example 3:
```java
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
```

> Example 4:
```java
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
```
}
package com.veben.optionalnstream.service;

import com.veben.optionalnstream.domain.Developer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static com.veben.optionalnstream.service.DeveloperReputationService.NO_PLAYER_NICKNAME;
import static org.assertj.core.api.Assertions.assertThat;

class DeveloperReputationServiceTest extends AbstractServiceTest {

    @InjectMocks
    private DeveloperReputationService developerReputationService;

    @Nested
    class should_get_nickname_with_one_high_dev {

        public static final String HIGH_DEV_NICKNAME = "high_dev_nickname";
        public static final int HIGH_REPUTATION = 999999999;

        @Test
        void should_get_nickname_with_older_way() {
            // given
            final var givenDevList = List.of(Developer.builder()
                    .nickname(HIGH_DEV_NICKNAME)
                    .reputation(HIGH_REPUTATION)
                    .build());

            // when
            final String result = developerReputationService.getFirstHighReputationDeveloperNameOlderWay(givenDevList);

            // then
            assertThat(result).isEqualTo(HIGH_DEV_NICKNAME);
        }

        @Test
        void should_get_nickname_with_old_way() {
            // given
            final var givenDevList = List.of(Developer.builder()
                    .nickname(HIGH_DEV_NICKNAME)
                    .reputation(HIGH_REPUTATION)
                    .build());

            // when
            final String result = developerReputationService.getFirstHighReputationDeveloperNameOldWay(givenDevList);

            // then
            assertThat(result).isEqualTo(HIGH_DEV_NICKNAME);
        }

        @Test
        void should_get_nickname() {
            // given
            final var givenDevList = List.of(Developer.builder()
                    .nickname(HIGH_DEV_NICKNAME)
                    .reputation(HIGH_REPUTATION)
                    .build());

            // when
            final String result = developerReputationService.getFirstHighReputationDeveloperName(givenDevList);

            // then
            assertThat(result).isEqualTo(HIGH_DEV_NICKNAME);
        }

        @Test
        void should_get_nickname_with_bad_way() {
            // given
            final var givenDevList = List.of(Developer.builder()
                    .nickname(HIGH_DEV_NICKNAME)
                    .reputation(HIGH_REPUTATION)
                    .build());

            // when
            final String result = developerReputationService.getFirstHighReputationDeveloperNameBadWay(givenDevList);

            // then
            assertThat(result).isEqualTo(HIGH_DEV_NICKNAME);
        }
    }

    @Nested
    class should_get_nickname_with_one_low_dev {

        public static final String LOW_DEV_NICKNAME = "low_dev_nickname";
        public static final int LOW_REPUTATION = 15;

        @Test
        void should_get_nickname_with_older_way() {
            // given
            final var givenDevList = List.of(Developer.builder()
                    .nickname(LOW_DEV_NICKNAME)
                    .reputation(LOW_REPUTATION)
                    .build());

            // when
            final String result = developerReputationService.getFirstHighReputationDeveloperNameOlderWay(givenDevList);

            // then
            assertThat(result).isEqualTo(NO_PLAYER_NICKNAME);
        }

        @Test
        void should_get_nickname_with_old_way() {
            // given
            final var givenDevList = List.of(Developer.builder()
                    .nickname(LOW_DEV_NICKNAME)
                    .reputation(LOW_REPUTATION)
                    .build());

            // when
            final String result = developerReputationService.getFirstHighReputationDeveloperNameOldWay(givenDevList);

            // then
            assertThat(result).isEqualTo(NO_PLAYER_NICKNAME);
        }

        @Test
        void should_get_nickname() {
            // given
            final var givenDevList = List.of(Developer.builder()
                    .nickname(LOW_DEV_NICKNAME)
                    .reputation(LOW_REPUTATION)
                    .build());

            // when
            final String result = developerReputationService.getFirstHighReputationDeveloperName(givenDevList);

            // then
            assertThat(result).isEqualTo(NO_PLAYER_NICKNAME);
        }

        @Test
        void should_get_nickname_with_bad_way() {
            // given
            final var givenDevList = List.of(Developer.builder()
                    .nickname(LOW_DEV_NICKNAME)
                    .reputation(LOW_REPUTATION)
                    .build());

            // when
            final String result = developerReputationService.getFirstHighReputationDeveloperNameBadWay(givenDevList);

            // then
            assertThat(result).isEqualTo(NO_PLAYER_NICKNAME);
        }
    }
}
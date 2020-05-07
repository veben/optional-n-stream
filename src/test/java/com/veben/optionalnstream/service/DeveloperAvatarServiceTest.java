package com.veben.optionalnstream.service;

import com.veben.optionalnstream.domain.Avatar;
import com.veben.optionalnstream.domain.Developer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static com.veben.optionalnstream.domain.DefaultAvatar.DEFAULT_URL;
import static org.assertj.core.api.Assertions.assertThat;

class DeveloperAvatarServiceTest extends AbstractServiceTest {

    @InjectMocks
    private DeveloperAvatarService developerAvatarService;

    @Nested
    class should_get_developer_avatar {
        private final Avatar AVATAR = new Avatar();

        @Test
        void should_get_avatar_with_old_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .avatar(AVATAR).build();

            // when
            final Avatar result = developerAvatarService.getAvatarOldWay(givenDeveloper);

            // then
            assertThat(result).isEqualTo(AVATAR);
        }

        @Test
        void should_get_avatar() {
            // given
            final var givenDeveloper = Developer.builder()
                    .avatar(AVATAR).build();

            // when
            final Avatar result = developerAvatarService.getAvatar(givenDeveloper);

            // then
            assertThat(result).isEqualTo(AVATAR);
        }

        @Test
        void should_get_avatar_with_dirty_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .avatar(AVATAR).build();

            // when
            final Avatar result = developerAvatarService.getAvatarDirtyWay(givenDeveloper);

            // then
            assertThat(result).isEqualTo(AVATAR);
        }
    }

    @Nested
    class should_get_default_avatar {
        @Test
        void should_get_avatar_with_old_way() {
            // when
            final Avatar result = developerAvatarService.getAvatarOldWay(null);

            // then
            assertThat(result.getGravatarUrl()).isEqualTo(DEFAULT_URL);
        }

        @Test
        void should_get_avatar() {
            // when
            final Avatar result = developerAvatarService.getAvatar(null);

            // then
            assertThat(result.getGravatarUrl()).isEqualTo(DEFAULT_URL);
        }

        @Test
        void should_get_avatar_with_dirty_way() {
            // when
            final Avatar result = developerAvatarService.getAvatarDirtyWay(null);

            // then
            assertThat(result.getGravatarUrl()).isEqualTo(DEFAULT_URL);
        }
    }
}
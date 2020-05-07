package com.veben.optionalnstream.service;

import com.veben.optionalnstream.domain.Developer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static com.veben.optionalnstream.service.DeveloperUrlService.DEFAULT_URL;
import static org.assertj.core.api.Assertions.assertThat;

class DeveloperUrlServiceTest extends AbstractServiceTest {

    @InjectMocks
    private DeveloperUrlService developerUrlService;

    @Nested
    class should_get_website_url {
        private static final String EXPECTED_URL = "mywebsite.com";

        @Test
        void should_get_url_with_old_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .websiteUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlOldWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }

        @Test
        void should_get_url_with_old_another_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .websiteUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlOldAnotherWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }

        @Test
        void should_get_url() {
            // given
            final var givenDeveloper = Developer.builder()
                    .websiteUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrl(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }

        @Test
        void should_get_url_with_younger_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .websiteUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlYoungerWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }
    }

    @Nested
    class should_get_stackoverflow_url {

        private static final String EXPECTED_URL = "stackoverflow.com/profil";

        @Test
        void should_get_url_with_old_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .stackOverflowUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlOldWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }

        @Test
        void should_get_url_with_old_another_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .stackOverflowUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlOldAnotherWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }

        @Test
        void should_get_url() {
            // given
            final var givenDeveloper = Developer.builder()
                    .stackOverflowUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrl(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }

        @Test
        void should_get_url_with_younger_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .stackOverflowUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlYoungerWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }
    }

    @Nested
    class should_get_github_url {

        private static final String EXPECTED_URL = "github.com/profil";

        @Test
        void should_get_url_with_old_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .githubUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlOldWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }

        @Test
        void should_get_url_with_old_another_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .githubUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlOldAnotherWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }

        @Test
        void should_get_url() {
            // given
            final var givenDeveloper = Developer.builder()
                    .githubUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrl(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }

        @Test
        void should_get_url_with_younger_way() {
            // given
            final var givenDeveloper = Developer.builder()
                    .githubUrl(EXPECTED_URL).build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlYoungerWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(EXPECTED_URL);
        }
    }

    @Nested
    class should_get_default_url {

        @Test
        void should_get_url_with_old_way() {
            // given
            final var givenDeveloper = Developer.builder().build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlOldWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(DEFAULT_URL);
        }

        @Test
        void should_get_url_with_old_another_way() {
            // given
            final var givenDeveloper = Developer.builder().build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlOldAnotherWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(DEFAULT_URL);
        }

        @Test
        void should_get_url() {
            // given
            final var givenDeveloper = Developer.builder().build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrl(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(DEFAULT_URL);
        }

        @Test
        void should_get_url_with_younger_way() {
            // given
            final var givenDeveloper = Developer.builder().build();

            // when
            final var resultUrl = developerUrlService.getDeveloperUrlYoungerWay(givenDeveloper);

            // then
            assertThat(resultUrl).isEqualTo(DEFAULT_URL);
        }
    }
}
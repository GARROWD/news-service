package ru.garrowd.newsservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.garrowd.newsservice.utils.enums.NewsTypes;

import java.time.LocalDateTime;

public class NewsPayload {
    @Schema(name = "NewsPayloadCreate")
    @Data
    public static class Create {
        @NotNull(message = "news.error.nullField")
        private String imgUrl;

        @Enumerated(EnumType.STRING)
        @NotNull(message = "news.error.nullField")
        private NewsTypes type;

        @Size(max = 200, message = "news.error.topicLength")
        @NotNull(message = "news.error.nullField")
        private String topic;

        @Size(max = 200, message = "news.error.headerLength")
        @NotNull(message = "news.error.nullField")
        private String header;

        @Size(max = 400, message = "news.error.subtitleLength")
        @NotNull(message = "news.error.nullField")
        private String subtitle;

        private String text;
    }

    @Schema(name = "NewsPayloadUpdate")
    @Data
    public static class Update {
        private String imgUrl;

        private NewsTypes type;

        private String topic;

        private String header;

        private String subtitle;

        private String text;
    }

    @Schema(name = "NewsPayloadRequest")
    @Data
    public static class Request {
        private String id;

        private LocalDateTime date;

        private String imgUrl;

        private NewsTypes type;

        private String topic;

        private String header;

        private String subtitle;

        private String text;
    }
}


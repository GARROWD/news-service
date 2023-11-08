package ru.garrowd.newsservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.garrowd.newsservice.utils.enums.NewsTypes;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
public class News {
    @Id
    @Column(name = "id", unique = true, length = 40)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "img_url", nullable = false, length = 1000)
    private String imgUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private NewsTypes type;

    @Column(name = "topic", nullable = false, length = 200)
    private String topic;

    @Column(name = "header", nullable = false, length = 200)
    private String header;

    @Column(name = "subtitle", nullable = false, length = 400)
    private String subtitle;

    @Column(name = "text", length = 2000)
    private String text;
}

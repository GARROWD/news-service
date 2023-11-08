package ru.garrowd.newsservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.garrowd.newsservice.models.News;

@Repository
public interface NewsRepository
        extends JpaRepository<News, String> {
    Page<News> findAllByHeaderIgnoreCaseStartingWithAndTopicIgnoreCaseStartingWithOrderByDate(String header, String topic, Pageable pageable);
}

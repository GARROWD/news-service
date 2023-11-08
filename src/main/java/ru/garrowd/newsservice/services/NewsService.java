package ru.garrowd.newsservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.garrowd.newsservice.models.News;
import ru.garrowd.newsservice.repositories.NewsRepository;
import ru.garrowd.newsservice.services.validators.ValidationService;
import ru.garrowd.newsservice.utils.enums.ExceptionMessages;
import ru.garrowd.newsservice.utils.exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class NewsService {
    private final ExceptionMessagesService exceptionMessages;
    private final NewsRepository newsRepository;

    private final ValidationService validationService;
    private final ModelMapper modelMapper;

    public News getById(String id)
            throws NotFoundException {
        Optional<News> foundNews = newsRepository.findById(id);

        return foundNews.orElseThrow(() -> new NotFoundException(
                exceptionMessages.getMessage(ExceptionMessages.NEWS_NOT_FOUND, id.toString())));
    }

    public void existsById(String id)
            throws NotFoundException {
        newsRepository.findById(id).orElseThrow(() -> new NotFoundException(
                exceptionMessages.getMessage(ExceptionMessages.NEWS_NOT_FOUND, id.toString())));
    }

    public Page<News> getAllByHeaderAndTopicOrderByDate(String header, String topic, Pageable pageable){
        return newsRepository.findAllByHeaderIgnoreCaseStartingWithAndTopicIgnoreCaseStartingWithOrderByDate(header, topic, pageable);
    }

    @Transactional
    public News create(News news) {
        news.setDate(LocalDateTime.now());

        newsRepository.save(news);

        log.info("News with ID {} is created", news.getId());

        return news;
    }

    // TODO Как правильно делается редактирование?
    @Transactional
    public News update(News unsavedNews, String id) {
        News news = News.builder().build();
        modelMapper.map(getById(id), news);
        modelMapper.map(unsavedNews, news);
        validationService.validate(news);
        newsRepository.save(news);

        log.info("News with ID {} is updated", news.getId());

        return news;
    }

    @Transactional
    public void updateWithoutChecks(News news) {
        existsById(news.getId());
        newsRepository.save(news);

        log.info("News with ID {} is updated", news.getId());
    }

    @Transactional
    public void delete(String id)
            throws NotFoundException {
        existsById(id);
        newsRepository.deleteById(id);

        log.info("News with ID {} is deleted", id);
    }}

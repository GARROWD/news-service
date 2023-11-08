package ru.garrowd.newsservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.garrowd.newsservice.dto.NewsPayload;
import ru.garrowd.newsservice.models.News;
import ru.garrowd.newsservice.services.NewsService;
import ru.garrowd.newsservice.services.validators.ValidationService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {
    private final ValidationService validationService;
    private final NewsService newsService;
    private final ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<News> getAllNews(
            @RequestParam(name = "header", defaultValue = "") String header,
            @RequestParam(name = "topic", defaultValue = "") String topic,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size) {
        return newsService.getAllByHeaderAndTopicOrderByDate(header, topic, PageRequest.of(page, size));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/create")
    @ResponseStatus(HttpStatus.OK)
    public NewsPayload.Request createNews(@RequestBody NewsPayload.Create newsPayload) {
        validationService.validate(newsPayload);
        return modelMapper.map(newsService.create(modelMapper.map(newsPayload, News.class)), NewsPayload.Request.class);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/admin/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    public NewsPayload.Request editNews(
            @PathVariable(name = "id") String id,
            @RequestBody NewsPayload.Update newsPayload) {
        return modelMapper.map(newsService.update(modelMapper.map(newsPayload, News.class), id), NewsPayload.Request.class);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/admin/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNews(
            @PathVariable(name = "id") String id) {
        newsService.delete(id);
    }
}
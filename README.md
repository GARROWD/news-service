# News Service

## Описание

Этот репозиторий был создан в рамках хакатона Лига Приключений Санкт-Петербург 2023, на котором мы заняли второе место.
Набор технологий очень стандартный, **Java 17** и **Spring Boot 3** вместе с **Lombok**, **Model mapper**, **Swagger**.

## Вопросы
Общие вопросы по всей структуре проектов, которые я решил задать в самом простом сервисе, чтобы не нагромождать остальные

**1.** Как обычно реализуют настройку cors, работают с токенами, пишут модели и dto?

**2.** Через что парсят dto в модели, если в модели есть вложенность? Парсят ли список из моделей в dto, или когда отправляют ответ с помощью Page?

**3.** Нормально ли реализован package Utils?

**4.** Оправданы ли ValidationService и ExceptionMessagesService?

**5.** Какие инструменты используют, чтобы редактировать модели и какие контроллеры под это пишутся? Не уверен, что мой способ с Model Mapper элегантный

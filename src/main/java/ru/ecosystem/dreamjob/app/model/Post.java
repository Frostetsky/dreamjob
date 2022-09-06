package ru.ecosystem.dreamjob.app.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class Post {

    private long id;

    private String name;

    private String description;

    private LocalDateTime created;
}

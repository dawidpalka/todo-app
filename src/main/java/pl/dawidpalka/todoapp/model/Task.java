package pl.dawidpalka.todoapp.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.NONE;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @NotBlank(message = "Task's description can't be empty")
    private String description;
    private boolean done;
    private LocalDateTime deadline;
    @Getter(value = NONE)
    @Setter(value = NONE)
    private LocalDateTime createdOn;
    @Getter(value = NONE)
    @Setter(value = NONE)
    private LocalDateTime updatedOn;

    public void updateFrom(Task source) {
        description = source.getDescription();
        done = source.isDone();
        deadline = source.getDeadline();
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }

}

package taskosaurus.task.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;
    private String priority;
    private String userId; // Ссылка на пользователя из Auth Service
}
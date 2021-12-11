package pl.dawidpalka.todoapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawidpalka.todoapp.TaskConfigurationProperties;

@AllArgsConstructor
@RestController
public class InfoController {
    private final DataSourceProperties dataSource;
    private final TaskConfigurationProperties myProp;

    @GetMapping("/info/url")
    String url() {
        return dataSource.getUrl();
    }

    @GetMapping("/info/prop")
    boolean myProp() {
        return myProp.getTemplate().isAllowMultipleTasks();
    }
}

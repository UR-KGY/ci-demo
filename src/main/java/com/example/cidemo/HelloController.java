package com.example.cidemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HelloController {

    // 앱이 시작된 시각 (재배포되면 바뀜)
    private final LocalDateTime startedAt = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

    // 배포할 때 GitHub Actions가 커밋 번호를 넣어 줌 (로컬 실행 시 "local")
    @Value("${app.version}")
    private String version;

    // 이 문구를 바꿔서 push하면 자동 배포가 되는지 확인할 수 있음
    private static final String MESSAGE = "Hello ASG!";

    @GetMapping("/")
    public Map<String, String> hello() {
        Map<String, String> body = new LinkedHashMap<>();
        body.put("message", MESSAGE);
        body.put("version", version);
        body.put("startedAt", startedAt.toString());
        return body;
    }

    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}

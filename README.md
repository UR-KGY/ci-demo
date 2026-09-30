# ci-demo

GitHub Actions로 EC2에 자동 배포되는지 확인하기 위한 최소 Spring Boot 프로젝트입니다.

| 경로 | 응답 |
|---|---|
| `GET /` | `message`, `version`(배포된 커밋), `startedAt`(시작 시각) |
| `GET /health` | `OK` |

- 포트: **8081** (기존 게임 서버 8080과 분리)
- EC2 파일: `~/ci-demo.jar`, 로그 `~/ci-demo.log`, 프로세스 번호 `~/ci-demo.pid`

## 로컬 실행

```bash
./gradlew bootRun
# http://localhost:8081
```

## 필요한 GitHub Secrets

| 이름 | 값 |
|---|---|
| `EC2_HOST` | EC2 퍼블릭 IP |
| `EC2_KEY` | `.pem` 파일 내용 전체 |

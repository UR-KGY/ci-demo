# Java 21 실행 환경 (x86, ARM 모두 지원하는 공식 이미지)
FROM eclipse-temurin:21-jre

# 컨테이너 안의 작업 폴더
WORKDIR /app

# 러너에서 미리 빌드한 jar를 이미지 안으로 복사
COPY build/libs/ci-demo.jar app.jar

# 이 컨테이너가 8081 포트를 쓴다는 표시
EXPOSE 8081

# 컨테이너가 시작될 때 실행할 명령
# docker run 뒤에 붙인 인자(--app.version=...)가 이 명령 뒤에 이어 붙음
ENTRYPOINT ["java", "-Xmx256m", "-jar", "app.jar"]
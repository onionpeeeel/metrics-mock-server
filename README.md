# Metrics Mock Server
Ktor 프레임워크를 사용하여 작성된 간단한 Metrics Mock Server입니다. <br>
주요 목적은 `/metrics` 엔드포인트를 통해 메트릭 데이터를 수신하고 처리하는 것을 <br>
Local Layer에서 확인하기 위함에 있습니다.

## 주요 기능

- **Routing**: `/metrics` 경로에 POST 요청을 처리하는 라우팅 기능.
- **로깅**: 수신된 메트릭 데이터를 로깅하여 확인 가능.
- **Ktor 기반**: 경량 서버로 빠르고 간단하게 동작.

## 디렉토리 구조
```plaintext
metrics-mock-server/
├── build/                  # Gradle 빌드 디렉토리
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   ├── com/
│   │   │   │   ├── lgw/
│   │   │   │   │   ├── Application.kt       # Ktor 애플리케이션 진입점
│   │   │   │   │   ├── route/
│   │   │   │   │   │   └── HealthCheckRoutes.kt  # /healthCheck : mock server 헬스체크
|   |   |   |   |   |   └── MetricRoutes.kt  # /metrics 라우트 정의
│   │   │   │   │   ├── model/
│   │   │   │   │   │   └── Metric.kt        # Metric 데이터 클래스
│   │   │   │   │   ├── config/
│   │   │   │   │   │   └── RoutingConfig.kt # 라우팅 설정
│   │   ├── resources/
│   │   │   ├── application.conf            # Ktor 설정 파일
│   │   │   └── logback.xml                 # 로깅 설정 파일
```

## 엔드포인트

### POST `/healthCheck`

- **설명**: mock server에 대한 healthCheck용 API입니다.
- **요청 본문**: JSON 형식의 메트릭 데이터


### POST `/metrics`

- **설명**: 메트릭 데이터를 수신하고 처리합니다.
- **요청 데이터**: JSON 형식의 메트릭 데이터
```Kotlin
data class Metric(
    val domain: String,
    val itemId: String,
    val userId: String,
    val timestamp: Long = System.currentTimeMillis()
)
```


# Car models 

### 1. producer-service
Сервис отправляет в Kafka модель формата:

CarModel\
String brand;\
String modelName;\
Long travelDistance;\
Long maxSpeed;

### 2. consumer-service
Прослушивает сообщения из очереди kafka и классифицирует их в зависимости от значения brand.

После классификации объектов, сервис сохраняет модели в двухуровневой статической Map.
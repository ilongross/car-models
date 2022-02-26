# Car models 

### 1. producer-service
Сервис отправляет в Kafka модель формата:

CarModel\
String brand;\
String modelName;\
Long travelDistance;\
Long maxSpeed;

### 2. consumer-service
Прослушивает сообщения из очереди kafka, классифицирует их в зависимости от значения brand и сохраняет их в классифицированной модели:

TeslaModel\
String logo;

JeepModel\
Boolean isSUV;

KiaModel\
Boolean isTaxi;\
String driverName;

После классификации объектов, сервис сохраняет CarModel в двухуровневой статической Map, также сохраняет классифицированные модели в статической Map с уникальным id. 
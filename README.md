# LTMS Sampling

## Model
www.msaez.io/#/storming/ltms2

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic newtest
```

## Run the backend micro-services
Run the command "mvn spring-boot:run" inside the each microservices directory:

- basic
- sales
- inventory
- inventory
- report


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API

```
http :8082/companies code="ue" name="무른모" industry="SW" foundedDate="2017-03-15"

http :8083/salesOrders companyId[id]="ue" salesOrderNumber="1" salesType="PO" salesItems[0][productId][id]="1" salesItems[0][qty]=5

http :8083/salesOrders companyId[id]="ue" salesOrderNumber="2" salesType="AS_dsfsdaf"   # 입력오류 Enumeration 에서 벋어나는 type 입력을 막아줌.

http :8083/salesOrders companyId[id]="ue" salesOrderNumber="2" salesType="AS" salesItems[0][productId][id]="2" salesItems[0][qty]=3  salesItems[1][productId][id]="1" salesItems[1][qty]=3  # 성공


http :8084/inventories    # returns no value

http PUT http://localhost:8083/salesOrders/1/produce  # 수주1번 생산완료

http :8084/inventories    # returns the stock of product #1 is 5

http PUT http://localhost:8083/salesOrders/2/produce  # 수주2번 생산완료

http :8084/inventories    # returns the stock of product #1 and #2 are 8 and 3

```

## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```


# Issues
- 멱등성 보장처리:  재고량, 레포트
- 다종 데이터베이스 (현재: mysql, postgres)
- Micro frontends 처리
- 멀티태넌시 처리 방법 다양화 (현재: DB per tenant, 추가: Shared DB & segregated by tenant ID column)
- 태넌트 별 설정 방법...


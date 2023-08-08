# 

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
- delivery
- inventory


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API

```
http :8082/companies code="ue" name="유엔진" industry="SW" foundedDate="2017-03-15"

http :8083/salesOrders companyId[id]="ue" salesOrderNumber="1" salesItems[0][productId][id]="1" salesItems[0][qty]=5

http :8083/salesOrders companyId[id]="ue" salesOrderNumber="2" salesItems[0][productId][id]="2" salesItems[0][qty]=3  salesItems[1][productId][id]="1" salesItems[1][qty]=3

http :8084/inventories    # returns no value

http PUT http://localhost:8083/salesOrders/1/produce

http :8084/inventories    # returns the stock of product #1 is 5

http PUT http://localhost:8083/salesOrders/2/produce

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

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```


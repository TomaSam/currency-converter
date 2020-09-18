# Currency converter

Currency converter can convert amount of:
* euros to another currency
* another currency to euros

![Main](https://user-images.githubusercontent.com/58041722/93584751-6ad21500-f9ae-11ea-9190-b57d582d20eb.JPG)

Exchange rates get from Lithuanian bank website.
	
## Installation

First of all need to create a MySql database called converter_db.
In database add 2 tables with these columns:

![fx_rate table](https://user-images.githubusercontent.com/58041722/93584935-b5ec2800-f9ae-11ea-9a38-e79fa79a1bbc.JPG)

![user_activity table](https://user-images.githubusercontent.com/58041722/93584971-c69c9e00-f9ae-11ea-885e-34f662a5ab23.JPG)

Import Fx Rates to fx_rate table.
Fx Rates you can find in folder converter/src/main/resources/fx_rate.csv.

In the project directory converter, run:

```mvn
mvn clean install
```

```mvn
mvn spring-boot:run
```

In the project directory converterui, run:

```npm
npm install
```

```npm
npm start
```

## Technologies
- Java 1.8
- Spring-boot 2.3.3
 - Maven 3.6.3
 - Lombok 1.18.12
 - React 16.13.1

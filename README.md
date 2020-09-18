# Currency converter

Currency converter can convert amount of:
	* euros to another currency
	* another currency to euros



Exchange rates get from Lithuanian bank website.
	
## Installation

First of all need to create a MySql database called converter_db.
In database add 2 tables with these columns:



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


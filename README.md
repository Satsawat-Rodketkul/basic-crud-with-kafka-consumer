# Basic-Crud-With-Kafka-Consumer
This project was created to learn CRUD with Kafka Spring boot.

## How to start
1. Create kafka following this step [**Start Apache Kafka**].
2. Create database in docker following this step [**PostgreSQL in docker**].
3. Create table user_info_kafka_crud with
```
create table user_info_kafka_crud (
	user_id SERIAL PRIMARY KEY,
	firstname VARCHAR (255),
	lastname VARCHAR (255),
	email VARCHAR (255),
	create_date TIMESTAMP,
	update_date TIMESTAMP
);
```
3. Start this project.
4. Start producer project [https://github.com/Satsawat-Rodketkul/basic-crud-with-kafka-producer].
5. Test consumer with API from producer

## Reference
**Start Apache Kafka:** `https://kafka.apache.org/quickstart` \
**PostgreSQL in docker:** `https://www.commandprompt.com/education/how-to-create-a-postgresql-database-in-docker/` \
**Kafka Spring Boot:** `https://www.youtube.com/watch?v=KQDTtvZMS9c&list=PLW1cM06_Eztpy-4EoGPVguZoZ0huRTIjE&index=7&t=1618s` \

# spring-boot-multiple-db
 Register multiple DB like MySql and PostgreSql and how to handle distributed transaction of multiple DB and roll-back.
 
 
## Database script
1) MySQL Script and (FooDbConfig.java) which has configuration

CREATE schema foo;

CREATE TABLE foo.foo_data 
( id INT NOT NULL AUTO_INCREMENT,  name VARCHAR(45) NULL, PRIMARY KEY (id));


--------------------------------------------

2) PostgreSQL Script and (BarDbConfig.java) which has configuration with bar prefix in application.properties

CREATE DATABASE bar
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
    
    
CREATE TABLE public.bar_data
(
    id bigserial,
    name character varying(500),
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.bar_data
    OWNER to postgres;
    
-----------------------------------------------------------

# Manage Multiple DB transaction and roll-back
  This 'ChainedTransactionManagerConfig' class register both transaction manager DB and it will roll-back when one transaction is failed
  
  Check 'FooService' class which has 'insert' method and hit below URL to save data




----------------------------------------------------------- 
## URL to save data from Postman 
- Save data in both DB
- Http Method : GET
- URL : localhost:8080/save/helloworld
- Response body : OK


## Uncomment RuntimeException from BarService.java
- try above url then it will roll-back both transaction 

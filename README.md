# spring-boot-multiple-db
 
## Database 
1) MySQL Script and (FooDbConfig.java)

create schema foo;

CREATE TABLE foo.foo_data 
( id INT NOT NULL AUTO_INCREMENT,  name VARCHAR(45) NULL, PRIMARY KEY (id));


--------------------------------------------

2) POSTGRESQL Script and (BarDbConfig.java) with bar prefix in application properties

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

# ChainedTransactionManagerConfig
  This class register both transaction manager and it will rollback when one transaction is failed
  
  Check FooService class with insert method and hit below url to save data




----------------------------------------------------------- 
## URL to save data from post man 
- Save data in both DB
- Http Method : GET
- URL : localhost:8080/save/helloworld
- Response body : OK


## Uncomment RuntimeException from BarService.java
- try above url now then it will rollback both transaction 

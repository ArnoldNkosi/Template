echo Started adding application properties required by all environments
aws ssm put-parameter --name "/config/scaffold/spring.application.name" --value "scaffold" --type "SecureString" --description "application name" --overwrite
aws ssm put-parameter --name "/config/scaffold/server.servlet.context-path" --value "/scaffold-api" --type "SecureString" --description "application servlet context path" --overwrite
# DB configuration start
aws ssm put-parameter --name "/config/scaffold/spring.liquibase.change-log" --value "classpath:/db/changelog/liquibase-changeLog.xml" --type "SecureString" --description "path to file containing liquibase database change log" --overwrite
aws ssm put-parameter --name "/config/scaffold/spring.datasource.username" --value "scaffold_app_user" --type "SecureString" --description "database username" --overwrite
aws ssm put-parameter --name "/config/scaffold/spring.liquibase.liquibase-schema" --value "scaffold" --type "SecureString" --description "the schema to create liquibase objects in. e.g. databasechangelog table" --overwrite
aws ssm put-parameter --name "/config/scaffold/spring.jpa.properties.hibernate.cache.use_query_cache" --value "true" --type "SecureString" --description "enable hibernate query cache. See https://www.baeldung.com/hibernate-second-level-cache#Query" --overwrite
aws ssm put-parameter --name "/config/scaffold/spring.jpa.properties.hibernate.cache.use_second_level_cache" --value "true" --type "SecureString" --description "user hibernate second level cache. See https://www.baeldung.com/hibernate-second-level-cache#Enabling" --overwrite
aws ssm put-parameter --name "/config/scaffold/spring.jpa.properties.hibernate.cache.region.factory_class" --value "org.redisson.hibernate.RedissonRegionFactory" --type "SecureString" --description "specify cache region factory to use. See https://dzone.com/articles/caching-in-hibernate-with-redis" --overwrite
aws ssm put-parameter --name "/config/scaffold/spring.jpa.properties.hibernate.cache.redisson.fallback" --value "true" --type "SecureString" --description "Redisson can fallback on database if Redis cache is unavailable. See https://github.com/redisson/redisson/blob/master/redisson-hibernate/README.md" --overwrite
aws ssm put-parameter --name "/config/scaffold/spring.datasource.password" --value "$DB_PASSWORD" --type "SecureString" --description "JDBC URL of the database" --overwrite
# DB configuration end
aws ssm put-parameter --name "/config/scaffold/logging.request.enabled" --value "true" --type "SecureString" --description "log incoming web requests" --overwrite
aws ssm put-parameter --name "/config/scaffold/logging.request.queryString.include" --value "true" --type "SecureString" --description "flag to enable logging of http request query string" --overwrite
aws ssm put-parameter --name "/config/scaffold/logging.request.headers.include" --value "false" --type "SecureString" --description "flag to enable logging of http request header" --overwrite
aws ssm put-parameter --name "/config/scaffold/logging.request.payload.include" --value "false" --type "SecureString" --description "flag to enable logging of http request body" --overwrite
aws ssm put-parameter --name "/config/scaffold/logging.request.payload.maxlength" --value "10000" --type "SecureString" --description "max number of characters to log in request body" --overwrite
aws ssm put-parameter --name "/config/scaffold/management.endpoints.web.exposure.include" --value "*" --type "SecureString" --description "spring actuator endpoints to expose" --overwrite
echo Completed adding application properties required by all environments

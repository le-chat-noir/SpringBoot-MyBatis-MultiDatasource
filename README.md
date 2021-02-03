# Spring Boot + MyBatis + Multiple Datasource Settings

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.2/gradle-plugin/reference/html/)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

##
### Additional Link and Guide

* [Boot + MyBatis Multi-Datasource Example on Programmer Group](https://programmer.group/spring-boot-mybatis-multiple-data-sources.html) 
This one tells how to set up multiple datasource, but did not mention how to deal with Mapper.xml files.
* [Boot + MyBatis Multi-Datasource Example on Programmer VIP](https://programming.vip/docs/springboot-2.0-springboot-mybatis-configure-multiple-data-sources.html)
This one took another approach, and this one did mention adding setting to **SqlSessionFactory** Bean.

##
### Notes
The key is to set 

    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/primary/*.xml"));

in DataSourceConfig to tell each source where to look at xml mappers.   
In multiple datasource situations, each datasource simply **ignores** mybatis.mapper-locations in application.properties.
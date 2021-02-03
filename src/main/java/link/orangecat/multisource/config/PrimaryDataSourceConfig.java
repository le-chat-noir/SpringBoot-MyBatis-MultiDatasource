package link.orangecat.multisource.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "link.orangecat.multisource.persistence.dao.primary", sqlSessionTemplateRef  = "PrimarySessionTemplate")
public class PrimaryDataSourceConfig {

    @Bean(name = "PrimaryDataSource") //As a bean object and named
    @ConfigurationProperties(prefix = "spring.datasource.primary") //In the configuration file, the prefix of the data source
    @Primary
    //For marking up master data sources, this annotation is not added to any injected files other than master data sources
    public DataSource PrimaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "PrimarySessionFactory")
    @Primary
    public SqlSessionFactory PrimarySessionFactory(@Qualifier("PrimaryDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean(); // Use MyBatis-Plus own bean
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/primary/*.xml"));
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        mybatisConfiguration.setMapUnderscoreToCamelCase(false); // Prevent camel case conversion
        bean.setConfiguration(mybatisConfiguration);
        return bean.getObject();
    }

    @Bean(name = "PrimaryTransactionManager")
    @Primary
    public DataSourceTransactionManager PrimaryTransactionManager(@Qualifier("PrimaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "PrimarySessionTemplate")
    @Primary
    public SqlSessionTemplate PrimarySessionTemplate(@Qualifier("PrimarySessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

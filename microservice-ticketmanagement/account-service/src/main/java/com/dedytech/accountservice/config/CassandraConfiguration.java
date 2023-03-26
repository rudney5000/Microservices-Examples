package com.dedytech.accountservice.config;

//import com.datastax.oss.driver.api.core.CqlSessionBuilder;
//import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
//import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
//import com.datastax.oss.driver.api.core.config.ProgrammaticDriverConfigLoaderBuilder;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
//import org.springframework.boot.autoconfigure.cassandra.DriverConfigLoaderBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.*;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.time.Duration;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${mgestiondeticket.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${mgestiondestock.cassandra.port}")
    private int port;

    @Value("${mgestiondeticket.cassandra.contact.point}")
    private String contactPoint;

    @Value("${mgestiondeticket.cassandra.username}")
    private String username;

    @Value("${mgestiondestock.cassandra.password}")
    private String password;

//    @Value("${mgestiondestock.cassandra.local-datacenter}")
//    private String datacenter;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.dedytech.accountservice"};
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setPassword(password);
        clusterFactoryBean.setUsername(username);
        return clusterFactoryBean;
    }

}

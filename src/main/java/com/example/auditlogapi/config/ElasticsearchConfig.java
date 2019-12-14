package com.example.auditlogapi.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.auditlogapi.repository")
public class ElasticsearchConfig {

    @Autowired
    ElasticsearchProperties elasticsearchProperties;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient client() {
        final ClientConfiguration configuration = ClientConfiguration.create(
                        elasticsearchProperties.getHost() + ":" + elasticsearchProperties.getPort());
        return RestClients.create(configuration).rest();
    }

    @Primary
    @Bean
    public ElasticsearchRestTemplate elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}

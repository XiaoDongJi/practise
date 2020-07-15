package com.cckeep.elastic;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

@Configuration
@Configurable
@EnableElasticsearchRepositories
public class ElasticSearchConfig {

    @Value(value = "${crm.elasticsearch.cluster-name}")
    private String culsterName;
    @Value(value = "${crm.elasticsearch.cluster-nodes}")
    private String culsterNodes;

    @Bean
    public ElasticsearchOperations crmElasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(crmEsClient());
    }

    @Bean
    public Client crmEsClient() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", culsterName)
                //.put("client.transport.sniff", true)// 开启嗅探 , 开启后会一直连接不上, 原因未知
                .put("client.transport.nodes_sampler_interval", 10, TimeUnit.SECONDS) //报错,
                .put("client.transport.ping_timeout", 10, TimeUnit.SECONDS) // 报错, ping等待时间,
                .build();
        TransportClient client = TransportClient.builder()
                .settings(settings).build();
        String nodesStr = culsterNodes.trim();
        String[] nodes = nodesStr.split(",");
        for (String node : nodes){
            String[] split = node.split(":");
            InetSocketTransportAddress transportAddress = new InetSocketTransportAddress(InetAddress.getByName(split[0]),Integer.parseInt(split[1]));
            client.addTransportAddress(transportAddress);
        }
        return client;
    }

    @Bean
    public RestClient restClient() {
        RestClient restClient = RestClient.builder(
                new HttpHost("10.16.44.104", 9200))
                .setRequestConfigCallback(
                        new RestClientBuilder.RequestConfigCallback() {
                            @Override
                            public RequestConfig.Builder customizeRequestConfig(
                                    RequestConfig.Builder requestConfigBuilder) {
                                return requestConfigBuilder
                                        .setConnectTimeout(5000)
                                        .setSocketTimeout(60000);
                            }
                        }).build();

        return restClient;
    }

}

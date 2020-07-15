package com.cckeep.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LouRepository extends ElasticsearchRepository<KeUserLou,String> {
}

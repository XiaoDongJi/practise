package com.cckeep.elastic;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "c_rent_k_ld2",type = "default")
public class KeUserLou {
    @Id
    private String id;

    private String zx_name;
    private String city_code;


}

package com.cckeep.elastic;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "c_zo_users",type = "default")
public class User {
    @Id
    private String id;
    //private String _id;
    private Date time;
    private String userName;
    private String password;
    private String phoneNumber;
    private String address;
    private Integer age;
}

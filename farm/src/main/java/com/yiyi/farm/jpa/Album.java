package com.yiyi.farm.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kevin.Z on 2017/12/13.
 */
@Entity
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private Date createTime;

    private String age;

    private String tag;
    private String title;
    private String description;

    public Album(){
        createTime = Utils.getGTM8();
    }
}

package com.bao.msmatch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author baocy
 * @Description //TODO
 * @Date 2020/2/26 21:05
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uid;
    private String name;
    private Integer age;
    private String sex;
    private String imgUrl;

}

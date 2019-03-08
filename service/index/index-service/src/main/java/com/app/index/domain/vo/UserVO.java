package com.app.index.domain.vo;

import lombok.Data;

@Data
public class UserVO {

    private Long id;

    private String uuid;

    private String username;

    private String password;

    private String name;

    private Integer status;

    private Integer isDel;

}

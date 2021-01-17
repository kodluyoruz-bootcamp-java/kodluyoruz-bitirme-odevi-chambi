package org.kodluyoruz.group1.library.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class BaseDTO implements Serializable {

    private Long id;
    private Date createDate;
    private Date updateDate;
    private boolean deleted;
}

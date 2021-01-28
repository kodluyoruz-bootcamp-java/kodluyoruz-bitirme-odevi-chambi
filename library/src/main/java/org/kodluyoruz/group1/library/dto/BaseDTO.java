package org.kodluyoruz.group1.library.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDTO implements Serializable {

    private Long id;
    private Date createDate;
    private Date updateDate;
    private boolean deleted;
}

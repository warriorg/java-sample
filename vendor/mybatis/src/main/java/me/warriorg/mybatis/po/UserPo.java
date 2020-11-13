package me.warriorg.mybatis.po;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author warrior
 */
@Data
public class UserPo implements Serializable {
    private int id;
    private String username;
    private Instant createdOn;
}


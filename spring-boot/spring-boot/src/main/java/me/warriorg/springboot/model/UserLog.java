package me.warriorg.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserLog {

    @Id
    @GeneratedValue(generator = "snowFlakeShrinkID")
    @GenericGenerator(name = "snowFlakeShrinkID", strategy = "me.warrior.common.id.support.SnowFlakeShrinkIDGenerator")
    private Long uid;

    @Column(length = 255)
    private String note;
}

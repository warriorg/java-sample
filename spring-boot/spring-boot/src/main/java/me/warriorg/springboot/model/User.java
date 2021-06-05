package me.warriorg.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author warrior
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "snowFlakeShrinkID")
    @GenericGenerator(name = "snowFlakeShrinkID", strategy = "me.warrior.common.id.support.SnowFlakeShrinkIDGenerator")
    private String uid;

    private String name;
    private int age;
}

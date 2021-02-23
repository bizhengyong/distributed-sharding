package com.imooc.distributedsharding;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: bizy
 * @date: 2021/02/23 19:19
 */
@Data
@Entity
@Table(name = "t_order_0")
public class OrderEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Integer userId;

}

package me.warriorg.model;

import lombok.Data;

import java.util.List;

/**
 * @author gao shiyong
 * @since 2022/12/13 16:21
 */
@Data
public class BookHead {
    private String no;
    private String invoiceNo;

    private String date;

    private List<BookList> list;

    private List<BookPackingList> packingList;

    private List<Customer> customer;

}

package com.book.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDTO implements Serializable {
    private Long id;
    private String title;
    private String author;
    private double price;
}
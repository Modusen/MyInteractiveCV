package com.example.myinteractivecv.model;

import lombok.Data;
import lombok.ToString;

@Data
public class Image {
    private Long id;
    private String filePath;
    private long fileSize;
    private String mediaType;
}

package com.challenge.models.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // crea los metodos
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PutRequest {
    private String title;
    private String body;
    private Integer userId;
}
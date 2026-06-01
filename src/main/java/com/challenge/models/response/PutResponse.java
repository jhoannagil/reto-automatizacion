package com.challenge.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PutResponse {
    private Integer id;
    private String title;
    private String body;
    private Integer userId;
}
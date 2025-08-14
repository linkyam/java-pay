package com.api.api.common;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class APIKey {

    @NotEmpty
    private String mchId;

    @NotEmpty
    private String mchKey;

}

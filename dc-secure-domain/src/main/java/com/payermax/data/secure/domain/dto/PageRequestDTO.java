package com.payermax.data.secure.domain.dto;

import lombok.Data;

import java.util.Map;

/**
 * @Date 2022/2/22
 * @Author cyy
 */
@Data
public class PageRequestDTO {
    private Long pageNum;
    private Long pageSize;
    private Map<String, Object> params;
}

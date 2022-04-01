package com.payermax.data.secure.domain.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Date 2022/2/22
 * @Author cyy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageInfo<T> {
    private Long pageNum;
    private Long pageSize;
    private Long totalCount;
    private List<T> data;
}

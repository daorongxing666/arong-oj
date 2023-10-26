package com.arong.oj.util;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PageUtil {

    public static <T> Page<T> getPageList(List<T> list, int currentPage, int pageSize) {
        Page<T> TPage = new Page<>(currentPage, pageSize);
        TPage.setRecords(list);
        TPage.setTotal(list.size());
        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem createTime = OrderItem.desc("create_time");
        orderItems.add(createTime);
        TPage.setOrders(orderItems);
        return TPage;
    }

    /**
     *
     * @param list
     * @param currentPage
     * @param pageSize
     * @param orderArgs 用逗号分开，逗号前为字段，逗号后为排序方式 create_time,desc
     * @return
     * @param <T>
     */
    public static <T> Page<T> getPageList(List<T> list, int currentPage, int pageSize, String... orderArgs) {
        Page<T> TPage = new Page<>(currentPage, pageSize);
        TPage.setRecords(list);
        TPage.setTotal(list.size());
        List<OrderItem> orderItems = new ArrayList<>();
        for(String orderArg : orderArgs) {
            String[] split = orderArg.split(",");
            OrderItem orderItem;
            if(split.length == 0 || Objects.equals(split[1], "desc")) {
                orderItem = OrderItem.desc(split[0]);
            } else {
                orderItem = OrderItem.asc(split[0]);
            }
            orderItems.add(orderItem);
        }
        TPage.setOrders(orderItems);
        return TPage;
    }

    public static <T> Page<T> getPageList(List<T> list) {
        Page<T> TPage = new Page<>(1, 10);
        TPage.setRecords(list);
        TPage.setTotal(list.size());
        return TPage;
    }
}

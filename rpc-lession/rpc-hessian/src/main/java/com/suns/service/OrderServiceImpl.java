package com.suns.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public void showOrder() {
        log.debug("showOrder Method Invoke");
    }
}

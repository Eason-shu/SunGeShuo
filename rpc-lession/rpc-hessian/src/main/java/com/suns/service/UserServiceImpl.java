package com.suns.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String name, String password) {
        log.debug("login method invoke name {} password {}", name, password);
        return false;
    }

    @Override
    public void register(User user) {
        log.debug("register method invoke {} ", user);
    }
}

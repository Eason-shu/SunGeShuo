package com.suns.service;

public interface UserService {
    public boolean login(String name, String password);

    public void register(User user);
}

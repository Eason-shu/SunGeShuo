package com.suns.service;

import com.suns.User;
import com.suns.UserService;
import org.apache.thrift.TException;

public class UserServiceImpl implements UserService.Iface {

    @Override
    public User queryUserByNameAndPassword(String name, String passwor) throws TException {
        System.out.println("UserServiceImpl.queryUserByNameAndPassword name is " + name + " password is " + passwor);
        return new User("xiaojr", "88888");
    }

    @Override
    public void save(User user) throws TException {
        System.out.println("save user is " + user.getName() + " password is " + user.getPassword());
    }
}

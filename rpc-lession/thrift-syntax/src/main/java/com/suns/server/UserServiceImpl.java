package com.suns.server;

import com.suns.Gender;
import com.suns.User;
import com.suns.UserNotFoundException;
import com.suns.UserService;
import org.apache.thrift.TException;

/**
 * @Description
 * @Author EasonShu
 * @Data 2024/12/3 下午10:03
 */
public class UserServiceImpl implements UserService.Iface {
    @Override
    public User getUser(int id) throws UserNotFoundException, TException {
        return new User(100, "EasonShu", "22100");
    }

    @Override
    public String sayHello(String name) throws TException {
        return "Hello " + name;
    }

    @Override
    public Gender getGender(String name) throws TException {
        return Gender.valueOf(name);
    }
}

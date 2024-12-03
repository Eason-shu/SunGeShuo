package com.suns.serlializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.suns.service.User;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class TestHessianSerializable {
    public static void main(String[] args) throws IOException {
        //Hessian序列化的目的 就是为了传输数据  基本类型 对象（Seriazable接口）
        OutputStream outputStream = new FileOutputStream("F:\\进阶学习\\SunGeShuo\\rpc-lession\\rpc-hessian\\test01");
        Hessian2Output out = new Hessian2Output(outputStream);
        out.writeObject(new User("sunshuai", "123456"));
        out.flush();
        outputStream.close();
        //Hessian反序列化
        InputStream inputStream = new FileInputStream("F:\\进阶学习\\SunGeShuo\\rpc-lession\\rpc-hessian\\test01");
        Hessian2Input hessian2Input = new Hessian2Input(inputStream);
        User user = (User) hessian2Input.readObject();
        log.debug("{}", user);
    }
}

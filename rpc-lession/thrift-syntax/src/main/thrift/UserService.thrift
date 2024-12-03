namespace java com.suns
// 实体类
struct User {
    1: i32 id,
    2: string name,
    3: string email
}
// 异常
exception UserNotFoundException {
    1: i32 id,
    2: string message
}
// 服务接口
service UserService {
    // 获取用户信息
    User getUser(1: i32 id) throws  (1: UserNotFoundException ue)
    // 打招呼
    string sayHello(1: string name)
    // 获取性别
    Gender getGender(1: string name)
}
// 枚举
enum Gender {
    MALE,
    FEMALE
}


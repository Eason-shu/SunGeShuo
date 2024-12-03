# 单行注释
// 单行注释
/*
* 多行注释
*
 */
namespace java com.suns

struct User{
  required string name,
  optional i32 age,
  optional string password = '1234567'
}

enum SEASON{
  SPRING = 1,
  SUMMER = 2
}

exception MyException{
   1: i32 errorCode
   2: string message
}



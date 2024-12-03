include "test.thrift"
namespace java com.service

service UserService{
  void add(1:test.User user)
}
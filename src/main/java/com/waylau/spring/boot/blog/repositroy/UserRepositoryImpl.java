//package com.waylau.spring.boot.blog.repositroy;
//
//import com.waylau.spring.boot.blog.domian.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Repository
//public class UserRepositoryImpl implements UserRepository{
//
//    /****
//     * 暂时用内存模拟数据库
//     * **/
//    private static AtomicLong atomicLong  = new AtomicLong();//计数器
//    private final ConcurrentMap <Long,User> userConcurrentMap = new ConcurrentHashMap<>();
//
//
//    @Override
//    public User saveOrUpdateUser(User user) {
//        Long id = user.getId();
//        if(id!=null){
//            userConcurrentMap.replace(id,user);
//        }else{
//            id = atomicLong.incrementAndGet();
//            user.setId(id);
//            userConcurrentMap.put(id,user);
//        }
//        return user;
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userConcurrentMap.remove(id);
//    }
//
//    @Override
//    public User getUserById(Long id) {
//        return userConcurrentMap.get(id);
//    }
//
//    @Override
//    public List<User> listUser() {
//        return new ArrayList<User>(userConcurrentMap.values());
//    }
//}

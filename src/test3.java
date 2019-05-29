/**
 * @Author: zl
 * @Date: 2019/5/23 20:45
 */
public class test3 {

    public static void main(String[] args) {
        User user = new User("张三");
        change(user);
        System.out.println(user.name);
    }

    public static void change(User u) {
        User user = new User("李四");
        u = user;//复制地址
    }
}
class User {
    String name;
    public User(String name) {
        this.name = name;
    }
}
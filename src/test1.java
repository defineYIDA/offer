/**
 * @Author: zl
 * @Date: 2019/5/4 17:06
 */
public class test1 {
    public static class User {
        Integer age;
        String name;

        public User(Integer age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main (String[] var) {
        Integer age = 1111;
        User user =new User(1111,"abc");
        System.out.println(user.age.equals(1111));
        Integer num1=new Integer(11);
        Integer num2=new Integer(11);
        System.out.println(num1==num2);
    }
}

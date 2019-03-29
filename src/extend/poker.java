package extend;

/**
 * @Author: zl
 * @Date: 2019/3/28 21:43
 */
public class poker {

    static Integer count=0;

    public static void dfs(Integer index,Integer num){
        if(num>13)return;//超过了13张牌，说明已经被计数或者抛弃
        if(index==13){
            if(num==13){
                count++;
            }
            return;
        }
        for(Integer i=0;i<=4;i++){
            dfs(index+1,num+i);
        }
    }

    public static void main(String var[]){
        dfs(0,0);
        System.out.println("result:"+count);
        return;
    }
}

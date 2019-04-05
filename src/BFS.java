import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/4/5 22:53
 */
public class BFS {

    public static void main(String var[]){
        Map<String,List<String>>all=new HashMap();
        /*构建you的人际关系网*/
        List<String> p=new ArrayList<>();
        p.add("alice");
        p.add("bob");
        p.add("clairm");
        //------------------------
        List<String> p1=new ArrayList<>();
        p1.add("anuj");
        p1.add("peggy");
        //---------------------------------
        List<String> p2=new ArrayList<>();
        p2.add("peggy");
        //----------------------------------
        List<String> p3=new ArrayList<>();
        p3.add("thom");
        p3.add("jonny");
        //------------------------------------
        all.put("you",p);
        all.put("bob",p1);
        all.put("alice",p2);
        all.put("clairm",p3);
        all.put("anuj",null);
        all.put("peggy",null);
        all.put("thom",null);
        all.put("jonny",null);
        GraphBFS("you",all);
        return;
    }
    //图的广度优先算法，查找人际关系网中第一个满足条件的人
    //关键一：维护一个队列，因为是搜索最近的；
    //关键二：维护一个已操作列表，防止双向导致死循环
    //运行时间：人数加边长
    public static boolean GraphBFS(String name,Map<String,List<String>>all){
        List<String> pople=all.get(name);
        if(null==pople){
            return false;
        }
        Queue<String> queue=new LinkedList<String>();//维护一个队列
        queue.addAll(pople);
        //queue.offer("");添加一个元素
        List<String>check=new ArrayList<>();
        while (!queue.isEmpty()){
            String some=queue.poll();
            if(check.contains(some)){
                continue;
            }
            if(isM(some)){
                System.out.println(some);
                return true;
            }
            check.add(some);//标记为已检查ss
            List<String> poples=all.get(some);
            if(null!=poples){
                queue.addAll(poples);
             //((LinkedList<String>) queue).addAll(poples);
            }
        }
        return false;
    }
    public static boolean isM(String name){
        if(name==null){
            return false;
        }
        return name.substring(name.length()-1).equals("m");
    }
}

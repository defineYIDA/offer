import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/4/6 9:22
 * 狄克斯特拉算法，适用：
 *        有向权重无环图；
 *        不包含负权边；
 *        求最短路径
 */
public class Dijkstra {

    public static class node{
         String name;
         float weight;//权重
        public  node(String name, float weight) {
            this.name = name;
            this.weight = weight;
        }
    }
    public static void main(String var[]){
        //构建有向权重图
        Map<String, List<node>> all=new HashMap<>();
        List<node> start=new ArrayList<>();
        start.add(new node("A",6));
        start.add(new node("B",2));
        List<node> A=new ArrayList<>();
        A.add(new node("end",1));
        List<node> B=new ArrayList<>();
        B.add(new node("A",3));
        B.add(new node("end",5));
        List<node> end=new ArrayList<>();
        all.put("start",start);
        all.put("A",A);
        all.put("B",B);
        all.put("end",end);
        GraphBFS("start",all);
        if(!costs.get("end").equals(Float.POSITIVE_INFINITY)){
            System.out.println("最短路径："+costs.get("end"));
            printRoad("end");
        }else {
            System.out.println("路径不存在");
        }
        return;
    }
    /**
     * 需要两个辅助空间：
     *        1）记录到某个节点的累计最小权重
     *        2）记录节点的父节点，起点到达该节点的权重值最小；
     */
    //static Map<String,List<node>>all=new HashMap<>();
    static Map<String,Float>costs=new HashMap<>();
    static Map<String,String>parents=new HashMap<>();
    static List<String> check=new ArrayList<>();
    public static void GraphBFS(String name,Map<String,List<node>>all){
        //初始化costs
        initCosts(name,all);
        //初始parents
        initParents(name,all);
        //起点作为已经处理加入集合
        check.add(name);
        //获得当前权重最小的节点的name
        String node=findLowestCostNode();
        while (node!=null) {
            float cost=costs.get(node);//获得对应的累计权重值
            List<node>nodes=all.get(node);//获得该节点的邻居节点
            for(node n : nodes){//遍历邻居节点
                float new_cost=cost+n.weight;//计算到该节点的权重值
                if(costs.get(n.name)>new_cost){//如果新的权重值小于之前的权重值
                    costs.put(n.name,new_cost);//更新累计权重
                    parents.put(n.name,node);//更新父节点
                }
            }
            check.add(node);
            node=findLowestCostNode();
        }
        return ;
    }
    //在costs中找到权重最小的节点
    public static String findLowestCostNode(){
        String node_name=null;
        Float min_cost=null;
        for(String name : costs.keySet()){
            //关键：处理过的跳过
            if(check.contains(name)){
                continue;
            }
            float cost=costs.get(name);
            if(null==min_cost){
                min_cost=cost;
                node_name=name;
                continue;
            }
            //不对已经处理的节点重复处理
            if(min_cost>cost) {
                node_name=name;
                min_cost=cost;
            }
        }
        return node_name;
    }
    //注意costs，只是针对start的最小累计权重
    //寻找起点的所有临近节点，初始化
    public static void initCosts(String start,Map<String,List<node>>all){
        List<node>nodes=all.get(start);
        for (node node :nodes){
            costs.put(node.name,node.weight);
        }
        //对于不相邻的节点初始化为不可达
        for (String name:all.keySet()){
            if(name.equals(start)){
                continue;//忽略掉起点，防止后续判断出错
            }
            if(!costs.containsKey(name)){
                costs.put(name,Float.POSITIVE_INFINITY);
            }
        }
    }
    //没用父节点或者未知父节点的为null
    public static void initParents(String start,Map<String,List<node>>all){
        List<node>nodes=all.get(start);
        for (node node :nodes){
            parents.put(node.name,start);
        }
        for (String name:all.keySet()){
            if(!parents.containsKey(name)){
                parents.put(name,null);
            }
        }
    }
    public static void printRoad(String name){
        System.out.print(name);
        if(null==parents.get(name)){
            return;
        }
        System.out.print("-->");
        printRoad(parents.get(name));
    }
}

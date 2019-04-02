/**
 * @Author: zl
 * @Date: 2019/4/2 16:53
 */
public class test {
    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
/*    public static int canArrangeWords(String arr[])
    {
        int length=arr.length;
        if(length<2){
            return -1;
        }
        for(int i=0;i<=length;i++){
            if(i!=length-1){
                return 1;
            }
            System.out.println(arr[i].get(0));
            if(!arr[i].get(arr[i].length()).equals(arr[i+1].get(0))){
                return -1;
            }
        }
        return -1;
    }*/

    public static void main (String[] args) {
        String arr[]=new String[2];
        arr[0]="qwe";
        arr[1]="efg";
        for(int i=0;i<=arr.length;i++){
            if(i==arr.length-1){
                System.out.println("1");
                return;
            }
            if(!(arr[i].charAt(arr[i].length()-1)==arr[i+1].charAt(0))){
                System.out.println("-1");
            }
        }
    }
}

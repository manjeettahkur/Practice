import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by laxminarayanvarma on 26/11/16.
 */
public class MainApplication {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        int v1 =  in.nextInt();
        int v2 = in.nextInt();

        int x = in.nextInt();
        int y = in.nextInt();

        HashMap<Integer, List<Route>> rMap = new HashMap<>();
        for (int i =1;i<=m;i++){
            int source = in.nextInt();
            int destination = in.nextInt();
            int distance =  in.nextInt();
            int flag = in.nextInt();
            Route obj = new Route(source,destination,distance,flag);
            if(rMap.containsKey(source)){
                rMap.get(source).add(obj);
            }else{
                rMap.put(source,new ArrayList<Route>());
                rMap.get(source).add(obj);
            }
        }
        in.close();

        ArrayList<List<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> temp  = new ArrayList<>();

        temp.add(x);
        dfs(rMap,x, paths, y, 1 ,temp);
        String path = "";
        float min = Integer.MAX_VALUE;
        float cost ;
        for(List<Integer> al : paths){
             if(findPath(rMap,al) == 1){
                 cost =  findCost(rMap, al,v1);
                 if (cost< min){
                     min = cost;
                     path = "Bicycle";
                 }
             }else{
                 cost =  findCost(rMap, al,v2);
                 if (cost< min){
                     min = cost;
                     path = "Motor Bike";
                 }
             }
        }
        System.out.println(path);
    }

    public static int findPath(HashMap<Integer,List<Route>> map,List<Integer> path){
        int pathVal = 0;
        for(int i = 0; i<path.size()-2;i++){
             if(path(map,path.get(i),path.get(i+1)) == 1)
                 pathVal = 1;
        }
        return pathVal;
    }

    public static int path(HashMap<Integer,List<Route>> map, int source, int destination){
        List<Route> ll = map.get(source);
        Route x = null;
        for(Route obj : ll){
            if (obj.destination == destination){
                x = obj;
                break;
            }
        }
        return x.flag;
    }

    static  float cost(HashMap<Integer,List<Route>> map, int source, int destination ,int cost){
        List<Route> ll = map.get(source);
        Route x = null;
        for(Route obj : ll){
            if (obj.destination == destination){
                x = obj;
                break;
            }
        }
        float time = ((float) x.distance / (float) cost )*60;
        return time;

    }
    public static float findCost(HashMap<Integer,List<Route>> map, List<Integer> path,int cost){
        float total = 0;
        for(int i = 0; i<path.size()-2;i++){
         total += cost(map,path.get(i),path.get(i+1),cost)   ;
        }
        return total;
    }

    public static void dfs(HashMap<Integer,List<Route>> map ,Integer source , ArrayList<List<Integer>> paths, int finalDest, int index,ArrayList<Integer> temp){
        if (map.containsKey(source)){
            for(Route obj : map.get(source)){
                if(obj.destination == finalDest){
                    temp.add(index,obj.destination);
                    ArrayList al =  new ArrayList<Integer>(temp);
                    paths.add(al.subList(0,index+1));
                }
                else{
                    temp.add(index,obj.destination);
                    dfs(map,obj.destination,paths,finalDest,index+1,temp);
                }

            }
        }

    }
    }

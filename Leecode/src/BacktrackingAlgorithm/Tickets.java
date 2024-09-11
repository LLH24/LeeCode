package BacktrackingAlgorithm;

import java.util.*;

public class Tickets {
    /***
     * 机票问题,时长不行啊，主要问题是，有很多重复的航班，他要每个都重新排列，太多了
     * 更新方法，用map来表示，其他的相同的增加value，来减少相同机票的排序时间。
     * @param tickets
     * @return
     */
//    boolean isOK = false;
//    List<String> path = new ArrayList<>();
//    List<String> results = new ArrayList<>();
//    public List<String> findItinerary(List<List<String>> tickets) {
//        path.add("JFK");
//        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
//        findResults(tickets,new int[tickets.size()]);
//        return results;
//    }
//    public void findResults(List<List<String>> tickets,int[] used){
//        if(tickets.size()+1 == path.size()) {
//            results = new ArrayList<>(path);
//            isOK = true;
//            return;
//        }
//        if (isOK) return;
//        for (int i = 0; i < tickets.size(); i++) {
//            if (isOK) return;
//            if (used[i] == 0 && tickets.get(i).get(0).equals(path.getLast()) ){
//                path.add(tickets.get(i).get(1));
//                used[i] = 1;
//                findResults(tickets,used);
//                used[i] = 0;
//                path.removeLast();
//            }
//        }
//    }


    boolean isOK = false;
    List<String> path = new ArrayList<>();
    List<String> results = new ArrayList<>();
    Map<String, Map<String, Integer>> map = new HashMap<>();//用来快速查找是否有已存在的tickets

    public List<String> findItinerary(List<List<String>> tickets) {
        path.add("JFK");
        for (List<String> ticket : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(ticket.get(0))) {//起点有一样的，就再判断终点
                temp = map.get(ticket.get(0));
                temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);//终点一样就加一，没有就是0赋1.
            } else {//起点都不一样，就直接写个新的
                temp = new TreeMap<>();//使用treeMap，能对map中的key进行排序
                temp.put(ticket.get(1), 1);
            }
            map.put(ticket.get(0), temp);
        }
        findResults(tickets);
        return results;
    }

    public void findResults(List<List<String>> tickets) {
        if (tickets.size() + 1 == path.size()) {
            results = new ArrayList<>(path);
            isOK = true;
            return;
        }
        if (isOK) return;
        if (map.containsKey(path.getLast())) {
            Map<String, Integer> stringIntegerMap = map.get(path.getLast());//获取起点等于上一个终点的map
            Set<Map.Entry<String, Integer>> entries = stringIntegerMap.entrySet();//遍历map，取字母最小的那个
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue() > 0) {
                    path.add(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                    findResults(tickets);
                    entry.setValue(entry.getValue() + 1);
                    path.removeLast();
                }
            }
        }
    }
}


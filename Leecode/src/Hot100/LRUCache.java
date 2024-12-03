package Hot100;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<Integer,Integer>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (linkedHashMap.containsKey(key)){
            int value = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key,value);
            return value;
        }else return -1;
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)){//只是修改值，需要将该值移动到最新位置
            linkedHashMap.remove(key);
            linkedHashMap.put(key,value);
        }else{//不存在值，需要删除最久，并添加
            if (capacity > 0){//有容量
                capacity--;
                linkedHashMap.put(key,value);
            }else {//无容量
                linkedHashMap.pollFirstEntry();
                linkedHashMap.put(key,value);
            }
        }
    }
}

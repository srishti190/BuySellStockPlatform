package design;

import java.util.*;

public class RandomisedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomisedSet(){
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public static void main(String[] args) throws Exception{
        RandomisedSet rSet = new RandomisedSet();
        System.out.println(rSet.insert(1));
        System.out.println(rSet.insert(2));
        System.out.println(rSet.insert(2));
        System.out.println(rSet.insert(3));
        System.out.println(rSet.remove(2));
        System.out.println(rSet.insert(2));
        System.out.println(rSet.getRandom());
        System.out.println(rSet.insert(234));
        System.out.println(rSet.insert(23));
        System.out.println(rSet.insert(22));
        System.out.println(rSet.getRandom());
        System.out.println(rSet.remove(245));
        System.out.println(rSet.remove(234));
        System.out.println(rSet.getRandom());
    }

    public boolean insert(int val){
        if(!map.containsKey(val)){
            int index = list.size();
            map.put(val, index);
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val){
        if(map.containsKey(val)){
            int posVal = map.get(val);
            int lastIndex = list.size()-1;
            if(posVal < lastIndex){
                int lastIndexVal = list.get(lastIndex);
                map.put(lastIndexVal, posVal);
                list.set(posVal, lastIndexVal);
            }
            map.remove(val);
            list.remove(lastIndex);
            return true;
        }
        return false;
    }

    public int getRandom(){
        return list.get(random.nextInt(list.size()-1));
    }
}

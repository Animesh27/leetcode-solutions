class RandomizedCollection {
    Map<Integer, Set<Integer>> dict;
    List<Integer> list;
    Random rand = new Random();
    public RandomizedCollection() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!dict.containsKey(val)) {
            dict.put(val, new HashSet<>());
        }
        dict.get(val).add(list.size());
        list.add(val);
        return dict.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if(!dict.containsKey(val) || dict.get(val).size() == 0) return false;
        int removeIndex = dict.get(val).iterator().next();
        dict.get(val).remove(removeIndex);
        int lastElement = list.get(list.size() - 1);
        list.set(removeIndex, lastElement);
        dict.get(lastElement).add(removeIndex);
        dict.get(lastElement).remove(list.size()-1);
        list.remove(list.size() -1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
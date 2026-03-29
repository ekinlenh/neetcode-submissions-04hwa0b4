class Pair {
    String value;
    int timestamp;

    Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    private HashMap<String, List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        // check if map contains key
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> pairs = map.get(key);
        String res = "";

        int left = 0, right = pairs.size() - 1;
        while (left <= right) {
            int middle = (left + right) / 2;

            if (pairs.get(middle).timestamp <= timestamp) {
                left = middle + 1;
                res = pairs.get(middle).value;
            } else {
                right = middle - 1;
            } 
        }

        return res;
    }
}

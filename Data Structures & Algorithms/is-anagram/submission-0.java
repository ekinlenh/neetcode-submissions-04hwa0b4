class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            String[] s_array = s.split("");
            String[] t_array = t.split("");

            HashMap<String, Integer> s_map = new HashMap<String, Integer>();
            HashMap<String, Integer> t_map = new HashMap<String, Integer>();

            for (int i = 0; i < s_array.length; i++) {
                if (s_map.containsKey(s_array[i])) {
                    s_map.put(s_array[i], s_map.get(s_array[i]) + 1);
                } else {
                    s_map.put(s_array[i], 1);
                }
            }

            for (int i = 0; i < t_array.length; i++) {
                if (t_map.containsKey(t_array[i])) {
                    t_map.put(t_array[i], t_map.get(t_array[i]) + 1);
                } else {
                    t_map.put(t_array[i], 1);
                }
            }
  
            int countMatchedEntries = 0;

            for (Map.Entry<String, Integer> entry : s_map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();

                if (t_map.containsKey(key)) {
                    if (t_map.get(key).equals(value)) {
                        countMatchedEntries++;
                    }
                }
            }

            if (countMatchedEntries == s_map.size()) {
                return true;
            }
        }

        return false;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!= t.length()) {
            return false;
        }

        String[] s_array = s.split("");
        String[] t_array = t.split("");

        HashMap<String, Integer> s_map = new HashMap<String, Integer>();
        HashMap<String, Integer> t_map = new HashMap<String, Integer>();

        for (int i = 0; i < s_array.length; i++) {
            s_map.put(s_array[i], s_map.getOrDefault(s_array[i], 0) + 1);
            t_map.put(t_array[i], t_map.getOrDefault(t_array[i], 0) + 1);
        }
  
        return s_map.equals(t_map);
    }
}

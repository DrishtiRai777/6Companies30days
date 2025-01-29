// https://leetcode.com/problems/high-access-employees/description/
class Solution {
    public boolean isHighAccess(List<Integer> list) {
        if(list.size() < 3) return false;
        for(int i=0; i<list.size()-2; i++) {
            if((list.get(i+2) - list.get(i)) < 100) return true;
        }

        return false;
    }

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(List<String> ac: access_times) {
            String emp = ac.get(0);
            int time = Integer.parseInt(ac.get(1));
            map.putIfAbsent(emp, new ArrayList<>());
            map.get(emp).add(time);
        }

        List<String> list = new ArrayList<>();

        for(String emp: map.keySet()) {
            List<Integer> timing = new ArrayList<>(map.get(emp));
            Collections.sort(timing);
            if(isHighAccess(timing)) 
                list.add(emp);
        }

        return list;
    }
}

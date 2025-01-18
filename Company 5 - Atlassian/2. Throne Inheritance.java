// https://leetcode.com/problems/throne-inheritance/description/
class ThroneInheritance {
    HashMap<String, Integer> map; // for successors and corr. idx
    List<List<String>> graph; // adjList
    HashSet<String> set; // for dead people
    List<String> list; // ans list
    String root;

    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        set = new HashSet<>();
        graph = new ArrayList<>();
        list = new ArrayList<>();
        graph.add(new ArrayList<>());
        map.put(kingName, 0);
        root = kingName;
    }
    
    public void birth(String parentName, String childName) {
        int idx = map.get(parentName);
        graph.get(idx).add(childName);
        graph.add(new ArrayList<>());
        map.put(childName, graph.size() - 1);
    }
    
    public void death(String name) {
        set.add(name);
    }
    
    public void dfs(String start, List<String> list, List<List<String>> graph) {
        if (!set.contains(start)) list.add(start);
        int idx = map.get(start);
        for (String str : graph.get(idx)) {
            dfs(str, list, graph);
        }
    }

    public List<String> getInheritanceOrder() {
        list.clear();
        dfs(root, list, graph);
        return list;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName, childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */

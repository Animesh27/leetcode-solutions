/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        return dfs(map, id);
    }

    public int dfs(Map<Integer, Employee> map , int id){
        Employee e = map.get(id);
        int importance = e.importance;
        for(int subId: e.subordinates){
            importance += dfs(map, subId);
        }
        return importance;
    }
}
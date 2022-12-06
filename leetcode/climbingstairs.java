class Solution {

    private Map<Integer,Integer> memo=new HashMap<>();
    public int climbStairs(int n) {
       return helper(n);
        
    }
    public int helper(int n){
        int result=0;
        if(memo.containsKey(n)) return memo.get(n);
        if(n==1) return 1;
        if(n==2) return 2;
        result=(helper(n-1)+helper(n-2));
        memo.put(n,result);
        return result;
        
    }
}
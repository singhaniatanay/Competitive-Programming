class schedule_course {
    public int[] findOrder(int num, int[][] pre) {
        ArrayList<Integer>[] graph = new ArrayList[num];
        for(int i=0;i<num;i++) graph[i] = new ArrayList<Integer>();
        for(int i=0;i<pre.length;i++){
            graph[pre[i][0]].add(pre[i][1]);
        }
        
        visited = new boolean[num];
        ans = new int[num];
        k=0;
        done = new boolean[num];
        for(int i=0;i<num;i++){
            if(visited[i]) continue;
            if(!isOrder(graph,i)) return new int[0];
        }
        return ans;
    }
    public static int[] ans;
    public static int k=0;
    public static boolean[] visited;
    public static boolean[] done;
    public static boolean isOrder(ArrayList<Integer>[] graph,int src){
        if(done[src]) return true;
        if(visited[src]) return false;
        
        visited[src] = true;
        for(int i:graph[src]){
            if(isOrder(graph,i)) continue;
            return false;
        }
        done[src] = true;
        ans[k++] = src;
        return true;
    }
}
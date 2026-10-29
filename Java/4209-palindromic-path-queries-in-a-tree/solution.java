class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int[] tin = new int[n], tout = new int[n];
        int[] parent = new int[n], depth = new int[n];
        int[] order = new int[n];
        int[][] up = new int[n][17];
        int[] stack = new int[2 * n];
        int top = 0, timer = 0;
        stack[top++] = 0;
        parent[0] = 0;
        while (top > 0) {
            int x = stack[--top];
            if (x < 0) {
                tout[~x] = timer;
                continue;
            }
            tin[x] = timer;
            order[timer++] = x;
            stack[top++] = ~x;
            for (int y : adj[x]) {
                if (y == parent[x]) continue;
                parent[y] = x;
                depth[y] = depth[x] + 1;
                stack[top++] = y;
            }
        }
        for (int x = 0; x < n; x++) up[x][0] = parent[x];
        for (int j = 1; j < 17; j++)
            for (int x = 0; x < n; x++)
                up[x][j] = up[up[x][j - 1]][j - 1];
        int[] mask = new int[n];
        for (int i = 0; i < n; i++)
            mask[i] = 1 << (s.charAt(i) - 'a');
        int[] rootMask = new int[n];
        for (int x : order)
            rootMask[x] = mask[x] ^ (x == 0 ? 0 : rootMask[parent[x]]);
        int[] fenwick = new int[n + 2];
        List<Boolean> answer = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int x = Integer.parseInt(p[1]);
                int newMask = 1 << (p[2].charAt(0) - 'a');
                int delta = mask[x] ^ newMask;
                mask[x] = newMask;
                for (int i = tin[x] + 1; i < fenwick.length; i += i & -i)
                    fenwick[i] ^= delta;
                for (int i = tout[x] + 1; i < fenwick.length; i += i & -i)
                    fenwick[i] ^= delta;
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int a = u, b = v;
                if (depth[a] < depth[b]) {
                    int t = a; a = b; b = t;
                }
                int diff = depth[a] - depth[b];
                for (int j = 0; j < 17; j++)
                    if ((diff & (1 << j)) != 0) a = up[a][j];
                if (a != b) {
                    for (int j = 16; j >= 0; j--) {
                        if (up[a][j] != up[b][j]) {
                            a = up[a][j];
                            b = up[b][j];
                        }
                    }
                    a = parent[a];
                }
                int lca = a;
                int mu = rootMask[u], mv = rootMask[v];
                for (int i = tin[u] + 1; i > 0; i -= i & -i) mu ^= fenwick[i];
                for (int i = tin[v] + 1; i > 0; i -= i & -i) mv ^= fenwick[i];
                int pathMask = mu ^ mv ^ mask[lca];
                answer.add(Integer.bitCount(pathMask) <= 1);
            }
        }
        return answer;
    }
}

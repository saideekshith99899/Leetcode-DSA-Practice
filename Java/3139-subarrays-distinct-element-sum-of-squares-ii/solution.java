import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> last = new HashMap<>();
        SegmentTree st = new SegmentTree(n);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last.getOrDefault(x, -1);

            st.update(prev + 1, i, 1);

            ans = (ans + st.querySquares(0, i)) % MOD;

            last.put(x, i);
        }

        return (int) ans;
    }

    static class SegmentTree {
        int n;
        long[] sum, sumSq, lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n + 5];
            sumSq = new long[4 * n + 5];
            lazy = new long[4 * n + 5];
        }

        void apply(int node, int l, int r, long val) {
            long len = r - l + 1L;
            val %= MOD;

            sumSq[node] = (
                sumSq[node] + 2L * val % MOD * sum[node] % MOD
                + len % MOD * val % MOD * val % MOD
            ) % MOD;

            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) {
                return;
            }

            int mid = (l + r) / 2;

            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);

            lazy[node] = 0;
        }

        void update(int ql, int qr, long val) {
            if (ql > qr) return;
            update(1, 0, n - 1, ql, qr, val);
        }

        void update(int node, int l, int r,
                    int ql, int qr, long val) {
            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }

            push(node, l, r);
            int mid = (l + r) / 2;

            if (ql <= mid) {
                update(node * 2, l, mid, ql, qr, val);
            }

            if (qr > mid) {
                update(node * 2 + 1, mid + 1, r, ql, qr, val);
            }

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
        }

        long querySquares(int ql, int qr) {
            return querySquares(1, 0, n - 1, ql, qr);
        }

        long querySquares(int node, int l, int r,
                          int ql, int qr) {
            if (ql <= l && r <= qr) {
                return sumSq[node];
            }

            push(node, l, r);
            int mid = (l + r) / 2;
            long res = 0;

            if (ql <= mid) {
                res = querySquares(node * 2, l, mid, ql, qr);
            }

            if (qr > mid) {
                res = (res + querySquares(
                    node * 2 + 1, mid + 1, r, ql, qr
                )) % MOD;
            }

            return res;
        }
    }
}

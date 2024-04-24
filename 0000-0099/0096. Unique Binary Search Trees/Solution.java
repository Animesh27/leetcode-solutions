/**
 * G(n)=∑
 * i=1
 * n
 * ​
 *  G(i−1)∗G(n−i)
 *
 * Here is my attempt to explain.
 *
 * Imagine we want to find G(3), it can be expressed as:
 * G(3)=G(0)∗G(2)+G(1)∗G(1)+G(2)∗G(0)\mathrm{G(3)} = G(0) * G(2) + G(1) * G(1) + G(2) * G(0)G(3)=G(0)∗G(2)+G(1)∗G(1)+G(2)∗G(0)
 *
 * Now we don't know what is G(2), but we can calculate it like this:
 * G(2)=G(0)∗G(1)+G(1)∗G(0)\mathrm{G(2)} = G(0) * G(1) + G(1) * G(0)G(2)=G(0)∗G(1)+G(1)∗G(0)
 *
 * We can clealy see that to calculate G(3), we need to know all previous G(2), G(1), and etc.
 *
 * That's why it actually makes sense to start calculating from smaller number. eg: G(2), G(3), G(4) ..
 *
 * We don't need to calculate G(0) and G(1) they are both 1.
 * 1 node tree is 1 combination
 * 0 node (empty tree) is 1 combination
 *
 * So, now back to the original question.
 */
public class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
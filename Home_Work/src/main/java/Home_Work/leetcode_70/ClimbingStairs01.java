package Home_Work.leetcode_70;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
public class ClimbingStairs01 {
    public int climbStairs(int n) {
        //斐波那契
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }

    public static void main(String[] args) {
        ClimbingStairs01 climbingStairs01 = new ClimbingStairs01();
        System.out.println(climbingStairs01.climbStairs(2));
    }
}

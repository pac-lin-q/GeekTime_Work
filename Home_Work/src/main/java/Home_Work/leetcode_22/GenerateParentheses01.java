package Home_Work.leetcode_22;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 */
public class GenerateParentheses01 {
    //结果输出格式list
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        _genrate(0,0,n,"");
        return result;
    }

    public void _genrate(int left, int right,int n,String s){
        //满足n的时候直接return，输出结果
        if (left == n && right == n){
            result.add(s);
            return;
        }
        //左括号只要小于n都可以加
        if (left<n) _genrate(left+1,right,n,s+"(");
        //右括号增加必须有左括号的前提才能add
        if (right<left) _genrate(left,right+1,n,s+")");
    }

    public static void main(String[] args) {
        GenerateParentheses01 generateParentheses01 = new GenerateParentheses01();
        System.out.println(generateParentheses01.generateParenthesis(3));
    }

}

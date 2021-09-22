package com.company.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhulei
 * @create 2021-04-09 10:18
 */
public class InfixToSuffix {

    public static void main(String[] args) {
        String expression  = "1+((2+3)*4)-5";
        //将字符串转换为对应的list
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        //中缀转后缀

        List<String> parseSuffixList = parseSuffixList(list);
        System.out.println(parseSuffixList);

        int calculate = PolandNotation.calculate(parseSuffixList);
        System.out.println(calculate);
    }

    /**
     * 中缀转后缀
     * @param list 中缀list
     * @return 后缀list
     */
    public static List<String> parseSuffixList(List<String> list) {
        //1、初始化两个栈
        Stack<String> s1 = new Stack<>();
        //因为s2在整个转换过程中没有pop操作，最后还需要逆序输出，直接使用list
        List<String> s2 = new ArrayList<>();
        //2、从左至右扫描中缀表达式
        for (String item : list) {
            //如果是一个数，加入到s2
            if (item.matches("\\d+")) {
                s2.add(item);
            }else if ("(".equals(item)){
                //如果是左括号，入s1
                s1.push(item);
            }else if (")".equals(item)) {
                //如果是右括号，依次弹出s1栈顶的运算符，并加入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //弹出左括号
                s1.pop();
            }else {
                /*
                当item的优先级小于等于s1栈顶的运算符，
                将s1栈顶的运算符弹出并压入到s2中，
                再次比较item与s1新栈顶运算符优先级(需要一个比较优先级的方法)
                 */
                while (s1.size() != 0 && Operation.getValue(item) <= Operation.getValue(s1.peek())){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出加入s2中
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;
    }

    /**
     * 将中追表达式转换成对应的list
     * @param s 要转换的中缀表达式
     * @return 转换得到的中缀list
     */
    public static List<String> toInfixExpressionList(String s) {
        //list用于存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        //用于遍历中缀表达式字符串的指针
        int i = 0;
        String str;//对多位数拼接
        //每遍历一个字符，就存到c中
        char c;
        do {
            //如果c不是一个数字，直接加入list
            if ((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            }else {
                //先将str清空
                str = "";
                while (i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57) {
                    //拼接
                    str += c;
                    i++;
                }
                list.add(str);
            }
        }while (i < s.length());
        return list;
    }
}

//返回一个运算符对应的优先级
class Operation {

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("运算符错误");
                break;
        }
        return res;
    }
}
package com.company.stack;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhulei
 * @create 2021-04-09 9:06
 */
public class PolandNotation {

    public static void main(String[] args) {


        //先定义一个逆波兰表达式
        String suffixExpression = "33 4 + 5 * 6 -";

        List<String> listString = getListString(suffixExpression);

        System.out.println(suffixExpression + " = " + calculate(listString));

    }



    /**
     * 将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
     * @param suffixExpression 要存入的表达式
     * @return 返回的List
     */
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    /**
     * 完成对逆波兰表达式的计算
     * 1、从左至右进行扫描，将数字入栈
     * 2、遇到运算符，弹出栈顶元素和次顶元素，计算值，将结果入栈
     * 3、依次类推，最后留在栈中的是结果
     * @param list 要计算得表达式存入的list
     * @return 计算结果
     */
    public static int calculate(List<String> list) {
        //创建一个栈用来存放扫描到的数
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            //用正则表达式来匹配数字
            if (item.matches("\\d+")) {
                //如果是数，入栈
                stack.push(item);
            }else {
                //创建两个临时变量来存放弹出的元素
                //栈顶元素
                int num1 = Integer.parseInt(stack.pop());
                //次顶元素
                int num2 = Integer.parseInt(stack.pop());
                //存放结果的变量
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        System.out.println("运算符错误");
                        break;
                }
                //将结果入栈
                stack.push(""+res);
            }
        }
        //返回最后的计算结果
        return Integer.parseInt(stack.pop());
    }
}

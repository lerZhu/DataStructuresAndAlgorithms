package com.company.stack;

/**
 * @author zhulei
 * @create 2021-04-08 14:33
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "111+2*6-2";
        //创建两个栈。数栈、符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //扫描索引
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存到ch中
        String keepNum = "";//用于拼接多位数
        while (true) {
            //一次得到expression中的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么
            if (operStack.isOper(ch)) {
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较
                    //如果当前的操作符的优先级小于或者等于栈中的操作符，就需要pop出两个数，从符号栈中pop出一个符号
                    //进行运算，将得到的结果入数栈，然后又将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        //进行运算，将得到的结果入数栈
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        //当前的操作符入符号栈
                        operStack.push(ch);
                    }else {
                        //如果当前的操作符的优先级大于栈中的操作符
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else {
                //判断是几位数，处理时，向expression的表达式的index向后看一位，如果是数就进行扫描。是符号才入栈
                //定义一个字符串变量，用于拼接
                keepNum += ch;

                //如果ch是expression的最后一位，直接入栈
                if (index == expression.length() - 1){
                    numStack.push(ch);
                }else {
                    //判断下一个字符是不是数字，
                    //如果是数字，继续扫描
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum
                        keepNum = "";
                    }
                }
            }
            //index+1,并判断是否扫描完成
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //最后留在数栈中的数字就是结果
        while (true) {
            //如果符号栈为空，则计算到最后结果，数栈中只有一个数字
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            //进行运算，将得到的结果入数栈
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println(expression + "=" + numStack.pop());
    }
}

class ArrayStack2{

    //栈最大容量
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    //top表示栈顶，初始为-1
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //遍历,从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top;i >= 0;i--){
            System.out.println(stack[i]);
        }
    }

    //查看栈顶
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top];
    }

    //入栈
    public void push(int data){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = data;
    }

    //出栈
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    //返回运算符优先级，数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2,int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}
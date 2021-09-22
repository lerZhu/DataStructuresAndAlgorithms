package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-05 21:13
 */
public class AddString {

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        //设定 i，j 两指针分别指向 num1，num2 尾部，模拟人工加法
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        //计算进位： 计算 carry = tmp / 10，代表当前位相加是否产生进位；
        int carry = 0;
        while (i >= 0 || j >= 0) {
            //索引溢出处理： 当指针 i或j 走过数字首部后，给 n1，n2 赋值为 0，
            // 相当于给 num1，num2 中长度较短的数字前面填 00，以便后续计算。
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            //添加当前位： 计算 tmp = n1 + n2 + carry，并将当前位 tmp % 10 添加至 res 头部；
            res.append(temp % 10);
            i--;
            j--;
        }
        //当遍历完 num1，num2 后跳出循环，并根据 carry 值决定是否在头部添加进位 11，最终返回 res 即可。
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}

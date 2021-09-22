package com.company.hashTable;

import java.util.Scanner;

/**
 * @author zhulei
 * @create 2021-04-12 17:09
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加");
            System.out.println("list:显示");
            System.out.println("search:查找");
            System.out.println("delete:删除");
            System.out.println("exit:退出");
            System.out.println("--------");

            int id;
            key = scanner.next();
            switch (key){
                case "a":
                    System.out.println("输入id");
                    id = scanner.nextInt();
                    System.out.println("输入name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.addEmp(emp);
                    break;
                case "l":
                    hashTable.list();
                    break;
                case "s":
                    System.out.println("输入id");
                    id = scanner.nextInt();
                    hashTable.getEmpById(id);
                    break;
                case "d":
                    System.out.println("输入id");
                    id = scanner.nextInt();
                    hashTable.deleteById(id);
                    break;
                case "e":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建hashtab
class HashTable{
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.empLinkedListArray = new EmpLinkedList[size];
        //分别初始化每一条链表,否则会出现空指针
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加员工
     * @param emp 待添加的员工
     */
    public void addEmp(Emp emp){
        //根据员工的id得到该员工应该加入哪个链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp加入到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    /**
     * 遍历HashTab
     */
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 根据id查找员工
     * @param id 要查找的员工的id
     * @return 查找到的员工的id
     */
    public void getEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].getEmpById(id);
        if (emp == null) {
            System.out.println("没找到该员工");
        }else {
            System.out.println(emp);
        }
    }

    /**
     * 通过id删除雇员
     * @param id 需要删除的雇员的id
     */
    public void deleteById(int id) {
        int empLinkedListNo = hashFun(id);
        int i = empLinkedListArray[empLinkedListNo].deleteEmpById(id);
        if (i == 1) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    /**
     * 散列函数
     * @param id 需要映射的id
     * @return 映射后的id
     */
    public int hashFun(int id) {
        return id % size;
    }
}

class Emp{

    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList{
    //头指针，指向第一个雇员，因此这个链表的head是有效的
    private Emp head = null;

    /**
     * 添加员工
     * @param emp 添加的员工
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = emp;
    }

    /**
     * 遍历当前链表
     */
    public void list(int i) {
        if (head == null) {
            System.out.println("第" + i + "条链表为空");
            return;
        }
        System.out.println("第" + i + "条链表信息为：");
        Emp temp = head;
        while (true) {
            System.out.print(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 通过id查找雇员
     * @param id 查找雇员的id
     * @return 找到的雇员
     */
    public Emp getEmpById(int id) {
        if (head == null) {
            return null;
        }
        Emp temp = head;
        while (true) {
            if (temp.id == id) {
                break;
            }
            if (temp.next == null) {
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 通过id删除guy
     * @param id 需要删除的雇员的id
     * @return -1,删除失败；1,删除成功
     */
    public int deleteEmpById(int id){
        //头结点为空
        if (head == null) {
            return -1;
        }
        //先判断头结点是不是要找的雇员
        if (head.id == id) {
            head = head.next;
            return 1;
        }
        Emp temp = head;
        while (temp.next != null) {
            if (temp.next.id == id){
                temp.next = temp.next.next;
                return 1;
            }
            temp = temp.next;
        }
        return -1;
    }
}
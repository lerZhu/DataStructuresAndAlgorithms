package com.company.linkedlist;

import java.util.Stack;

/**
 * @author zhulei
 * @create 2021-03-25 21:07
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "磊哥", "帅哥");

        HeroNode hero6 = new HeroNode(6, "磊6哥", "帅哥");
        HeroNode hero7 = new HeroNode(7, "磊7哥", "帅哥");
        HeroNode hero8 = new HeroNode(8, "磊8哥", "帅哥");
        HeroNode hero9 = new HeroNode(9, "磊9哥", "帅哥");


        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList.addHero(hero1);
//        singleLinkedList.addHero(hero2);
//        singleLinkedList.addHero(hero3);
//        singleLinkedList.addHero(hero4);

        singleLinkedList.addHeroByRank(hero1);
        singleLinkedList.addHeroByRank(hero3);
        singleLinkedList.addHeroByRank(hero5);
        singleLinkedList.addHeroByRank(hero7);
        singleLinkedList.addHeroByRank(hero9);

        singleLinkedList2.addHeroByRank(hero2);
        singleLinkedList2.addHeroByRank(hero4);
        singleLinkedList2.addHeroByRank(hero6);
        singleLinkedList2.addHeroByRank(hero8);


//        singleLinkedList.list();
//        System.out.println();
//
//        singleLinkedList.update(hero5);
//
//        singleLinkedList.list();
//        System.out.println();
//
//        singleLinkedList.delete(hero5);
//        singleLinkedList.list();
//
//        int length = getLength(singleLinkedList.getHead());
//        System.out.println(length);
//
//        HeroNode lastK = seekLastK(singleLinkedList.getHead(), 1);
//        System.out.println(lastK);
//
//        reversalSLL(singleLinkedList.getHead());
        System.out.println("链表1");
        singleLinkedList.list();
        System.out.println("链表2");
        singleLinkedList2.list();

//        System.out.println();
//        reversePrint(singleLinkedList.getHead());

        System.out.println("合并和的链表");
        merge(singleLinkedList.getHead(),singleLinkedList2.getHead());
    }

    /**
     * 合并两个有序的单向链表，合并之后的链表依然有序
     * @param head1 单向链表1
     * @param head2 单向链表2
     */
    public static void merge(HeroNode head1,HeroNode head2){
        //创建一个新的链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode newHead = singleLinkedList.getHead();
        //如果两个链表中存在空链表
        if (head1.next == null || head2.next == null){
            if (head1.next == null && head2.next == null){
                System.out.println("两个空链表");
            }
            newHead.next = (head1.next != null)?head1.next:head2.next;
        }
        //把链表一加入新链表
        newHead.next = head1.next;
        //遍历链表二，将链表二的节点加入新链表
        HeroNode temp = head2.next;
        while (temp != null) {
            head2.next = temp.next;
            //temp指向链表二的下一个节点要消除，不然会插入一大串
            temp.next = null;
            singleLinkedList.addHeroByRank(temp);
            temp = head2.next;
        }

        singleLinkedList.list();
    }

    /**
     * 从尾到头打印单链表 利用栈
     * @param head 需要倒序打印的单链表的头结点
     */
    public static void reversePrint(HeroNode head) {
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //创建一个栈
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode temp = head.next;
        //遍历链表，入栈
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }
        //出栈，输出
        while (heroNodes.size() > 0) {
            System.out.println(heroNodes.pop());
        }
    }

    /**
     * 单链表反转
     * @param head 要反转的单链表
     */
    public static void reversalSLL(HeroNode head) {

        //如果链表为空或者只有一个节点不需要反转
        if(head.next == null || head.next.next == null) {
            System.out.println("链表不需要反转");
            return;
        }

        //创建一个临时反转后链表的头结点
        HeroNode reversalSLLHead = new HeroNode(0,"","");
        //遍历原链表，每遍历一个就把该节点取出，插入反转链表的最前端
        HeroNode temp = head.next;
        while (true) {
            if (temp.next == null) {
                break;
            }else {
                //设置一个临时节点来存储temp的下一个节点，用于后面temp的后移
                HeroNode curr = temp.next;
                temp.next = reversalSLLHead.next;
                reversalSLLHead.next = temp;
                //temp后移
                temp = curr;
            }
        }
        //原来链表的head.next = reversalSLLHead.next
        head.next = reversalSLLHead.next;
    }

    /**查找单链表的倒数第k个节点
     * @param head 头结点
     * @param index 倒数第index个
     * @return 节点
     */
    public static HeroNode seekLastK(HeroNode head,int index){
        if (head.next == null) {
            System.out.println("链表为空");
            return null;
        }
        //先遍历链表，得到链表总长度
        int length = getLength(head);
        //判断index是否超过链表长度
        if(index > length || index <= 0) {
            System.out.println("index非法");
            return null;
        }
        HeroNode temp = head.next;
        //再遍历一次数组，遍历长度为length-index
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //获取单链表的节点个数，（如果带头结点，需要去除头结点）
    /**
     * @param head 头结点
     * @return  单链表节点个数
     */
    public static int getLength(HeroNode head){
        //单链表没有节点
        if(head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode temp = head;
        while(true) {
            if(temp.next != null){
                length++;
            } else {
                return length;
            }
            temp = temp.next;
        }
    }
}

//定义SingleLinkedList管理英雄
class SingleLinkedList{

    //初始化头结点
    private HeroNode head = new HeroNode(0," "," ");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //当不考虑编号的顺序时
    //1.找到当前链表的最后一个节点
    //2.最后节点的next域指向新的节点
    public void addHero(HeroNode heroNode) {
        //因为head节点不能动，我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历，找到链表最后一个节点
        while (true) {
            //找到链表最后
            if (temp.next == null){
                break;
            }else {
                //没有找到，将temp后移
                temp = temp.next;
            }
        }
        temp.next = heroNode;
    }

    //按排名顺序添加英雄
    public void addHeroByRank(HeroNode heroNode) {
        //因为head节点不能动，我们需要一个辅助遍历temp
        //因为是单链表，我们找的temp是位于添加位置的前一个节点，否则添加不了
        HeroNode temp = head;
        while (true) {
            if (temp.next == null){
                temp.next = heroNode;
                break;
            }else {
                if (temp.next.no == heroNode.no) {
                    System.out.println("已添加过英雄" + heroNode.name);
                    break;
                }
                if (temp.next.no > heroNode.no) {
                    heroNode.next = temp.next;
                    temp.next = heroNode;
                    break;
                }
                //没有找到，将temp后移
                temp = temp.next;
            }
        }
    }

    //修改英雄信息
    public void update(HeroNode heroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("没有找到该节点");
                break;
            }
            if (temp.next.no == heroNode.no) {
                temp.next.name = heroNode.name;
                temp.next.nickName = heroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    //删除节点
    public void delete(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要删除的节点
        HeroNode temp = head;
        while (true) {
            if(temp.next == null) {
                System.out.println("没有找到该节点");
                break;
            }
            if(temp.next.no == heroNode.no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为head节点不能动，我们需要一个辅助遍历temp
        HeroNode temp = head.next;
        //遍历，找到链表最后一个节点
        while (true) {
            //找到链表最后
            if (temp == null){
                break;
            }else {
                //没有找到，将temp后移
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }
}

//定义一个HeroNode，每个HeroNode对象就是一个节点
class HeroNode{

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                "'}";
    }
}

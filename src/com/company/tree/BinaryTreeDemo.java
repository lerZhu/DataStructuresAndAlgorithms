package com.company.tree;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author zhulei
 * @create 2021-04-13 11:17
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1,"宋江");
        Node node2 = new Node(2,"吴用");
        Node node3 = new Node(3,"林冲");
        Node node4 = new Node(4,"卢俊义");
        Node node5 = new Node(5,"关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

//        System.out.println("前序查找");
//        Node resNode1 = binaryTree.preSearch(5);
//        if (resNode1 != null) {
//            System.out.println(resNode1);
//        }else {
//            System.out.println("没找到");
//        }
//
//        System.out.println("中序查找");
//        Node resNode2 = binaryTree.infixSearch(5);
//        if (resNode2 != null) {
//            System.out.println(resNode2);
//        }else {
//            System.out.println("没找到");
//        }
//
//        System.out.println("后序查找");
//        Node resNode3 = binaryTree.postResearch(5);
//        if (resNode3 != null) {
//            System.out.println(resNode3);
//        }else {
//            System.out.println("没找到");
//        }

        System.out.println("删除前：");
        binaryTree.preOrder();
        binaryTree.deleteNode2(3);
        System.out.println("删除后");
        binaryTree.preOrder();
    }
}

class BinaryTree{

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if (this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("空，无法遍历");
        }
    }

    //后续遍历
    public void postOrder(){
        if (this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("空，无法遍历");
        }
    }

    /**
     * 前序查找
     * @param no 查找编号
     * @return 找到的节点
     */
    public Node preSearch(int no){
        if (root != null) {
            return this.root.preSearch(no);
        }else {
            return null;
        }
    }

    /**
     * 中序查找
     * @param no 查找编号
     * @return 找到的节点
     */
    public Node infixSearch(int no) {
        if (root != null) {
            return this.root.infixSearch(no);
        }else {
            return null;
        }
    }

    /**
     * 后序查找
     * @param no 查找编号
     * @return 找到的节点
     */
    public Node postResearch(int no) {
        if (root != null) {
            return this.root.postSearch(no);
        }else {
            return null;
        }
    }

    /**
     * 删除节点
     * @param no 需要删除的节点序号
     */
    public void deleteNode(int no) {
        if (root != null) {
            //判断root是不是要删除的节点
            if (root.getNo() == no) {
                root = null;
            }else {
                root.deleteNode(no);
            }
        }else {
            System.out.println("空树");
        }
    }

    public void deleteNode2(int no) {
        Node temp;
        if (root != null) {
            //判断root是不是要删除的节点
            if (root.getNo() == no) {
                if(root.getLeft() != null) {
                    temp = root.getRight();
                    root = root.getLeft();
                    Node curNode = root;
                    while (curNode.getRight() != null) {
                        curNode = curNode.getRight();
                    }
                    curNode.setRight(temp);

                }else {
                    root = root.getRight();
                }
            }else {
                root.deleteNode2(no);
            }
        }else {
            System.out.println("空树");
        }
    }
}

class Node{
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String nanme) {
        this.no = no;
        this.name = nanme;
    }

    @Override
    public String toString() {
        return "node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    //前序遍历
    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //递归向左
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder() {
        //递归向左
        if (this.left != null) {
            this.left.infixOrder();
        }
        //先输出父节点
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder() {
        //递归向左
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        //先输出父节点
        System.out.println(this);
    }

    //前序查找

    /**
     * 前序查找
     * @param no 查找编号
     * @return 找到的节点
     */
    public Node preSearch(int no) {
        System.out.println("前序计数~~~~~");
        //先比较当前节点是不是
        if (this.no == no){
            return this;
        }
        //判断当前节点的左子节点是否为空，若不为空，则递归前序查找
        //如果左递归前序查找，找到节点，则返回
        Node resNode = null;
        if (this.getLeft() != null) {
            resNode = this.left.preSearch(no);
        }
        //左递归找到节点，返回
        if (resNode != null) {
            return resNode;
        }
        //有递归前序查找，找到节点，则返回，否则继续
        if (this.getRight() != null) {
            resNode = this.right.preSearch(no);
        }
        return resNode;
    }

    /**
     * 中序查找
     * @param no 查找编号
     * @return 找到的节点
     */
    public Node infixSearch(int no) {
        Node resNode = null;
        //判断当前节点的左子节点是否为空，如果不为空，递归中序查找
        if (this.getLeft() != null) {
            resNode = this.left.infixSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("中序计数~~~~~");
        //左子序列没找到，和当前节点比较，如果是则返回当前节点
        if (this.no == no) {
            return this;
        }
        //右递归中序查找
        if (this.getRight() != null) {
            resNode = this.right.infixSearch(no);
        }
        return resNode;
    }

    /**
     * 后序查找
     * @param no 查找编号
     * @return 找到的节点
     */
    public Node postSearch(int no) {

        Node resNode = null;
        if (this.getLeft() != null) {
            resNode = this.getLeft().postSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.getRight() != null) {
            resNode = this.getRight().postSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("后序计数~~~~~");
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 删除节点
     * 1、如果删除的节点是叶子结点，则删除该节点
     * 2、如果删除的节点是非叶子结点，则删除该子树
     * @param no 需要删除的节点序号
     */
    public void deleteNode(int no) {
        //两个判断条件不能交换顺序，this.left.no可能会空指针异常
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.deleteNode(no);
        }
        if (this.right != null) {
            this.right.deleteNode(no);
        }
    }

    public void deleteNode2(int no) {
        if (this.left != null && this.left.no == no) {
            //如果该非叶子结点有左子节点和右子节点
            //让左子节点代替该非叶子结点
            //右子节点接到左子节点的最后一个柚子节点的右边
            if (this.left.left != null) {
                Node temp = this.left.right;
                this.left = this.left.left;
                Node curNode = this.left;
                while (curNode.right != null) {
                    curNode = curNode.right;
                }
                curNode.right = temp;
            }else {
                this.left = this.left.right;
            }
            return;
        }
        if (this.right != null && this.right.no == no) {
            if (this.right.left != null) {
                Node temp = this.right.right;
                this.right = this.right.left;
                Node curNode = this.right;
                while (curNode.right != null) {
                    curNode = curNode.right;
                }
                curNode.right = temp;
            }else {
                this.right = this.right.right;
            }
            return;
        }
        if (this.left != null) {
            this.left.deleteNode(no);
        }
        if (this.right != null) {
            this.right.deleteNode(no);
        }
    }
}
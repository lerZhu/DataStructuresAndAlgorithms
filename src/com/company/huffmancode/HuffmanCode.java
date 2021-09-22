package com.company.huffmancode;

import java.io.*;
import java.util.*;

/**
 * @author zhulei
 * @create 2021-04-16 16:45
 */
public class HuffmanCode {
    public static void main(String[] args) {

//        //测试压缩文件
//        String srcFile = "d://src.bmp";
//        String dstFile = "d://src.zip";
//
//        zipFile(srcFile,dstFile);
//        System.out.println("压缩文件成功");

        //测试解压文件
        String zipFile = "d://src.zip";
        String dstFile = "d://src1.png";
        unZip(zipFile,dstFile);
        System.out.println("解压完成");


//        String str = "i like like like java do you like a java";
//        byte[] contentBytes = str.getBytes();
//        System.out.println(contentBytes.length);
//
//        byte[] bytes = huffmanZip(contentBytes);
//        System.out.println(Arrays.toString(bytes));
//
//
//        List<Node> nodes = getNodes(contentBytes);
//        System.out.println(nodes);
//
//        Node huffmanTreeRoot = createHuffmanTree(nodes);
//        //preOrder(huffmanTreeRoot);
//
//        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
//        //System.out.println(codes);
//
//        byte[] huffmanCodeBytes = zip(contentBytes, codes);
//        //System.out.println(Arrays.toString(huffmanCodeBytes));
//
//        byte[] sourceBytes = decode(codes, huffmanCodeBytes);
//        System.out.println(Arrays.toString(sourceBytes));
//        for (byte sourceByte : sourceBytes) {
//            System.out.print((char) sourceByte);
//        }
    }

    /**
     * 文件解压
     * @param zipFile   准备解压的文件
     * @param detFile   解压后将文件放到哪个目录
     */
    public static void unZip(String zipFile,String detFile) {
        //定义文件的输入流
        InputStream is = null;
        //定义对象输入流
        ObjectInputStream ois = null;
        //定义文件输出流
        OutputStream os = null;

        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte,String> codes = (Map<Byte, String>) ois.readObject();

            //解码
            byte[] bytes = decode(codes, huffmanBytes);
            //将bytes写入目标文件
            os = new FileOutputStream(detFile);
            //写数据到文件中
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     *将一个文件进行压缩
     * @param srcFile   传入的希望压缩的文件的全路径
     * @param dstFile   压缩后将压缩文件放到哪个目录
     */
    public static void zipFile(String srcFile, String dstFile) {
        //
        OutputStream os = null;
        FileInputStream is = null;
        ObjectOutputStream oos = null;

        try {
            //创建一个文件的输入流
            is = new FileInputStream(srcFile);
            //创建一个和原文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputSteam
            oos = new ObjectOutputStream(os);
            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //以对象流的方式写入赫夫曼编码，为了以后恢复源文件时使用
            //一定要把赫夫曼编码写入压缩文件
            oos.writeObject(huffmanCodes);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 对压缩数据解码
     * @param huffmanCodes 赫夫曼编码表
     * @param huffmanBytes  赫夫曼编码得到的字节数组
     * @return 原来字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes) {

        //1.先得到huffmanBytes对应的二进制的字符串
        //[-88, -65, ...  --> 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag,huffmanBytes[i]));
        }

        //把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为要反向查询
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }

        //创建一个集合，存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //取出‘1’ ‘0’
                String key = stringBuilder.substring(i, i+count);
                b = map.get(key);
                if (b == null) {
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //当for循环结束后，list中就存放了所有字符
        //把list中的数据放入到byte[]并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个byte转成一个二进制字符串
     * @param b 传入的byte
     * @param flag 标识是否需要补高位，true：需要，false：不需要 如果是最后一个字节，无需补高位
     * @return 传入byte对应的二进制字符串（补码返回）
     */
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        //如果是正数，补高位
        if (flag){
            temp |= 256;
        }

        String string = Integer.toBinaryString(temp);
        if (flag) {
            return string.substring(string.length()-8);
        }else {
            return string;
        }
    }


    /**
     *  将下面的方法封装，方便调用
     * @param bytes 原始字符串对用对应的byte数组
     * @return  经过赫夫曼编码处理后的数组
     */
    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //根据nodes生成赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //对应的赫夫曼编码（根据赫夫曼树）
        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
        //根据赫夫曼编码，对原始数组进行压缩
        byte[] zip = zip(bytes, codes);
        return zip;
    }

    /**
     * 将字符串对应的byte[]数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
     * @param bytes 原始字符串对应的byte[]
     * @param huffmanCodes  生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的数组
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes) {
        //利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        //System.out.println(stringBuilder.toString());

        //将stringBuilder转成byte[]
        int len;// = stringBuilder.length() % 8 == 0 ? stringBuilder.length() / 8 : stringBuilder.length() / 8 + 1;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        }else {
            len = stringBuilder.length() / 8 + 1;
        }
        //存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            //不够8位
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i+8);
            }
            //将strByte转成一个byte，放入到cd
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }


    //将赫夫曼编码存放在Map中
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    //在生成赫夫曼编码表时，需要拼接路径，定义一个StringBuilding存储某个叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 重载getCodes
     * @param node
     * @return
     */
    public static Map<Byte,String> getCodes(Node node) {
        if (node == null) {
            return null;
        }
        getCodes(node.left,"0",stringBuilder);
        getCodes(node.right,"1",stringBuilder);
        return huffmanCodes;
    }

    /**
     * 将传入的Node节点的所有叶子结点的赫夫曼编码得到，并放入huffmanCOde中
     * @param node  传入的节点
     * @param code  路径：左子节点是0，右子节点是1
     * @param stringBuilder 用于拼接路径
     */
    public static void getCodes(Node node,String code,StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node != null) {
            //判断当前node是叶子结点还是非叶子结点
            if (node.data == null) {
                //递归处理
                getCodes(node.left,"0",stringBuilder2);
                getCodes(node.right,"1",stringBuilder2);
            }else {
                //找到了某个叶子结点最后
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }


    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("空，无法遍历");
        }
    }

    /**
     * 创建赫夫曼树
     * @param nodes 待转换的集合
     * @return 赫夫曼树的根节点
     */
    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //创建一颗新的二叉树，它的根节点没有data，只有权值
            Node parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 接收字节数组，返回一个list
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {

        List<Node> nodes = new ArrayList<>();

        //存储每个byte出现的次数 -》 map
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b , 1);
            }else {
                counts.put(b,count + 1);
            }
        }

        //把每个键值对转成一个Node对象
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }

        return nodes;

    }
}

class Node implements Comparable<Node>{

    Byte data;//存放数据本身
    int weight;//权值
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}

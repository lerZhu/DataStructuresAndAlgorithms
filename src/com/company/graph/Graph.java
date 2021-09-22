package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;
import java.util.function.IntPredicate;
import java.util.jar.JarEntry;

/**
 * @author zhulei
 * @create 2021-04-19 10:23
 */
public class Graph {

    //存储顶点集合
    private ArrayList<String> vertexList;
    //存储图对应的领接矩阵
    private int[][] edges;
    //表示边的数目
    private int numOfEdges;
    //定义数组boolean[]，记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] Vertex = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String value : Vertex) {
            graph.insertVertex(value);
        }
        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();

//        System.out.println("深度优先");
//        graph.dfs();

        System.out.println("广度优先");
        graph.bfs();
    }

    public Graph(int n) {
        //初始化矩阵和ArrayList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[n];
    }

    /**
     * 得到第一个邻接节点的下标w
     * @param index
     * @return 如果存在就返回下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1,int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 一个节点的广度优先遍历
     * @param isVisited
     * @param i
     */
    public void bfs(boolean[] isVisited,int i) {
        //队列头结点对应的下标
        int u;
        //邻接节点w
        int w;
        //队列，记录节点访问的顺序
        LinkedList queue = new LinkedList();
        //访问这个节点
        System.out.print(getValueByIndex(i) + "->");
        //标记为已访问
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            //取出队列头结点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接点的下标w
            w = getFirstNeighbor(u);
            while (w != -1) {
                //是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //标记以及访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻接点
                w = getNextNeighbor(u,w);//体现广度优先
            }
        }
    }

    /**
     * 遍历所有节点进行广度优先搜索
     */
    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited,i);
            }
        }
    }

    /**
     * 深度优先遍历算法
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited,int i) {
        //首先访问该节点，输出
        System.out.println(getValueByIndex(i) + "->");
        //将该节点置为已访问
        isVisited[i] = true;
        //查找节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    public void dfs() {
        //遍历所有的节点，进行dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited,i);
            }
        }
    }

    /**
     * 返回节点的个数
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到边的数目
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 返回节点i（下标）对应的数据 0->"A" 1->"B"
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 返回v1，v2的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 插入节点
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1    表示点的小标，即是第几个顶点
     * @param v2    表示第二个顶点的下标
     * @param weight    表示这两个点的关系
     */
    public void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}

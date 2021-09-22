package com.company.recursion;

/**
 * @author zhulei
 * @create 2021-04-09 15:31
 */
public class Labyrinth {
    public static void main(String[] args) {
        //先创建一个二维数组模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[4][1] = 1;
        map[4][2] = 1;
        map[4][3] = 1;
        map[3][3] = 1;
        map[2][3] = 1;
        map[2][2] = 1;

        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.println("------------");

        setWay(map,1,1);

        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯给小球找路
     * @deprecated 如果小球能到（6,5），说明能找到通路，
     * 约定：当map[i][j]为0时表示该店没有走过，1表示墙，2表示通路可以走，3表示该点以及走过不能走
     * 走迷宫时，我们需要确定一个策略，下-》右-》上-》左，如果该点走不通，再回溯
     * @param map 地图
     * @param i
     * @param j （i，j）表示小球初始坐标
     * @return 找到为真
     */
    public static boolean setWay(int[][] map,int i,int j){
        //通络以及找到
        if (map[6][5] == 2) {
            return true;
        }else {
            if (map[i][j] == 0) {
                //假定该点可以走通
                map[i][j] = 2;
                if (setWay(map,i+1,j)) {//向下走
                    return true;
                }else if (setWay(map,i,j+1)){//向右走
                    return true;
                }else if (setWay(map,i-1,j)) {//向上走
                    return true;
                }else if (setWay(map,i,j-1)){//向左走
                    return true;
                }else {
                    //说明该点走不通，死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}

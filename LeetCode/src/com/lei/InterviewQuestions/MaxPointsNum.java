package com.lei.InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhulei
 * @create 2021-09-22 15:18
 */
public class MaxPointsNum {

    public int maxPointsNum (Point[] points) {
        // write code here
        int len = points.length;
        if (len < 2) {
            return len;
        }
        int max_points = 0;
        for (int i = 0; i < len; i++) {
            int dup = 0, vlt = 0;
            Point a = points[i];
            Map<Float,Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }else {
                    Point b = points[j];
                    if (a.x == b.y){
                        if (a.y == b.y) {
                            dup++;
                        }else {
                            vlt++;
                        }
                    }else {
                        float k = (float)(b.y - a.y) / (b.x - a.x);
                        if (map.get(k) == null) {
                            map.put(k,1);
                        }else {
                            map.put(k, 1 + map.get(k));
                        }
                    }
                }
            }
            int max = vlt;
            for (Float k : map.keySet()) {
                max = Math.max(max,map.get(k));
            }
            max_points = Math.max(max_points, max + dup);
        }
        return max_points + 1;
    }

}


class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


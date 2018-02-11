/*
given a matrix with 0 and  1. find paths of 1 from one corner of matrix to another.
Input:
1 1 0 0
1 1 1 1
0 1 0 1
0 1 1 1

Output:
P(0,0), P(0,1), P(1,1), P(1,2), P(1,3), P(2,3), P(3,3)
*/
import java.io.*;
import java.util.*;

class Point {
  int i, j;
  boolean visited;

  Point(int x, int y) {
    i = x;
    j = y;
  }
}

class FinPath {

  static Stack<Point> find_path(int[][] m, int i, int j, Stack<Point> stack) {
    if (stack.isEmpty())
      return stack;
    Point p = stack.peek();
    i = p.i;
    j = p.j;

    if (j + 1 < m[0].length && m[i][j + 1] == 1) {
      stack.push(new Point(i, j + 1));
      stack = find_path(m, i, j + 1, stack);
    }
    p = stack.peek();
    if (p.i == m.length - 1 && p.j == m[0].length - 1)
      return stack;

    if (i + 1 < m.length && m[i + 1][j] == 1) {
      stack.push(new Point(i + 1, j));
      stack = find_path(m, i + 1, j, stack);
    }
    p = stack.peek();
    if (p.i == m.length - 1 && p.j == m[0].length - 1)
      return stack;

    stack.pop();
    return stack;
  }

  public static void main(String args[]) {
    int[][] m = { { 1, 1, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 0, 1 }, { 0, 1, 1, 1 } };
    // int[] [] m= {{1,1,1},{1,1,0},{1,1,1}};

    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        System.out.print(m[i][j] + " ");
      }
      System.out.println(" ");
    }

    System.out.println("Point of Path: ");

    Stack<Point> stack_of_point = new Stack<Point>();
    stack_of_point.push(new Point(0, 0));
    Stack<Point> stack = find_path(m, 0, 0, stack_of_point);
    for (Point p : stack) {
      System.out.println(p.i + " " + p.j);
    }

  }
}


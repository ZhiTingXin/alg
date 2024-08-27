package com.test.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 79. 单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 */
public class Question79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if(exist(board, i, j, visited, word.substring(1))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, boolean[][] visited, String word) {
        if (word.length() == 0) {
            return true;
        } else {
            // 寻找下一个单词位置
            char c = word.charAt(0);
            boolean left = false;
            boolean right= false;
            boolean top = false;
            boolean down = false;
            if (i < board.length-1 && !visited[i+1][j] && board[i+1][j] == c) {
                // 向下探索
                visited[i+1][j] = true;
                down = exist(board, i+1, j, visited, word.substring(1));
                if (!down) {
                    visited[i+1][j] = false;
                }
            }
            if (i > 0 && !visited[i-1][j] && board[i-1][j] == c) {
                // 向上探索
                visited[i-1][j] = true;
                top = exist(board, i-1, j, visited, word.substring(1));
                if (!top) {
                    visited[i-1][j] = false;
                }
            }
            if (j < board[0].length-1 && !visited[i][j+1] && board[i][j+1] == c) {
                // 向右探索
                visited[i][j+1] = true;
                right = exist(board, i, j+1, visited, word.substring(1));
                if (!right) {
                    visited[i][j+1] = false;
                }
            }
            if (j > 0 && !visited[i][j-1] && board[i][j-1] == c) {
                // 向左探索
                visited[i][j-1] = true;
                left =  exist(board, i, j-1, visited, word.substring(1));
                if (!left) {
                    visited[i][j-1] = false;
                }
            }
            return left || right || top || down;
        }
    }
    public static void main(String[] args) {
        Question79 q = new Question79();
        System.out.println(q.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(q.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(q.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
        System.out.println(q.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
    }
}

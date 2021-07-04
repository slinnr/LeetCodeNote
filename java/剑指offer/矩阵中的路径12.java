package main.Java.com.sunlin.剑指offer;

public class 矩阵中的路径12 {

    public static void main(String[] args) {

        矩阵中的路径12 path = new 矩阵中的路径12();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCEA";
        boolean res = path.exist(board, word);
        System.out.println(res);
    }



    public boolean exist(char[][] board , String word){

        if (board.length == 0){
            return false;
        }

        boolean[][] isUse = new boolean[board.length][board[0].length];
        boolean res = false;

        for (int i = 0 ; i < board.length ; i++){

            for (int j = 0 ; j < board[i].length ; ++j){

                if (board[i][j] == word.charAt(0)){
                    res = findRode(board , isUse ,board.length , board[i].length , i , j , 1 , word , "");

                    if (res){
                        return res;
                    }
                }
            }
        }
        return res;
    }

    private boolean findRode(char[][] board, boolean[][] isUse,int rows , int columns , int row, int column , int depth , String word , String res) {

        if (depth == word.length()+1){
            return true;
        }

        boolean isHaveRode = false;

        if (row == rows || row < 0 || column == columns || column < 0 || isUse[row][column] == true || word.charAt(depth - 1) != board[row][column]){
            return false;
        }
        res = res + board[row][column];

        isUse[row][column] = true;

        isHaveRode = findRode(board , isUse , rows , columns , row+1 , column , depth+1 , word , res)
                || findRode(board , isUse , rows , columns , row-1 , column , depth+1 , word , res)
                || findRode(board , isUse , rows , columns , row , column+1 , depth + 1, word  , res)
                || findRode(board , isUse , rows , columns , row , column-1 , depth + 1, word, res);

        if (!isHaveRode){
            //回溯
            isUse[row][column] = false;
            depth--;
        }
        return isHaveRode;
    }
}

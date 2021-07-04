package main.Java.com.sunlin.剑指offer;

public class 机器人的运动范围 {

    public static void main(String[] args) {

        机器人的运动范围 moveArea  = new 机器人的运动范围();
        int res = moveArea.movingCount(3, 3, 2);
        System.out.println(res);
    }

    public int movingCount(int m, int n, int k) {

        if (k < 0 || m < 0 || n < 0){
            return 0;
        }

        if (k == 0){
            return 1;
        }

        int res = 0;
        boolean[][] map = new boolean[m][n];
        res = robotMove(map , 0 , 0 , m , n , k);
        return res;
    }

    private int robotMove(boolean[][] map, int row, int column , int rows , int columns , int k) {

        int res = 0;

        if (check(map , row , column , rows , columns , k)){
            res = 1 + robotMove(map , row+1 , column , rows , columns , k)
                    + robotMove(map , row-1 , column , rows , columns , k)
                    + robotMove(map , row , column+1 , rows , columns , k)
                    + robotMove(map , row , column-1 , rows , columns , k);
        }
        return res;
    }

    private boolean check(boolean[][] map, int row, int column , int rows , int columns , int k) {

        if (row == rows || row < 0 || column == columns || column < 0 || getDigitSum(row) + getDigitSum(column) > k || map[row][column]){
            return false;
        }
        map[row][column] = true;
        return true;
    }

    private int getDigitSum(int num) {
        int sum = 0;

        while (num > 0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }

}

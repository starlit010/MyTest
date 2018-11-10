package com.grayliu.alg.dynamic;

import java.util.Arrays;

/**
 * Created by liuhui-ds9 on 2018/9/5.
 */
public class BombEnemy {

    String[][] matrix = new String[3][4];

    public void init(){
        Arrays.fill(matrix[0], "O");
        Arrays.fill(matrix[1], "O");
        Arrays.fill(matrix[2], "O");
        matrix[0][1] = "E";
        matrix[1][0] = "E";
        matrix[1][3] = "E";
        matrix[2][2] = "E";
        matrix[1][2] = "W";
    }

    public void count(){
        int kills = 0;
        String point = "";
        for(int x = 0 ; x < matrix.length ; x++){
            for(int y = 0 ; y < matrix[0].length ; y++){
                if("O".equals(matrix[x][y])){
                    int tempKill = countX(y,0,x) + countX(y, x+1 , matrix.length) + countY(x,0,y) + countY(x,y,matrix[0].length);
                    if(tempKill > kills){
                        kills = tempKill;
                        point = x + "." + y;
                    }
                }
            }
        }
        System.out.println(kills + ",point" + point);
    }

    public int countX(int y, int startX, int endX){
        int count = 0;
        for(int x = startX ; x < endX ; x++){
            if("O".equals(matrix[x][y])){
                count = 0;
            }else if("E".equals(matrix[x][y])){
                count++;
            }else if("W".equals(matrix[x][y]) && x <= endX){
                count = 0;
            }
        }
        return count;
    }

    public int countY(int x, int startY, int endY){
        int count = 0;
        for(int y = startY ; y < endY ; y++){
            if("O".equals(matrix[x][y])){
                count = 0;
            }else if("E".equals(matrix[x][y])){
                count++;
            }else if("W".equals(matrix[x][y]) && x <= endY){
                count = 0;
            }
        }
        return count;
    }

    public void printMatrix(){
        for(int x = 0 ; x < matrix.length ; x++){

            for(int y = 0 ; y < matrix[0].length ; y++){

                if(y == matrix[0].length - 1){
                    System.out.println(matrix[x][y]);
                }else{
                    System.out.print(matrix[x][y]);
                }
            }
        }
    }

    public static void main(String...args){
        BombEnemy bombEnemy = new BombEnemy();
        bombEnemy.init();
        bombEnemy.printMatrix();
        bombEnemy.count();
    }

}

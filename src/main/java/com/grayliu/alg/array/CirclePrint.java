package com.grayliu.alg.array;

/**
 * Created by liuhui-ds9 on 2018/8/26.
 *
 * 螺旋打印有两个属性：一个是矩阵的位置，一个是数组的位置
 *
 */
public class CirclePrint {

    public static void main(String...args){

        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12};

        int[][] matrix = new int[4][4];

        int x = 4,y = 4;

        int currentX = 0, currentY = 0;

        for(int i = 0 ; i < array.length ; i++){

            if( i / 3 == 0){
                matrix[currentX][currentY] = array[i];
                currentY++;
                continue;
            }

            if( i / 3 == 1){
                matrix[currentX][currentY] = array[i];
                currentX++;
                continue;
            }

            if( i / 3 == 2){
                matrix[currentX][currentY] = array[i];
                currentY--;
                continue;
            }

            if( i / 3 == 3){
                matrix[currentX][currentY] = array[i];
                currentX--;
                continue;
            }

        }
        printMatrix(matrix);

    }

    public static void printMatrix(int[][] matrix){

        for(int i = 0 ; i < matrix[0].length; i++){
            for(int j = 0 ; j < matrix.length; j++){
                if(matrix[i][j] < 10){
                    System.out.print(matrix[i][j] + "  ");
                }else if(matrix[i][j] >= 10){
                    System.out.print(matrix[i][j] + " ");
                }
                if(j == matrix.length - 1){
                    System.out.print("\n");
                }
            }
        }
    }



}

package main.java.com.grayliu.alg.print;

/**
 * Created by liuhui-ds9 on 2018/3/13.
 */
public class HelixPrint {

    public static void helix(int length){
        int[][] helix = new int[length][length];
        int flag = 1;
        for(int i = 0; i < length / 2 ; i++ ){
            int startX,startY;

            startX = i;
            startY = i;
            for(int x = startX; x < length - i -1 ; x++){
                helix[x][startY] = flag;
                flag++;
            }

            startX = length - i - 1;
            startY = i ;
            for(int y = startY; y < length - i - 1 ; y++){
                helix[startX][y] = flag;
                flag++;
            }

            startX = length - i - 1;
            startY = length - i - 1;
            for(int x = startX; x > i ; x--){
                helix[x][startY] = flag;
                flag++;
            }

            startX = i;
            startY = length - i - 1;
            for(int y = startY; y > i ; y--){
                helix[startX][y] = flag;
                flag++;
            }

        }
        if(length % 2 != 0){
            helix[length/2][length/2] = flag;
        }
        printHelix(helix);
    }

    public static void printHelix(int[][] helix){
        for(int y = 0 ; y < helix.length ; y++){
            for(int x = 0 ; x < helix.length ; x++){
                if(helix[x][y] < 10){
                    System.out.print(helix[x][y]+"    ");
                }else if(helix[x][y] < 100){
                    System.out.print(helix[x][y]+"   ");
                }else if(helix[x][y] < 1000){
                    System.out.print(helix[x][y]+"  ");
                }
            }
            System.out.print("\r\n");
        }
    }


    public static void main(String...args){
        helix(4);
    }

}

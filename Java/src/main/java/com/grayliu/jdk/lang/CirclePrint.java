package main.java.com.grayliu.jdk.lang;

/**
 * Created by liuhui-ds9 on 2018/6/21.
 */
public class CirclePrint {

    int x_min = 0,x_max = 4,y_min = 0,y_max = 4, max = 25;

    int[][] array = {{13,14,15,16,1},{12,23,24,17,2},{11,22,25,18,3},{10,21,20,19,4},{9,8,7,6,5}};

    public void printXPlus(){
        for(int x = x_min; x <= x_max; x++){
            int point = array[x][y_max];
            System.out.println(point);
            if(point == max){
                break;
            }
        }
        y_max --;
    }


//    1 2 3 4 5
//    16 17 18  19   6
//    15  24 25  20 7
//    14  23 22  21 8
//    13 12  11 10 9

    public void printYMinus(){
        for(int y = y_max; y >= y_min; y--){
            int point = array[x_max][y];
            System.out.println(point);
            if(point == max){
                break;
            }
        }
        x_max --;
    }

    public void printXMinus(){
        for(int x = x_max; x >= x_min; x--){
            int point = array[x][y_min];
            System.out.println(point);
            if(point == max){
                break;
            }
        }
        y_min ++;
    }

    public void printYPlus(){
        for(int y = y_min; y <= y_max; y++){
            int point = array[x_min][y];
            System.out.println(point);
            if(point == max){
                break;
            }
        }
        x_min ++;
    }



    public static void main(String...args){
        CirclePrint circlePrint = new CirclePrint();
        while(true){
            circlePrint.printXPlus();
            circlePrint.printYMinus();
            circlePrint.printXMinus();
            circlePrint.printYPlus();
        }
    }

}

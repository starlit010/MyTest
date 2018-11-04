package com.grayliu.alg.character;

/**
 * Created by liuhui-ds9 on 2017/9/12.
 * <p>
 * 锟斤拷锟斤拷锟紸CB锟斤拷锟斤拷锟街凤拷锟筋长锟斤拷锟街凤拷锟斤拷
 * <p>
 * 锟斤拷锟斤拷锟斤拷锟斤拷
 * <p>
 * 锟叫革拷bug锟斤拷锟斤拷应锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷录锟斤拷一锟斤拷锟酵第讹拷锟斤拷锟街凤拷锟斤拷锟斤拷锟斤拷应锟矫帮拷锟街凤拷锟脚碉拷一锟斤拷锟斤拷锟斤拷锟斤拷
 * 锟斤拷锟斤拷墓丶锟斤拷遣锟斤拷锟斤拷锟揭拷锟酵凤拷锟斤拷锟斤拷锟揭伙拷伪锟斤拷锟斤拷锟斤拷锟斤拷锟缴的★拷锟斤拷锟斤拷应锟矫达拷每锟斤拷锟斤拷锟斤拷锟斤拷母锟侥点开始锟斤拷锟叫憋拷锟斤拷锟斤拷锟揭碉拷锟筋长一锟斤拷为止锟斤拷然锟斤拷佣锟斤拷锟斤拷锟揭晃伙拷锟绞硷拷锟斤拷卤锟斤拷锟斤拷锟?
 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷应锟斤拷锟揭碉拷一锟轿诧拷锟揭的癸拷锟缴ｏ拷然锟斤拷锟斤拷n锟轿诧拷锟揭★拷
 * 锟斤拷说锟斤拷锟斤拷n锟斤拷xx锟斤拷锟解。锟斤拷要锟揭碉拷xx锟斤拷什么锟斤拷然锟斤拷锟截革拷锟酵匡拷锟斤拷锟剿★拷
 */
public class LongestList {


    public static void main(String... args) {

        String s = "ACDGDFDBDSCACDFMDHB";

//        char[] shortChars = {'A','C','B'};

        char[] charArray = s.toCharArray();

        int getNumber = 0, endNumber = 0;
        int startNumber = 0, startVal = 0;
        int secondNumber = 0, secondVal = 0;


        for (int i = 0; i < charArray.length; i++) {
            switch ((int) charArray[i]) {
                case (int) 'A':
                    if (getNumber == 0 || getNumber == 2 || getNumber == 4 || getNumber == 6) {
                        if (startNumber == 0) {
                            getNumber += 1;
                            startNumber = i + 1;
                            startVal = (int) 'A';
                        } else if (getNumber == 6) {
                            endNumber = i + 1;
                            getNumber += 1;
                            System.out.printf("start:%d,end:%d,", startNumber, endNumber);
                            System.out.printf("length:%d", endNumber - startNumber + 1);
                            System.out.println("");

                            if (startVal == (int) 'A') {
                                getNumber -= 1;
                            } else if (startVal == (int) 'B') {
                                getNumber -= 2;
                            } else if (startVal == (int) 'C') {
                                getNumber -= 4;
                            }

                            startNumber = secondNumber;
                            startVal = secondVal;

                            secondNumber = i + 1;
                            secondVal = (int) 'B';

                        } else {
                            getNumber += 1;
                            secondNumber = i + 1;
                            secondVal = (int) 'A';
                        }
                        continue;
                    } else {
                        continue;
                    }
                case (int) 'B':
                    if (getNumber == 0 || getNumber == 1 || getNumber == 4 || getNumber == 5) {
                        if (startNumber == 0) {
                            getNumber += 1;
                            startNumber = i + 1;
                            startVal = (int) 'B';
                        } else if (getNumber == 5) {
                            endNumber = i + 1;
                            getNumber += 2;
                            System.out.printf("start:%d,end:%d,", startNumber, endNumber);
                            System.out.printf("length:%d", endNumber - startNumber + 1);
                            System.out.println("");

                            if (startVal == (int) 'A') {
                                getNumber -= 1;
                            } else if (startVal == (int) 'B') {
                                getNumber -= 2;
                            } else if (startVal == (int) 'C') {
                                getNumber -= 4;
                            }

                            startNumber = secondNumber;
                            startVal = secondVal;

                            secondNumber = i + 1;
                            secondVal = (int) 'B';


                        } else {
                            getNumber += 2;
                            secondNumber = i + 1;
                            secondVal = (int) 'B';
                        }
                        continue;
                    } else {
                        continue;
                    }
                case (int) 'C':
                    if (getNumber == 0 || getNumber == 1 || getNumber == 2 || getNumber == 3) {
                        if (startNumber == 0) {
                            getNumber += 1;
                            startNumber = i + 1;
                            startVal = (int) 'C';
                        } else if (getNumber == 3) {
                            endNumber = i + 1;
                            getNumber += 4;
                            System.out.printf("start:%d,end:%d,", startNumber, endNumber);
                            System.out.printf("length:%d", endNumber - startNumber + 1);
                            System.out.println("");

                            if (startVal == (int) 'A') {
                                getNumber -= 1;
                            } else if (startVal == (int) 'B') {
                                getNumber -= 2;
                            } else if (startVal == (int) 'C') {
                                getNumber -= 4;
                            }

                            startNumber = secondNumber;
                            startVal = secondVal;

                            secondNumber = i + 1;
                            secondVal = (int) 'B';
                        } else {
                            getNumber += 4;
                            secondNumber = i + 1;
                            secondVal = (int) 'C';
                        }
                        continue;
                    } else {
                        continue;
                    }
                default:
                    continue;
            }
        }

//        if(getNumber == 7){
//            System.out.printf("start:%d,end:%d",startNumber,endNumber);
//            System.out.printf("length:%d", endNumber - startNumber + 1);
//        }
    }


}

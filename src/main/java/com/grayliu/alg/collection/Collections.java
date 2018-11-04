package com.grayliu.alg.collection;

import java.io.File;
import java.util.*;

public class Collections {

    static String dirPath = "D:\\SVN\\gome-member\\branches";


    public static void main(String[] args) {

        File projectDir = new File(dirPath);


//        if(projectDir.isDirectory()){
//            File[] subDirArray = projectDir.listFiles();
//            for(File file : subDirArray){
//                File[] subFileArray = file.listFiles();
//                boolean isPomPath = false;
//                for (File subFile : subFileArray){
//                    if("pom.xml".equals(subFile.getName())){
//                        System.out.println(subFile.getParentFile().getAbsoluteFile().toString());
//                        isPomPath = true;
//                    }
//                }
//                if(!isPomPath){
//                    for(File subFile : subFileArray){
//                        System.out.println(subFile.getAbsoluteFile().toString());
//                    }
//                }
//            }
//        }


        Integer[] i = {1, 2, 3, 4, 5};
        List<Integer> l = new ArrayList<Integer>();
        java.util.Collections.addAll(l, i);

        Iterator<Integer> iterator = l.iterator();
        while (iterator.hasNext()) {
            Integer a = iterator.next();
            System.out.println(a);
            iterator.remove();
        }


    }
}

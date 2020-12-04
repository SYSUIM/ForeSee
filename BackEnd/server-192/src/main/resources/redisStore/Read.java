package com.example.rwredis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Read{
    static String query = new String("新冠");
    static Data[] d = new Data[4222];   //创建实体类Data的数组d，大小为1175
    static int k=0;
    /*
    * readDB()方法，从csv文件中读取需要存入Redis中的数值
    * 返回值是Data实体类的数组，即存入要保存的相应数值之后的Data数组
     */
    public static Data[] readDB() throws Exception {
//        File[] f = new File[3];     //File类型的数组f存放需要进行存储的csv文件集合
//        f[0] = new File("./src/main/resources/hot_xinguan_1.csv");
//        f[1] = new File("./src/main/resources/hot_xinguan_2.csv");
//        f[2] = new File("./src/main/resources/hot_xinguan_3.csv");
//        for(int j=0;j<=2;j++)   //for循环将f数组中的所有csv中的数据相应的字段以Data类的实例形式存入Data类型的数组d中
//        {
//            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(f[j])));   //获取流对象
//            String record;
//            record = bf.readLine();     //读取csv文件中每行的数据存入record
//
//            int i = 0;
//            while(record != null){
//                //校验record也就是每行的数据是否满足要求
//                if(record.indexOf(',')>=0) {
//                    String[] cells = record.split(",");     //将字符串的数据以","切割，存入cells数组中
//                    if (isQuery(cells[3])) {
//                        d[k] = new Data(cells[3], cells[2], i);     //以切割后cells数组中的第四项和第三项以及行数构造Data类实例
//                        i++;
//                        k++;
//                    }
//                }
//                record = bf.readLine();
//            }
//        }
//        return d;
        File f = new File("./src/main/resources/CompanyIndex.csv");
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream((f))));
        String record;
        record = bf.readLine();     //读取csv文件中每行的数据存入record
        while (record != null) {
            //校验record也就是每行的数据是否满足要求
            if (record.indexOf(',') >= 0) {
                String[] cells = record.split(",");     //将字符串的数据以","切割，存入cells数组中
                d[k] = new Data(cells[2], cells[3], cells[5],cells[1],cells[0]);     //以切割后cells数组中的第四项和第三项以及行数构造Data类实例
                k++;
            }
            record = bf.readLine();
        }
        return d;
    }

    /*
    方法isQuery判断参数中的字符串str是否属于检索词
     */
}

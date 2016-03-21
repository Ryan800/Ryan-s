package com.ryan.wangbw.io;

/**
 * author: wangbw
 * Date: 2015-12-07
 * Time: 16:31
 * Desc:
 */
public class Test {

    public static void main(String[] args) {
        char c = '中';
        System.out.println((int)c);
        System.out.println((char)((int)c));
//        char[] buffer = new char[512];
//        int numberRead = 0;
//        FileReader reader = null;
//        PrintWriter writer = null;
//
//        try {
//            reader = new FileReader("D:/files/copy1.txt");
//            writer = new PrintWriter(System.out);
//            while ((numberRead =reader.read(buffer))!=-1) {
//                writer.write(buffer, 0, numberRead);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (reader!=null)
//                    reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (writer!=null) {
//                writer.close();
//            }
//        }

    }
}

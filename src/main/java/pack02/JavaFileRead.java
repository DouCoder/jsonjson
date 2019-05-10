package pack02;

import java.io.BufferedReader;
import java.io.FileReader;

public class JavaFileRead {
    public static String javaFileRead(String filePathAndName) {
        String str = new String();
        StringBuffer sb = new StringBuffer();
        try {
            // read file content from file

            FileReader reader = new FileReader(filePathAndName);
            BufferedReader br = new BufferedReader(reader);
            while ((str = br.readLine()) != null) {
                sb.append(str);
//                System.out.println(str);
            }
            br.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
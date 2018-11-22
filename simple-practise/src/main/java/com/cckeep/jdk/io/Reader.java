package com.cckeep.jdk.io;

import com.google.common.collect.Sets;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>TODO</p>
 *
 * @author jixd
 * @Date Created in 2018年11月22日 11:08
 */
public class Reader {

    public static void main(String[] args) throws IOException {

        Set<String> set1 = getSet("D://ver1.txt");
        System.out.printf("count=%d",set1.size());
        Set<String> set2 = getSet("D://ver2.txt");
        System.out.printf("count=%d",set2.size());

        set2.removeAll(set1);
       /* Sets.SetView<String> intersection = Sets.intersection(set1, set2);
        HashSet<String> set3 = Sets.newHashSet();
        for (String str : intersection){
            set3.add(str);
        }

        set2.removeAll(set3);*/

        //System.out.printf("/n处理后count=%d",set2.size());
        String template = "INSERT INTO `t_sensitive_word`( `fid`, `sensitive_word_type`, `content`, `sensitive_word_status`) VALUES ('%s', 1, '%s', 1)";

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D://out.sql"));
        BufferedWriter bw = new BufferedWriter(osw);

        for (String sql : set2){
            bw.write(String.format(template,UUIDGenerator.hexUUID(),sql)+";\n");
        }
        bw.flush();

    }

    public static Set<String> getSet(String path) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        HashSet<String> set = Sets.newHashSet();
        String line1 = "";
        while ((line1 = br.readLine()) != null){
            //System.out.println(line1);
            if (line1!= ""){
                if (line1.contains("|")){
                    line1 = line1.substring(0,line1.indexOf("|"));
                }
                for (int i = 0; i < line1.length();i++){
                    char a = line1.charAt(i);
                    if (!((a >='1' && a<='9') || (a >= 'a' && a <= 'z'))){
                        set.add(line1.trim());
                        break;
                    }
                }

            }
        }
        br.close();
        return set;
    }


}

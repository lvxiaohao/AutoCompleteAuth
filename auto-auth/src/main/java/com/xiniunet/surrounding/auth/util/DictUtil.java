package com.xiniunet.surrounding.auth.util;

import com.xiniunet.surrounding.auth.constans.Constants;
import com.xiniunet.surrounding.auth.domain.Dict;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Created on 2015-05-13.
 * AutoCompleteAuth
 *
 * @author 小昊
 * @since 1.0.0
 */
public class DictUtil {

    private static Properties holder;

    public static String getValue(Dict dict, String key) {
        if(DictUtil.holder == null) {
            try {
                DictUtil.holder = readProperties();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        Object o = holder.get(key);
        if(o == null) {
            dict.addWord(key);
            return key;
        }
        String s = (String)o;
        if(s.isEmpty()) {
            return key;
        } else {
            return s;
        }
    }

    public static Properties readProperties() throws IOException {
        InputStream stream = DictUtil.class.getResourceAsStream(Constants.DICT_FILE_READ_PATH);
        BufferedReader bf = new BufferedReader(new InputStreamReader(stream, "utf-8"));
        Properties prop = new Properties();
        prop.load(bf);
        return prop;
    }

    public static void saveProperties(Dict dict) throws IOException {
        Map<String, String> map = new TreeMap<>();
        for(String s :dict.getDict()) {
            map.put(s, "");
        }
        Properties properties = new Properties();
        properties.putAll(map);

        FileOutputStream outputFile = new FileOutputStream(Constants.DICT_FILE_WRITE_PATH);
        properties.store(outputFile, "not contained these words in " + Constants.DICT_FILE_READ_PATH);
        outputFile.close();
    }
}

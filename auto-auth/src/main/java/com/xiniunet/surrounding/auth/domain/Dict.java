package com.xiniunet.surrounding.auth.domain;

import java.util.*;

/**
 * Created on 2015-05-11.
 * AutoCompleteAuth
 *
 * @author 小昊
 * @since 1.0.0
 */
public class Dict {

    /**
     * 页面名称中出现的单词.
     */
    private Set<String> dict;

    public Dict() {
        dict = new TreeSet<>();
    }

    public Set<String> getDict() {
        return dict;
    }

    /**
     * 添加一个生词
     * @param word
     */
    public void addWord(String word) {
        dict.add(word);
    }
}

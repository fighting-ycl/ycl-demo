package com.personal.common.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/**
 * @author : YangChunLong
 * @date : Created in 2019/11/25 22:59
 * @description: 布隆过滤器
 * @modified By:
 * @version: :
 */
public class BloomFilterUtil {
    private final BloomFilter<String> bloomFilter = BloomFilter.create(new Funnel<String>() {
        @Override
        public void funnel(String from, PrimitiveSink into) {
            into.putString(from, Charsets.UTF_8);
        }
    },1024*1024*32);


}

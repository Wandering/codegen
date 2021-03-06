package cn.org.rapid_framework.generator.provider.db.table.model.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO 一句话描述该类用途
 * <p/>
 * 创建时间: 14-9-30 下午10:26<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public class SeqGen {
    private final static Map<String, AtomicInteger> seqGenMap = new HashMap<String, AtomicInteger>();
    public final static String MODEL = "model";
    public final static String PARENT_RES = "parent_res";

    public synchronized static int incr(String key){
        AtomicInteger gen = seqGenMap.get(key);
        if(gen == null){
            gen = new AtomicInteger(0);
            seqGenMap.put(key, gen);
        }
        return gen.incrementAndGet();
    }
}

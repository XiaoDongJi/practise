package com.cckeep.jdk.classloader;

/**
 * <p>TODO</p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author jixd
 * @version 1.0
 * @Date Created in 2018年04月10日 20:24
 * @since 1.0
 */
public class ByteTest {
    static final short    MAGIC  = (short) 0xdabb;

    public static void main(String[] args) {

        System.out.println((byte)MAGIC);
        System.out.println(0xdabb);
        System.out.println((byte)(MAGIC >>> 8));
    }
}


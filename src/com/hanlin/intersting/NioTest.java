package com.hanlin.intersting;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NioTest {

    public static void main(String[] args) throws CharacterCodingException {
        Charset c = Charset.forName("UTF-8");
        CharsetEncoder e = c.newEncoder();  //获取编码器
        CharsetDecoder d = c.newDecoder();  //获取解码器
        CharBuffer buf = CharBuffer.allocate(1024);
        buf.put("二狗子到此一游");
        buf.flip();
        ByteBuffer bBuf = e.encode(buf);//编码
        bBuf.flip();                     //解码
        CharBuffer buf2= d.decode(bBuf);
        System.out.println(buf2.toString());
    }
}

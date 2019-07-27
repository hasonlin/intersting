package com.hanlin.intersting;

import com.sun.deploy.net.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by admin on 2018/5/16 0016.
 */
public class HtmlTest {
    public static String getHtmlResourseByUrl(String url,String encoding){
        URL urlObj = null;
        URLConnection urlConnection = null;
        InputStreamReader isr = null;
        BufferedReader bufferedReader;
        StringBuffer buffer = new StringBuffer();
        try {
            urlObj = new URL(url);
            urlConnection = urlObj.openConnection();
            isr = new InputStreamReader(urlConnection.getInputStream(),encoding);
            bufferedReader = new BufferedReader(isr);
            String temp = null;
            while ((temp=bufferedReader.readLine())!=null){
                buffer.append(temp+"\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("网络连接不上；");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("打开网络失败；");
        }finally {
            if(null!=isr){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
       String url = "https://www.taobao.com";
       String encoding = "utf-8";
       String html = getHtmlResourseByUrl(url,encoding);
//        System.out.println(html);

        //解析源代码
        Document document = Jsoup.parse(html);
        //获取图片地址
        Elements elements = document.getElementsByTag("img");
        for (Element element:elements) {
            String src = element.attr("src");
            if(!"".equals(src)){
                System.out.println("========正在批量下载图片============");
                System.out.println(src);
                download("http:"+src);
            }
        }
    }

    public static void download(String path){
        int bytesum = 0;
        int byteread = 0;

        URL url;
        URLConnection connection;
        InputStream inputStream = null;
        File dir;
        File file;
        FileOutputStream fos =null;
        try {
            url = new URL(path);
            connection = url.openConnection();
            inputStream = connection.getInputStream();
            dir = new File("D:/编程/Project/intersting/picture");
            file = new File(dir,path.substring(path.lastIndexOf("/")));
            fos = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            while ((byteread = inputStream.read(buffer))!=-1){
                bytesum =+ byteread;
                fos.write(buffer,0,byteread);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("打开网络失败；");
        }finally {
            if(null!=fos){
                try {
                    inputStream.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

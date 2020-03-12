package com.yc.api.d0312;
import java.io.*;
import java.nio.file.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//请根据要求完成如下操作:
//        1 在控制台输出 D:\ 目录下所有文件和目录       (完成)
//        2 创建文件夹 myfiles                         (完成)
//        3 在 myfiles 文件夹中创建以下文件 注意,如果文件已经存在,需要提示用户该文件已经存在:
//        readme.txt
//        info.txt test.ini tools.txt students.ini baidu.inf taobao.inf helloworld.java
//        head.jpg red.gif green.bmp                   (完成)
//        5 过滤查询所有的 txt 文件                     (未完成)
//        6 修改所有的图片文件,将文件名前面加入" 图片"   (完成)
//        https://cloud.tencent.com/developer/article/1195478
//        7 删除所有以字母 t 开头文件
//        https://cloud.tencent.com/developer/article/1195478   (完成)
//        8 在 readme.txt 文件中,使用流写入一首唐诗              (完成)
//        9 使用流将 readme.txt 的内容读取出来, 并输出到控制台上  (完成)
public class Main {
    public static void main(String[] args)  {
        File file=new File("d:\\");
        File[] fs1 = file.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        if(!file.exists()){//如果文件夹不存在
            file.mkdir();//创建文件夹
        }else {
            System.out.println(file.getName() + " 该文件已经存在");
        }

        //一键整出要求文件 3 在 myfiles 文件夹中创建以下文件
        String[] str = new String[]{"readme.txt","info.txt","test.ini","tools.txt","students.ini"
                ,"baidu.inf",
                "helloworld.java","head.jpg","red.gif","green.bmp","taobao.inf"};
        //        System.out.println(str.length);
        for (int i = 0; i < str.length; i++){
            files(str[i]);
        }
        //  5 过滤查询所有的 txt 文件
        System.out.println("========================");
        File file05=new File("d:\\myfiles");
        FilenameFilter txtFilter = new TxtFilenameFilter();
        String[] list05 = file.list(txtFilter);
        //String[] txtFilters =file.list(txtFilter);
        file.list(txtFilter);
        for (String filename : list05) {
            System.out.println(filename);
        }
        //删除所有以字母 t 开头文件
        for (int i = 0; i < str.length; i++){
            if (str[i].substring(0,1).equals("t")){
                delFolder(str[i]);
            }
        }

        System.out.println("删除成功");
        System.out.println("========================");
        //8 在 readme.txt 文件中,使用流写入一首唐诗
        writer("readme.txt","床前明月光，疑是地上霜\n" +
                "举头望明月，低头思故乡。");
        //9 使用流将 readme.txt 的内容读取出来, 并输出到控制台上
        try{
            Files.copy(Paths.get("d:\\myfiles","readme.txt"),System.out);
        }catch(Exception xe){
            System.out.println(xe.getMessage());
        }

        //6.
        ChangeFilter();
       new FileFilter();
        
    }
    //1 在控制台输出 D:\ 目录下所有文件和目录
    private static void printFiles(File[] fs1) {
        System.out.println("====================");
        if (fs1 != null) {
            for (File f : fs1) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
    /*
    创建文件
     */
    public static void files(String name) {
        File dir=new File("d:\\myfiles");
        File file = new File(dir, name);
        if (!file.exists()) {
            try {
                // 创建新文件
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创建新文件时出现了错误。。。");
                e.printStackTrace();
            }
        }else {
            System.out.println(file.getName() + " 该文件已经存在");
        }
    }
    /**！！！！！！！！！！！！！！
     * 老师看这里，看这里，这里
     *  过滤查询所有的 txt 文件  ctrl + f
     *  
     *  new  TxtFilenameFilter()
     */

    static class  TxtFilenameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            if(name.endsWith(".txt"))
                return true;
            return false;
        }
    }
    /**
     * 删除文件夹
     * @param name 文件名
     */
    public static void delFolder(String name) {
        try {
            File dir=new File("d:\\myfiles");
            File file = new File(dir, name);
            file.delete();
            //删除文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param filename 文件名
     * @param poetry 唐诗
     */
    public static void writer(String filename ,String poetry){
        File dir=new File("d:\\myfiles");
        File file = new File(dir, filename);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(poetry);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw != null) {
                try{
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void change(String newFileName){
        File dir=new File("d:\\myfiles");
        // File file = new File(dir, filename);
        FilenameFilter filter = new TuFilenameFilter();//使用内部类来实现接口
        String [] filess = dir.list(filter);
        File [] file = new File[filess.length];
        for (int i = 0; i < filess.length; i++){
            file[i] = new File(dir,filess[i]);
            System.out.println(file[i].getAbsolutePath());
        }
    }
    static class  TuFilenameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith("jpg")||name.endsWith("gif")||name.endsWith("bmp");
        }
    }
    /**
     * 通过文件路径直接修改文件名
     *
     * @param filePath    需要修改的文件的完整路径
     * @param newFileName 需要修改的文件的名称
     */
    private static String FixFileName(String filePath, String newFileName) {
        File f = new File(filePath);
        if (!f.exists()) { // 判断原文件是否存在（防止文件名冲突）
            return null;
        }
        newFileName = newFileName.trim();
        if ("".equals(newFileName) || newFileName == null) // 文件名不能为空
            return null;
        String newFilePath = null;
        if (f.isDirectory()) { // 判断是否为文件夹
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName;
        } else {
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName
                    + filePath.substring(filePath.lastIndexOf("."));
        }
        File nf = new File(newFilePath);
        try {
            f.renameTo(nf); // 修改文件名
        } catch (Exception err) {
            err.printStackTrace();
            return null;
        }
        return newFilePath;
    }

    static class JpFilenameFilter implements FilenameFilter{
        private String extent;
        JpFilenameFilter(String extent){
            this.extent = extent;
        }
        @Override
        public boolean accept(File dir, String name) {
            // TODO Auto-generated method stub
            return name.endsWith(extent);
        }
    }
    public static void ChangeFilter() {
        File dir=new File("d:\\myfiles");
        FilenameFilter filter= new JpFilenameFilter("jpg");
        File[] file= dir.listFiles(filter);
        if(file!=null)
            for(File f:file) {
                System.out.println("==========图片==========");
                String tep=f.getName();
                tep="图片"+tep;
                System.out.println(f);
            }

    }

    static class FileFilter implements FilenameFilter{
        @Override
        public boolean accept(File dir, String name) {
            //String的 endsWith(String str)方法
            //筛选出以str结尾的字符串
            if(name.endsWith(".jpg"))
                System.out.println("=================图片的添加==========");
                System.out.println("图片"+name);
                return true;
            //return false;
        }
    }
}







package com.ccms.util;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Abel
 */
@SuppressWarnings("ALL")
public class ReadProperties {

    private static Map<String, ResourceBundle> map = new HashMap<String, ResourceBundle>();
    private static ReadProperties readProperties = null;
    private static Map<String, Properties> mapJars = new HashMap<String, Properties>();
    private ResourceBundle bundle = null;

    /**
     * @param sourceFile
     * @return
     */
    public static ReadProperties getInst(String sourceFile) {
        if (readProperties == null) {
            readProperties = new ReadProperties();
        }
        if (!map.containsKey(sourceFile)) {
            ResourceBundle bundle = ResourceBundle.getBundle(sourceFile);
            map.put(sourceFile, bundle);
        }
        return readProperties;
    }

    /**
     * @param sourceFile
     * @return
     */
    public static ReadProperties getInst(String sourceFile, Locale locale) {
        if (locale == null) {
            return getInst(sourceFile);
        }
        if (readProperties == null) {
            readProperties = new ReadProperties();
        }
        if (!map.containsKey(sourceFile + "_" + locale.toString())) {
            ResourceBundle bundle = ResourceBundle.getBundle(sourceFile);
            map.put(sourceFile + "_" + locale.toString(), bundle);
        }
        return readProperties;
    }

    /**
     * @param s
     * @param class1
     * @return
     */
    public static Image getImageFromJar(String s, Class class1) {
        Image image = null;
        InputStream inputstream = class1.getResourceAsStream(s);
        if (inputstream != null) {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            try {
                byte[] abyte0 = new byte[1024];
                for (int i = 0; (i = inputstream.read(abyte0)) >= 0; ) {
                    bytearrayoutputstream.write(abyte0, 0, i);
                }

                image = Toolkit.getDefaultToolkit().createImage(bytearrayoutputstream.toByteArray());
            } catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        }
        return image;
    }

    /**
     * @param s
     * @param class1
     * @return
     */
    public static String getTextFromJar(String s, Class class1) {
        StringBuilder s1 = new StringBuilder();
        InputStream inputstream = class1.getResourceAsStream(s);
        if (inputstream != null) {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            String s2;
            try {
                while ((s2 = bufferedreader.readLine()) != null) {
                    s1 = s1.append(s2).append("\n");
                }
            } catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        }
        return s1.toString();
    }

    public static String getValueFromJar(String libLocation, String jarFilePath, String filePath, String key) {
        if (jarFilePath == null || filePath == null || key == null) {
            return "";
        }
        String[] classpathArray = getAllLibName(libLocation);
        if (classpathArray == null) {
            return "";
        }

        Properties properties = null;
        String mapKey = jarFilePath + "_" + filePath;
        if (mapJars.containsKey(mapKey)) {
            properties = mapJars.get(mapJars);
        } else {
            try {
                properties = putToMap(libLocation, jarFilePath, filePath);
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        if (properties == null) {
            return null;
        }
        return properties.getProperty(key);
    }

    /**
     * @param jarFilePath
     * @param filePath
     * @return
     * @throws IOException
     * @throws IOException
     */
    private static Properties putToMap(String libLocation, String jarFilePath, String filePath) throws IOException {
        Properties properties = null;
        InputStream input = null;
        JarFile jarFile = null;
        String[] classpathArray = getAllLibName(libLocation);
        try {
            for (String tmp : classpathArray) {
                if (tmp.indexOf(jarFilePath) > -1) {
                    jarFilePath = tmp;
                }
            }
            jarFile = new JarFile(jarFilePath);
            JarEntry entry = jarFile.getJarEntry(filePath);
            input = jarFile.getInputStream(entry);
            properties = new Properties();
            properties.load(input);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                throw e;
            }
            try {
                jarFile.close();
            } catch (IOException e) {
                throw e;
            }
        }
        mapJars.put(jarFilePath + "_" + filePath, properties);
        return properties;
    }

    public static String[] getAllLibName(String path) {
        String classpath = getRealPath(ReadProperties.class, path, path);
        File file = new File(classpath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            String[] xxs = new String[files.length];
            int i = 0;
            for (File f : files) {
                xxs[i] = f.getName();
                System.out.println(xxs[i]);
                i++;
            }
            return xxs;
        }
        return null;
    }

    /**
     * Get real path according current path.
     *
     * @param clz
     * @param cutPath
     * @param makePath
     * @return RealPath
     * @throws Exception
     */
    public static String getRealPath(Class clz, String cutPath, String makePath) {
        try {
            Class clzObj = clz.newInstance().getClass();
            String strClassName = clzObj.getName();
            String strClassFileName = strClassName.substring(strClassName.lastIndexOf(".") + 1, strClassName.length());
            URL url;
            url = clzObj.getResource(strClassFileName + ".class");
            String strURL = url.toString();

            strURL = strURL.substring(strURL.indexOf("/") + 1);

            if (cutPath == null || "".equals(cutPath)) {
                strURL = strURL.substring(0, strURL.lastIndexOf("/") + 1);
            } else {
                strURL = strURL.substring(0, strURL.lastIndexOf(cutPath));
            }

            if (makePath != null && !"".equals(makePath)) {
                strURL = strURL + makePath + "/";
            }

            File file = new File(strURL);
            if (!file.exists()) {
                file.mkdirs();
            }
            return strURL;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {

        ReadProperties bizRp = ReadProperties.getInst("biz");

        String a = bizRp.getValuesByKey("biz", "abc");

        Locale locale = new Locale("zh", "CN");
        Locale locale1 = Locale.CHINA;
        Locale locale2 = Locale.CHINESE;
        Locale locale3 = Locale.US;
        Locale locale4 = Locale.SIMPLIFIED_CHINESE;
        Locale locale5 = Locale.TRADITIONAL_CHINESE;
        System.out.println(locale.toString());
        System.out.println(locale1.toString());
        System.out.println(locale2.toString());
        System.out.println(locale3.toString());
        System.out.println(locale4.toString());
        System.out.println(locale5.toString());

        String s1 = "1";
        String s2 = "2";
        String s3 = "1";

        System.out.println("tttt=" + (!s1.equals(s2) && !s1.equals(s3)));
    }

    /**
     * @param sourceFile
     * @param key
     * @return
     */
    public String getLocaleValuesByKey(String sourceFile, String key, Locale locale) {
        if (locale == null) {
            return getValuesByKey(sourceFile, key);
        }
        bundle = map.get(sourceFile + "_" + locale.toString());
        if (bundle == null) {
            return "";
        }
        return bundle.getString(key);
    }

    /**
     * @param sourceFile
     * @param key
     * @return
     */
    public String getValuesByKey(String sourceFile, String key) {
        bundle = map.get(sourceFile);
        if (bundle == null) {
            return "";
        }
        return bundle.getString(key);
    }

}

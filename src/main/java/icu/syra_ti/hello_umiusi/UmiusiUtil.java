package icu.syra_ti.hello_umiusi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class UmiusiUtil {
    public static String getConfig(String key){
        try {
            // 创建 Gson 实例
            Gson gson = new Gson();

            // 读取 JSON 文件
            FileReader reader = new FileReader(UmiusiUtil.getResourceDir() + "/config.json");

            // 解析 JSON 为 JsonObject
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // 获取某个 key 的值
            String value = jsonObject.get(key).getAsString();


            // 关闭文件读取器
            reader.close();
            return value;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getPlatformArch(){
        return System.getProperty("os.arch");
    }
    public static String getResourceDir() {
        String runningJarFile = null;
        try {
            String path = UmiusiUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            File file = new File(path);
            runningJarFile = file.isFile() ? file.getAbsolutePath() : null;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            runningJarFile = null;
        }
        // 开发阶段
        if (runningJarFile == null) {
            return System.getProperty("user.dir") + "/src/main/public";
        }
        else {
            return System.getProperty("user.dir") + "/.hello-umiusi";
        }
    }

    public static void main(String[] args) {
        System.out.println(UmiusiUtil.getPlatformArch());
    }
}

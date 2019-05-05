package top.musuixin.Util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * 上传文件工具类
 *
 * @author musuixin
 */
public class Upload {

    /**
     * 上传文件
     *
     * @param request
     * @param response
     * @param serverPath
     * @param path
     * @return
     */
    public static String upload(Client client, MultipartFile file, HttpServletRequest request, HttpServletResponse response, String serverPath, String path) {
        // 文件名称生成策略（日期时间+uuid ）
        UUID uuid = UUID.randomUUID();
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatDate = format.format(d);
        // 获取文件的扩展名
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        // 文件名
        String fileName = formatDate + "-" + uuid + "." + extension;
        //相对路径
        String relaPath = path + fileName;

        String a = serverPath + path.substring(0, path.lastIndexOf("/"));
        File file2 = new File(a);
        if (!file2.exists()) {
            boolean mkdirs = file2.mkdirs();
        }

        // 另一台tomcat的URL（真实路径）
        String realPath = serverPath + relaPath;
        // 设置请求路径
        WebResource resource = client.resource(realPath);

        // 发送开始post get put（基于put提交）
        try {
            resource.put(String.class, file.getBytes());
            return fileName + ";" + relaPath + ";" + realPath;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
package managers;

import constants.WebsiteConstants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
    public void fileDownload(String filePath, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        File file = new File(filePath);
        String fileName = file.getName();
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.addHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
        FileInputStream fileInputStream = new FileInputStream(file);
        int i = 0;
        while((i=fileInputStream.read())!=-1){
            out.write(i);
        }
    }

    public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        Part filePart = request.getPart("file");
        String fileName = filePart.getName();
        File file = new File(WebsiteConstants.UPLOAD_PATH+"/"+fileName);
        if(!file.exists()){
            file.createNewFile();
        }
        filePart.write(file.getAbsolutePath());
    }

    public void fileUpload(String uploadsPath, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        Part filePart = request.getPart("file");
        String fileName = filePart.getName();
        File file = new File(uploadsPath+"/"+fileName);
        if(!file.exists()){
            file.createNewFile();
        }
        filePart.write(file.getAbsolutePath());
    }
}
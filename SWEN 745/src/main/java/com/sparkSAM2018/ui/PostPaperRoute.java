package com.sparkSAM2018.ui;

import com.sparkSAM2018.Application;
import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Author;
import com.sparkSAM2018.model.Paper;

import spark.*;
import spark.utils.IOUtils;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PostPaperRoute implements TemplateViewRoute{

    private final SAMCenter samCenter;

    public PostPaperRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        File directory = new File("UploadedPapers");
        directory.mkdir();

        try {
            //request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/Uploaded Papers"));
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/UploadedPapers"));

            Part uploadedFile = request.raw().getPart("uploaded_file");
            Part author = request.raw().getPart("authorName");
            Part title = request.raw().getPart("title");
            Part vers = request.raw().getPart("version");

            String author_name = IOUtils.toString(author.getInputStream());
            String paper_title = IOUtils.toString(title.getInputStream());
            int version = Integer.parseInt(IOUtils.toString(vers.getInputStream()));

            try (InputStream in = uploadedFile.getInputStream()) {
                OutputStream outputStream = new FileOutputStream("" + Application.pathReference + "\\UploadedPapers\\" + getSubmittedFileName(uploadedFile));
                IOUtils.copy(in, outputStream);
                outputStream.close();
            }
            samCenter.getSubmittedPapers().add(new Paper(new Author(author_name),paper_title,version,uploadedFile));
            vm.put("paperSubmissionMessage", "You have successfully uploaded a submission for review!");
        }
        catch (IOException e) {
            System.out.println("IOException");
        }
        catch (ServletException e) {
            System.out.println("Servlet Exception");
        }

        return new ModelAndView(vm,"submitPaper.ftl");
    }

    public static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }
}

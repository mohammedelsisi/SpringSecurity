package org.controller;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.*;

@Controller
public class Upload {
    @SneakyThrows
    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
    public String upload(@RequestPart("userPhoto") Part photo, Model model) {
        photo.write("F:/ServerFiles/" + photo.getSubmittedFileName());
        model.addAttribute("msg", "Photo was uploaded");
        return "StaticPage";
    }







//    @SneakyThrows
//    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
//    public String upload(@RequestParam("userPhoto") MultipartFile photo, Model model) {
//        if (!photo.isEmpty()) {
//            InputStream initialStream = photo.getInputStream();
//            byte[] buffer = new byte[initialStream.available()];
//            initialStream.read(buffer);
//            File targetFile = new File("F:/ServerFiles/" + photo.getOriginalFilename());
//            @Cleanup
//            OutputStream outStream = new FileOutputStream(targetFile);
//            outStream.write(buffer);
//        }
//        model.addAttribute("msg", "Photo was uploaded");
//        return "StaticPage";
//    }
//
}



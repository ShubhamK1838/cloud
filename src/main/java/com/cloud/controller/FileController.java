package com.cloud.controller;

import com.cloud.model.entity.File;
import com.cloud.model.entity.User;
import com.cloud.model.handler.FileHandler;
import com.cloud.model.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class FileController {

    @Autowired
    private FileService service;

    @PostMapping("/file")
    public String upload(@RequestParam("file") MultipartFile part, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        File file = FileHandler.getEntityFile(part,user);
        service.save(file);

        return "redirect:/upload";
    }

    @RequestMapping("/myfiles")
    public String myFiles(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<File> files = service.getUserFiles(user);

        model.addAttribute("userFiles", files);

        return "myfiles";

    }

    @RequestMapping("/file/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        boolean rst = service.delete(id);
        if (rst) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

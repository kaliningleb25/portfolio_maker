package com.kaliningleb25.portfolio_maker.controller;

import com.kaliningleb25.portfolio_maker.entity.Folder;
import com.kaliningleb25.portfolio_maker.service.FolderService;
import com.kaliningleb25.portfolio_maker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    FolderService folderService;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());

        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/{user_nickname}")
    public String showFolders(@PathVariable("user_nickname") String userNickname, Model model) {
        List<Folder> folderList = folderService.findFolders(userNickname);

        model.addAttribute("folders", folderList);
        model.addAttribute("userNickname", userNickname);

        return "portfolio_first_page";
    }

    @GetMapping("/{user_nickname}")
    public String showPictures(@PathVariable("user_nickname") String userNickname, @RequestParam("folder_id") int folderId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping(value="/folder")
    public String showImage(@RequestParam("id") int id, HttpServletResponse response) {
        Folder folder = folderService.findFolder(id);

        response.setContentType("image/jpeg; image/jpg; image/png; image/gif");
        try {
            response.getOutputStream().write(folder.getDataInBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        return "folder";
    }



}

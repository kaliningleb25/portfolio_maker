package com.kaliningleb25.portfolio_maker.controller;

import com.kaliningleb25.portfolio_maker.entity.Folder;
import com.kaliningleb25.portfolio_maker.entity.Picture;
import com.kaliningleb25.portfolio_maker.entity.User;
import com.kaliningleb25.portfolio_maker.service.FolderService;
import com.kaliningleb25.portfolio_maker.service.PictureService;
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

    @Autowired
    PictureService pictureService;

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
    public String showFolders(@PathVariable("user_nickname") String nickname, Model model) {
        List<Folder> folderList = folderService.findFolders(nickname);
        User user = userService.findUserByNickname(nickname);

        model.addAttribute("folders", folderList);
        model.addAttribute("user", user);

        return "portfolio_first_page";
    }

    @GetMapping("/{user_nickname}/picturesList")
    public String showPictures(@PathVariable("user_nickname") String nickname, @RequestParam("folder_id") Long folderId, Model model) {
        List<Picture> pictureList = pictureService.findPictures(folderId);
        User user = userService.findUserByNickname(nickname);

        model.addAttribute("pictures", pictureList);
        model.addAttribute("user", user);


        return "portfolio_second_page";
    }

    @GetMapping(value="/folder")
    public String showFolder(@RequestParam("id") Long id, HttpServletResponse response) {
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

    @GetMapping(value="/picture")
    public String showPicture(@RequestParam("id") Long id, HttpServletResponse response) {
        Picture picture = pictureService.findPicture(id);

        response.setContentType("image/jpeg; image/jpg; image/png; image/gif");
        try {
            response.getOutputStream().write(picture.getDataInBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "picture";
    }



}

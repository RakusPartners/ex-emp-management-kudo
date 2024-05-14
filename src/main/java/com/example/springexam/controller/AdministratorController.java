package com.example.springexam.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springexam.domain.Administrator;
import com.example.springexam.form.InsertAdministratorForm;
import com.example.springexam.form.LoginForm;
import com.example.springexam.service.AdministratorService;

/**
* Administratorのコントローラクラス
*
*/

@Controller
@RequestMapping("")
public class AdministratorController {
    
    @Autowired
    private AdministratorService administratorService;

    /**
     *  /toInsertのGetMapping
     *
     * @param Admin 管理者情報
     * @return insert.htmlにインサート
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }

    /**
     * 管理者情報を登録する
     *
     * @param Admin 管理者情報
     * @return /ログイン画面にリダイレクト
     */
    @PostMapping("/insert")
    public String indert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);
        administratorService.insert(administrator);
        return "redirect:/administrator/insert";

    }

    @GetMapping("/")
    public String toLogin(LoginForm form) {
        return "administrator/login";
    }

}

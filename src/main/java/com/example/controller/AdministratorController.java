package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.InsertAdministratorForm;
import com.example.service.AdministratorService;

/**
* Administratorのコントローラクラス
*
*/

@Controller
@RequestMapping("/")
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
        return "insert";
    }

}

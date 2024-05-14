package com.example.springexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springexam.domain.Administrator;
import com.example.springexam.repository.AdministratorRepository;

/**
 * 管理者のサービスクラス
 */

@Service
@Transactional
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * 管理者情報を挿⼊する
     *
     * @param Admin 管理者情報
     * @return なし
     */
    public void insert(Administrator administrator) {
        administratorRepository.insert(administrator);
    }

    
}

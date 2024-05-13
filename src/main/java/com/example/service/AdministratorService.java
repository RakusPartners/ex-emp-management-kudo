package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.AdoministratorRepository;

/**
 * 管理者のサービスクラス
 */

@Service
@Transactional
public class AdministratorService {

    @Autowired
    private AdoministratorRepository repository;

    
}

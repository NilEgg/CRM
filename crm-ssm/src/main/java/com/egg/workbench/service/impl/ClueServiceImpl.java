package com.egg.workbench.service.impl;

import com.egg.workbench.dao.ClueDao;
import com.egg.workbench.service.ClueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClueServiceImpl implements ClueService {

    @Resource
    private ClueDao clueDao;
}

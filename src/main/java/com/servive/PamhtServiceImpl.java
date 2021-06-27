package com.servive;

import com.dao.PamhtDao;
import com.entity.Pamht;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PamhtServiceImpl {
    @Autowired
    private PamhtDao pamhtDao;

    public Pamht findByidPamht(int id){
        return pamhtDao.findByidPamht(id);
    }

    public Pamht findByNamePamht(String name){
        return pamhtDao.findByNamePamht(name);
    }
}

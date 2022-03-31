package com.codegym.service.impl;

import com.codegym.service.ISettingMailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingEmailService implements ISettingMailService {
    static List<String> listLanguage = new ArrayList<>();
    static List<Integer> listPageSize = new ArrayList<>();

    static {
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");

        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);
    }

    @Override
    public List<String> listLanguage() {
        return listLanguage;
    }

    @Override
    public List<Integer> listPageSize() {
        return listPageSize;
    }
}

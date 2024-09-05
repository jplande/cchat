package com.incchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import com.incchat.FileWatcher;

import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;

@Controller
public class IndexController{

    @Inject
    FileWatcher directoryWatcher;

    @GetMapping("/")
    public String root() throws ParserConfigurationException, SAXException{
        String cheminRepertoire = "/home/hany/FAC/M1/S7/DDS/Projet/DDS";
        directoryWatcher.watchDirectory(cheminRepertoire);
        return "index";
    }
    
}

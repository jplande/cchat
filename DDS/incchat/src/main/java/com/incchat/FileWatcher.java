package com.incchat;
import java.io.IOException;
import java.nio.file.*;

import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import lombok.Data;


@Component
@Data
public class FileWatcher {

    // private Path directoryPath;
    // = Paths.get("/home/hany/FAC/M1/S7/DDS/Projet/DDS");

    @Inject
    XmlFileTreater parser;

    public void watchDirectory(String path) throws ParserConfigurationException, SAXException{
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path directoryPath = Path.of(path);

            directoryPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            while(true){
                WatchKey key = watchService.take();
                if(key != null){
                for(WatchEvent<?> event : key.pollEvents()){
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        System.out.println("Nouveau fichier créé : " + event.context());
                        String newFileName = event.context().toString();
                        String fullFilePath = directoryPath.resolve(newFileName).toString();
                        parser.xmlParser(fullFilePath);
                    }
                    key.reset();
                }
            }
        }    
    } 
    catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}
}

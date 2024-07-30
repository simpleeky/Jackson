package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlService<T> {
    private static final XmlMapper xmlMapper = new XmlMapper();

    public void writeXml(String fileName, List<T> t) throws IOException {
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(fileName), t);
    }

    public List<T> readXml(String fileName, Class<T> clas) throws IOException {
        File file = new File(fileName);
        return xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, clas));
    }
}


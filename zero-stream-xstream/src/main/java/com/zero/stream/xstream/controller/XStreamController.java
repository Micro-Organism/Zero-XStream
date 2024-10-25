package com.zero.stream.xstream.controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.zero.stream.xstream.domain.entity.SystemUserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xstream")
public class XStreamController {

    @RequestMapping(value = "/hello", produces = {"application/xml;"})
    public String showHelloWorld() {
        SystemUserEntity e1 = new SystemUserEntity("Rabbit", "Zero", 1000, 19, "Male");

        // Serializing a Java object into XML
        XStream xStream = new XStream(new DomDriver());
        // Converting it to XML
        return xStream.toXML(e1);
    }
}
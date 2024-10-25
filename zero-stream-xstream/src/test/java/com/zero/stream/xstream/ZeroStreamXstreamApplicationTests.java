package com.zero.stream.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.zero.stream.xstream.domain.entity.SystemUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZeroStreamXstreamApplicationTests {

    @Test
    void contextLoads() {
        // Initializing XStream with Dom driver
        XStream xStream = new XStream(new DomDriver());

        // We need to configure the security framework in
        // XStream, so it deserializes the object from the
        // XML
        xStream.allowTypes(new Class[]{SystemUserEntity.class});

        // Now, to make the XML outputted by XStream more
        // concise, you can create aliases for your custom
        // class names to XML element names. This is the
        // only type of mapping required to use XStream and
        // even this is optional.
        xStream.alias("SystemUserEntity", SystemUserEntity.class);

        SystemUserEntity e1 = new SystemUserEntity("Rabbit", "Zero", 1000, 19, "Male");

        // Serializing a Java object into XML
        String xml = xStream.toXML(e1); // Converting it to XML

        // Deserializing a Java object from XML
        SystemUserEntity SystemUserEntity = (SystemUserEntity) xStream.fromXML(xml);

        System.out.println("First name of SystemUserEntity:  " + SystemUserEntity.getFirstName());
        System.out.println("Last name of SystemUserEntity:   " + SystemUserEntity.getLastName());
        System.out.println("SystemUserEntity's age:          " + SystemUserEntity.getAge());
        System.out.println("SystemUserEntity's gender:       " + SystemUserEntity.getGender());
        System.out.println("SystemUserEntity's salary:       $" + SystemUserEntity.getSalary());
    }

}

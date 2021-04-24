package com.cvrest.cv.CV;

import com.cvrest.cv.home.HomeRepository;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

@Service
public class CVService {

    private CVRepository cvRepository;

    @Autowired
    public CVService(CVRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    public void addCv(String cv) {
        if (validateXSD(cv)) {
            System.out.println("C'est valide");
            String json = XML.toJSONObject(cv).toString();
            CV cvObj = new CV(Status.INSERTED, cv);
            cvRepository.insert(cvObj);
        } else {
            System.out.println("C'est pas valide");
        }
    }

    public static boolean validateXSD(String xml)
    {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("xsd/cv21.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(xml)));
        } catch (IOException e){
            System.out.println("Exception: "+e.getMessage());
            return false;
        }catch(SAXException e1){
            System.out.println("SAX Exception: "+e1.getMessage());
            return false;
        }

        return true;

    }
}

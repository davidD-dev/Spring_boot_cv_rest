package com.cvrest.cv.CurliculumVitae;

import org.json.JSONObject;
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
import java.io.StringReader;
import java.util.List;
import java.util.UUID;

@Service
public class CvService {

    private CvRepository cvRepository;

    @Autowired
    public CvService(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    public void addCv(String cv) {
        if (validateXSD(cv)) {
            System.out.println("C'est valide");
            Cv cvObj = new Cv(Status.INSERTED, cv);
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

    public String getById(String id) {
        String cv = cvRepository.getXmlById(id);
        System.out.println(cv);
        return new JSONObject(cv).get("cvXml").toString();
    }

    public ListCv getAllCustom() {
        List<String> wow = cvRepository.getAllXml();
        List<Cv> cvs = cvRepository.findAll();
        ListCv listCV = new ListCv(cvs);
        System.out.println(listCV.getElements());
//        List<String> cvList = new ArrayList<>();
//        for(String cv : cvs) {
//            cvList.add(new JSONObject(cv).get("cvXml").toString());
//        }
//        String allCV = String.join(" ", cvList);
//        System.out.println(cvs);
//        System.out.println(XML.toString(cvs.toString()));
//        return wow;
        return listCV;
    }
}

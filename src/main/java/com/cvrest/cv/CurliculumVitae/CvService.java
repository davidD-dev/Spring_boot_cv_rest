package com.cvrest.cv.CurliculumVitae;

import org.bson.Document;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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
import java.util.Optional;
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
            Cv cvObj = new Cv(Status.INSERTED, Document.parse(XML.toJSONObject(cv).toString()));
            cvRepository.insert(cvObj);
        } else {
            System.out.println("C'est pas valide");
        }
    }

    public static boolean validateXSD(String xml) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("xsd/cv21.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(xml)));
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        } catch (SAXException e1) {
            System.out.println("SAX Exception: " + e1.getMessage());
            return false;
        }

        return true;

    }

    public String getById(String id) {
        String cv = cvRepository.getXmlById(id);
        System.out.println(cv);

        // System.out.println(XML.toString(json));
        // System.out.println(XML.toJSONObject(XML.toString(json)));

        JSONObject json = new JSONObject(cv);

        System.out.println(" wow wow \n" + json.get("cvXml"));
        return XML.toString(json);
    }

    public ListCv getAllCustom() {
        List<Cv> cvs = cvRepository.findAll();
        ListCv listCV = new ListCv(cvs);
        System.out.println(listCV.getElements());
        return listCV;
    }

    public String deleteCv(String id) {
        cvRepository.deleteById(id);
        return "Cv " + id + " deleted";
    }

    public String updateCv(String id, String cvXml) {
        Optional<Cv> optionnalCv = cvRepository.findById(id);
        if (!optionnalCv.isPresent()) {
            return "Modification échoué pas de Cv correspond à l'id" + id;
        }
        Cv cv = optionnalCv.get();
        if (validateXSD(cvXml)) {
            cv.setCvXml(Document.parse(XML.toJSONObject(cvXml).toString()));
            // Cv cvObj = new Cv(Status.INSERTED,
            // Document.parse(XML.toJSONObject(cv).toString()));
        } else {
            return "Modification échoué le xml est invalid";
        }
        cv.setStatus(Status.UPDATED);
        System.out.println(cv);
        cvRepository.save(cv);
        return "Cv " + id + " updated";
    }
}

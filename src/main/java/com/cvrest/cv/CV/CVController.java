package com.cvrest.cv.CV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;

@Controller
public class CVController {

    private CVService cvService;

    @Autowired
    public CVController(CVService cvService) {
        this.cvService = cvService;
    }

    @PostMapping(value = "/insert", consumes = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void insertCv(@RequestBody String cvXml) {
        cvService.addCv(cvXml);
    }

}

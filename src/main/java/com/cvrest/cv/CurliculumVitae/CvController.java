package com.cvrest.cv.CurliculumVitae;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CvController {

    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping(value = "/insert", consumes = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void insertCv(@RequestBody String cvXml) {
        cvService.addCv(cvXml);
    }

    @GetMapping(value = "/cv", produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public String getCvById(@RequestParam String id) {
        return cvService.getById(id);
    }

    @GetMapping(value = "/htmlcv")
    public String getHtmlCvById(@RequestParam String id) {
        return cvService.getHtmlById(id);
    }

    @GetMapping(value = "/resume", produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ListCv getAllCvs() {
        return  cvService.getAllCustom();
    }

}

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

    @PostMapping(value = "/insert", consumes = { MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void insertCv(@RequestBody String cvXml) {
        cvService.addCv(cvXml);
    }

    @GetMapping(value = "/cv", produces = { MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public String getCvById(@RequestParam String id) {
        return cvService.getById(id);
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public String deleteCv(@RequestParam String id) {
        return cvService.deleteCv(id);
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public String updateCv(@RequestParam String id, @RequestBody String cvXml) {
        return cvService.updateCv(id, cvXml);
    }

    @GetMapping(value = "/resume", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ListCv getAllCvs() {
        return cvService.getAllCustom();
    }

}

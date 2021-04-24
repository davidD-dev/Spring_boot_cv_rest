package com.cvrest.cv.CurliculumVitae;

import java.util.List;

public class ListCv {
    private List<Cv> elements;

    public ListCv() {
    }

    public ListCv(List<Cv> elements) {
        this.elements = elements;
    }

    public List<Cv> getElements() {
        return elements;
    }

    public void setElements(List<Cv> elements) {
        this.elements = elements;
    }
}

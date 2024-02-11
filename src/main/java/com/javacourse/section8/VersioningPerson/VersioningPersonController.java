package com.javacourse.section8.VersioningPerson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getV1Person(){
        return new PersonV1("Mateusz Kuzera V1");
    }

    @GetMapping("/v2/person")
    public PersonV2 getV2Person(){
        return new PersonV2("Mateusz" ,"Kuzera V2");
    }

    @GetMapping(path="/person", params = "version=1")
    public PersonV1 getWithRequesrParamPerson1(){
        return new PersonV1("Mateusz" );
    }
    @GetMapping(path="/person", params = "version=2")
    public PersonV2 getWithRequesrParamPerson2(){
        return new PersonV2("Mateusz" ,"Kuzera V2");
    }

    @GetMapping(path="/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getWithCustomHeadersPerson1(){
        return new PersonV1("Mateusz" );
    }
    @GetMapping(path="/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getWithCustomHeadersPerson2(){
        return new PersonV2("Mateusz" ,"Kuzera V2");
    }

    @GetMapping(path="/person/header", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getWithAcceptHeaderPerson1(){
        return new PersonV1("Mateusz" );
    }
    @GetMapping(path="/person/header", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getWithAcceptHeaderPerson2(){
        return new PersonV2("Mateusz" ,"Kuzera V2");
    }


}

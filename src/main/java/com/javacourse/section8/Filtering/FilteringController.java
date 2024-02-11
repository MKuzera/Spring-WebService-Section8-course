package com.javacourse.section8.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filter")
    public MappingJacksonValue getUser(){
        UserToFilter userToFilter = new UserToFilter("Mateusz", "Kuzera", "xD", "desc");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userToFilter);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","surname","description");
        FilterProvider filderProvider = new SimpleFilterProvider().addFilter("UserFilter",filter);
        mappingJacksonValue.setFilters(filderProvider);
        return mappingJacksonValue;
    }
    @GetMapping("/filterall")
    public MappingJacksonValue getAllUsers(){

        List<UserToFilter> userToFilters = Arrays.asList(new UserToFilter("Mateusz", "Kuzera", "xD", "desc"), new UserToFilter("Mateus2z", "K2uzera", "x2D", "de2sc"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userToFilters);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("surname");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserFilter",filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}

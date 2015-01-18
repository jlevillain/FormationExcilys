package com.excilys.utils;

/**
 * Created by eron on 17/01/15.
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
/**
 * Permit to load custom module for jackson. This module permit to avoid lazy initialization when attribute of an object is not loaded.
 * Created by excilys on 06/05/14.
 */
public class HibernateAwareObjectMapper extends ObjectMapper {
    public HibernateAwareObjectMapper() {
        Hibernate4Module hm = new Hibernate4Module();
        registerModule(hm);
    }
}
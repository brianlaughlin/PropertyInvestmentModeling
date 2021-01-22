package com.brianlaughlin.invesmentmodeling.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

/*
Forgot how to do this
 */

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RapidPropertyRepositoryTest {

    public static final String SPLIT_BY_CONFIGNAME="SplitBy";
    public static final String MULTIPLY_BY_CONFIGNAME="MultiplyBy";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RapidPropertyRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getJsonData() {

        List<Object[]> lstobjects= repository.getJsonData(SPLIT_BY_CONFIGNAME!=null?Integer.parseInt(SPLIT_BY_CONFIGNAME.toString()):2);

    }
}
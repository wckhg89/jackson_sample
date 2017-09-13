package com.guppy.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guppy.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JsonToDomainTest {

    private static final Logger logger = LoggerFactory.getLogger(JsonToDomainTest.class);

    @Autowired
    private ObjectMapper objectMapper;

    private File jsonFile;

    @Before
    public void SETTING_JSON_FILE () {
        jsonFile = new File("src/test/resources/json/student.json");
    }


    @Test
    public void JSON_TO_JAVA_DOMAIN_TEST () throws IOException {
        Student student = objectMapper.readValue(jsonFile, Student.class);

        assertNotNull(student);
        logger.debug(student.toString());
    }


}

package pl.justifiction.springbootdemo.tests;

import pl.justifiction.springbootdemo.controller.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
@ComponentScan({"pl.justifiction.springbootdemo"})
public class ControllerTests {

    @Autowired
    private MockMvc mvc;


    //mapowanie potrzebne do mapowania obiektu na JSONA
    ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();


    @Test
    public void getFreqErrorTest1() throws Exception {

        mvc.perform(get("/api/words/items").param("wordName", "items"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void returnAllWordsTest() throws Exception {

        mvc.perform(get("/api"))
                .andExpect(status().isOk());
    }


    @Test
    public void getUniqueTest() throws Exception {


        mvc.perform(get("/api/words"))
                .andExpect(status().isOk());
    }

    @Test
    public void addWordTest() throws Exception {

        String requestJson = ow.writeValueAsString("energy");

        mvc.perform(post("/api/words").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());

    }


    @Test
    public void delWordTest() throws Exception {

        String requestJson = ow.writeValueAsString("flower");

        mvc.perform(delete("/api/words/flower").param("wordName", "flower").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void delWordErrorTest() throws Exception {

        String requestJson = ow.writeValueAsString("item");

        mvc.perform(delete("/api/words/item").param("wordName", "item").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isNotFound());
    }


}

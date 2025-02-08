import ecomerce.config.EcomerceApplication;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {EcomerceApplication.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PriceRestControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertTrue(true);
    }


    @Test
    void testGetPrice_FirstScenario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices")
                        .param("date", "2020-06-14T00:00:00+02:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", Matchers.is(35455)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tariffId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(35.5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", Matchers.is("EUR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", Matchers.is("2020-06-14T00:00:00+02:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", Matchers.is("2020-12-31T23:59:59+02:00")));
    }


    @Test
    void testGetPrice_SecondScenario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/prices")
                        .param("date", "2020-06-14T16:00:00+02:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", Matchers.is(35455)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tariffId", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(25.45)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", Matchers.is("EUR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", Matchers.is("2020-06-14T15:00:00+02:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", Matchers.is("2020-06-14T18:30:00+02:00")));


    }

    @Test
    void testGetPrice_ThirdScenario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/prices")
                        .param("date", "2020-06-14T21:00:00+02:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", Matchers.is(35455)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tariffId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(35.50)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", Matchers.is("EUR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", Matchers.is("2020-06-14T00:00:00+02:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", Matchers.is("2020-12-31T23:59:59+02:00")));

    }

    @Test
    void testGetPrice_FourthScenario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/prices")
                        .param("date", "2020-06-15T10:00:00+02:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", Matchers.is(35455)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tariffId", Matchers.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(30.5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", Matchers.is("EUR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", Matchers.is("2020-06-15T00:00:00+02:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", Matchers.is("2020-06-15T11:00:00+02:00")));

    }

    @Test
    void testGetPrice_FifthScenario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/prices")
                        .param("date", "2020-06-16T21:00:00+02:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", Matchers.is(35455)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tariffId", Matchers.is(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(38.95)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", Matchers.is("EUR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", Matchers.is("2020-06-15T16:00:00+02:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", Matchers.is("2020-12-31T23:59:59+02:00")));

    }


    @Test
    void testGetPrice_NotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/prices")
                        .param("date", "2025-06-16T21:00:00+02:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }


}

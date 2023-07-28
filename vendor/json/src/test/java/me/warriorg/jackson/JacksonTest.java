package me.warriorg.jackson;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.warriorg.vo.TestVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JacksonTest {

    @Test
    void whenParsingJsonStringIntoJsonNode_thenCorrect()
            throws IOException {
        String jsonString = """
                {"k1":"v1","k2":"v2"}
                """;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(jsonString);

        assertNotNull(actualObj);
    }

    @Test
    void whenTransient_thenString() throws JsonProcessingException {
        TestVO testVO = new TestVO();
        testVO.setBone("xxxxxxx");
        testVO.setStrings(List.of("xxxxx", "bbbbb"));
        testVO.setTransientStrings(List.of("11111", "222222"));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(testVO);
        System.out.println(json);
    }
}

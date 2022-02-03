package jp.uib.admin;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import jp.uib.admin.model.University;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UniversityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void 指定した大学の取得APIテスト() throws Exception {

        // エンドポイントチェック
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/api/{id}", "2");

        // HTTPステータスコードチェック
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

        MvcResult result = mockMvc.perform(getRequest).andExpect(resultStatus).andReturn();

        // レスポンスクラスの型チェック
        University responseBody = mapper.readValue(result.getResponse().getContentAsString(), University.class);
        assertInstanceOf(University.class, responseBody);
        assertInstanceOf(Integer.class, responseBody.getId());
        assertInstanceOf(String.class, responseBody.getName());
        assertInstanceOf(String.class, responseBody.getFurikana());
    }

    @Test
    public void 全ての大学取得APIテスト() throws Exception {

        // エンドポイントチェック
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/api/");

        // HTTPステータスコードチェック
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

        MvcResult result = mockMvc.perform(getRequest).andExpect(resultStatus).andReturn();

        // レスポンスクラスの型チェック
        JavaType universityCollection = mapper.getTypeFactory().constructCollectionType(List.class, University.class);
        List<University> responseBodyList = mapper.readValue(result.getResponse().getContentAsString(),
                universityCollection);
        assertInstanceOf(List.class, responseBodyList);
        responseBodyList.forEach(responseBody -> {
            assertInstanceOf(Integer.class, responseBody.getId());
            assertInstanceOf(String.class, responseBody.getName());
            assertInstanceOf(String.class, responseBody.getFurikana());
        });
    }

    @Test
    public void 大学追加APIテスト() throws Exception {

        // エンドポイントチェック
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/api/");

        // HTTPステータスコードチェック
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

        // リクエストクラスの設定
        University universityRequest = new University();
        universityRequest.setName("東京");
        universityRequest.setFurikana("トウキョウ");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(universityRequest);

        mockMvc.perform(getRequest.contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(resultStatus);
    }

    @Test
    public void 大学編集APIテスト() throws Exception {

        // エンドポイントチェック
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.put("/api/");

        // HTTPステータスコードチェック
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

        // リクエストクラスの設定
        University universityRequest = new University();
        universityRequest.setName("東京");
        universityRequest.setFurikana("トウキョウ");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(universityRequest);

        mockMvc.perform(getRequest.contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(resultStatus);
    }

    @Test
    public void 大学削除APIテスト() throws Exception {

        // エンドポイントチェック
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.delete("/api/{id}", "1");

        // HTTPステータスコードチェック
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(getRequest).andExpect(resultStatus);
    }

}

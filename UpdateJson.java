import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UpdateJson {

    public static void main(String[] args) {

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(new File("Complex.json"));

            JsonNode toppingNode = rootNode.at("/topping").get("id");

            ((ObjectNode) toppingNode.parent()).put("type", "Salt");

            objectMapper.writeValue(new File("Complex_updated.json"), rootNode);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

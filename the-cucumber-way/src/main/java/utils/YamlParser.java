package utils;
import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class YamlParser {
    public static void main(String[] args) {
        String yamlFilePath = "C:\\Users\\admin\\Downloads\\rent_search (2).yaml"; // Change to "buy_search.yaml" if needed

        try {
            FileInputStream fis = new FileInputStream(yamlFilePath);
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(fis);

            System.out.println("Parsed YAML Data:");
            System.out.println(data);
        } catch (IOException e) {
            System.err.println("Error reading YAML file: " + e.getMessage());
        }
    }
}



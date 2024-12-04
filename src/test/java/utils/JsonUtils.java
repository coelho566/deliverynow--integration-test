package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {
    public static String parseJSONFile(String json)  {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get("src/test/resources/Jsons/" + json + ".json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }
}


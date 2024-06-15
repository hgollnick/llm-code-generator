import enums.LLM;
import org.junit.jupiter.api.Test;
import templates.CrewAITemplate;
import util.FileUtil;

public class FileTest {
    @Test
    public void createFiles() {
        FileUtil.createFile("requirements.txt", new CrewAITemplate().createRequirements(LLM.AZURE));
        FileUtil.createFile("app.py", new CrewAIGenerationTest().buildCrewAI(LLM.AZURE));
        String[] files = {"requirements.txt", "app.py", "Dockerfile"};
        FileUtil.createZip(files, "zip.zip");
    }
}

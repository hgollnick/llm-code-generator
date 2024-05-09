import enums.LLM;
import frameworks.commons.models.AgentModel;
import frameworks.commons.models.ToolModel;
import frameworks.langchain.models.LangchainAgentModel;
import org.junit.jupiter.api.Test;
import templates.LangchainTemplate;
import util.FileReader;

import java.util.ArrayList;

public class LangchainGenerationTest {

    ArrayList<AgentModel> agents = new ArrayList<>();
    ArrayList<ToolModel> tools = new ArrayList<>();

    LangchainAgentModel agent = new LangchainAgentModel();
    ToolModel tool = new ToolModel();

    private ArrayList<ToolModel> createTools() {
        tool.setName("comments_api");
        tool.setFunc("comments_func");
        tool.setDescription("Use this tool to retrieve 'comments' from 'jsonplaceholder.typicode.com'");
        tool.setCode(FileReader.readFile("src/test/resources/templates/tools/CommentsTool.txt"));
        tools.add(tool);
        return tools;
    }

    private ArrayList<AgentModel> createAgents(LLM llm) {
        agent.setName("researcher");
        agent.setLlm(llm);
        agent.setTools(tools);
        agents.add(agent);
        return agents;
    }


    public void buildLangchain(LLM llm) {
        LangchainTemplate langchainTemplate = new LangchainTemplate();
        System.out.println(langchainTemplate.loadLangchain(
                llm, createTools(), createAgents(llm), "Get me the comment with ID 1"));
    }

    @Test
    public void testLangchainGroq() {
        buildLangchain(LLM.GROQ);
    }

    @Test
    public void testLangchainAzure() {
        buildLangchain(LLM.AZURE);
    }


}
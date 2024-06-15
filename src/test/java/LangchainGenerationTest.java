import enums.LLM;
import frameworks.commons.models.AgentModel;
import frameworks.commons.models.ToolModel;
import frameworks.langchain.models.LangchainAgentModel;
import org.junit.jupiter.api.Test;
import templates.LangchainTemplate;
import util.FileUtil;

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
        tool.setCode(FileUtil.readFile("src/test/resources/templates/tools/CommentsTool.txt"));
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
        System.out.println(new LangchainTemplate().loadLangchain(
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


    @Test
    public void testLangchainGroqRequirements() {
        System.out.println(new LangchainTemplate().createRequirements(LLM.GROQ));
    }

    @Test
    public void testLangchainAzureRequirements() {
        System.out.println(new LangchainTemplate().createRequirements(LLM.AZURE));
    }
}
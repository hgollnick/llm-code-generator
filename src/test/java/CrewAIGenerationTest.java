import enums.LLM;
import frameworks.crewai.models.CrewAIAgentModel;
import frameworks.crewai.models.CrewAICrewModel;
import frameworks.crewai.models.CrewAITaskModel;
import frameworks.langchain.models.ToolModel;
import org.junit.jupiter.api.Test;
import templates.CrewAITemplate;
import util.FileReader;
import util.Parser;

import java.util.ArrayList;
import java.util.HashMap;

public class CrewAIGenerationTest {

    ArrayList<CrewAIAgentModel> agents = new ArrayList<>();
    ArrayList<CrewAITaskModel> tasks = new ArrayList<>();
    ArrayList<ToolModel> tools = new ArrayList<>();

    CrewAIAgentModel agent = new CrewAIAgentModel();
    CrewAITaskModel task = new CrewAITaskModel();
    ToolModel tool = new ToolModel();

    private ArrayList<ToolModel> createTools() {
        tool.setName("comments_api");
        tool.setFunc("comments_func");
        tool.setDescription("Use this tool to retrieve 'comments' from 'jsonplaceholder.typicode.com'");
        tool.setCode(FileReader.readFile("src/main/resources/templates/langchain/tools/CommentsTool.txt"));
        tools.add(tool);
        return tools;
    }

    private ArrayList<CrewAIAgentModel> createAgents(LLM llm) {
        agent.setName("researcher");
        agent.setRole("Senior Researcher");
        agent.setGoal("Uncover groundbreaking technologies in {topic}");
        agent.setBackstory("Driven by curiosity, you're at the forefront of\"\n" +
                "    \"innovation, eager to explore and share knowledge that could change\"\n" +
                "    \"the world.");
        agent.setLlm(llm);
        agent.setTools(tools);
        agents.add(agent);
        return agents;
    }

    private ArrayList<CrewAITaskModel> createTasks() {
        task.setName("identify_trends");
        task.setAgent(agent);
        task.setDescription("Identify the next big trend in {topic}. Focus on identifying pros and cons and the\"\n" +
                "    \"overall narrative. Your final report should clearly articulate the key points,\"\n" +
                "    \"its market opportunities, and potential risks.)");
        task.setExpected_output("A comprehensive 3 paragraphs long report on the latest AI trends.");
        task.setTools(tools);
        tasks.add(task);
        return tasks;
    }

    public void buildCrewAI(LLM llm) {
        HashMap<String, String> inputs = new HashMap<>();
        inputs.put("topic", "AI");

        CrewAITemplate crewAITemplate = new CrewAITemplate();
        crewAITemplate.load(llm, createTools(), createAgents(llm), createTasks(), new CrewAICrewModel(), Parser.inputParser(inputs));
    }

    @Test
    public void testGroq() {
        buildCrewAI(LLM.GROQ);
    }

    @Test
    public void testAzureOpenAI() {
        buildCrewAI(LLM.AZURE);
    }


}
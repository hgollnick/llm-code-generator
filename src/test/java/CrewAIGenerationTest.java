import enums.LLM;
import frameworks.commons.models.AgentModel;
import frameworks.crewai.models.CrewAIAgentModel;
import frameworks.crewai.models.CrewAICrewModel;
import frameworks.crewai.models.CrewAITaskModel;
import frameworks.commons.models.ToolModel;
import org.junit.jupiter.api.Test;
import templates.CrewAITemplate;
import util.FileUtil;
import util.Parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class CrewAIGenerationTest {

    ArrayList<AgentModel> agents = new ArrayList<>();
    ArrayList<CrewAITaskModel> tasks = new ArrayList<>();
    ArrayList<ToolModel> tools = new ArrayList<>();

    CrewAIAgentModel agent = new CrewAIAgentModel();
    CrewAITaskModel task = new CrewAITaskModel();
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

    public String buildCrewAI(LLM llm) {
        HashMap<String, String> inputs = new HashMap<>();
        inputs.put("topic", "AI");

        return new CrewAITemplate().loadCrewAI(
                llm, createTools(), createAgents(llm), createTasks(), new CrewAICrewModel(), Parser.inputParser(inputs));
    }

    @Test
    public void testCrewAIGroq() {
        System.out.println(buildCrewAI(LLM.GROQ));
    }

    @Test
    public void testCrewAIAzure() {
        System.out.println(buildCrewAI(LLM.AZURE));
    }

    @Test
    public void testCrewAIGroqRequirements() {
        System.out.println(new CrewAITemplate().createRequirements(LLM.GROQ));
    }

    @Test
    public void testCrewAIAzureRequirements() {
        System.out.println(new CrewAITemplate().createRequirements(LLM.AZURE));
    }

}
package templates;

import constants.TemplateConstants;
import enums.LLM;
import frameworks.crewai.models.CrewAIAgentModel;
import frameworks.crewai.models.CrewAICrewModel;
import frameworks.crewai.models.CrewAITaskModel;
import util.FileReader;
import util.Parser;

import java.util.ArrayList;

/**
 * This class extends the BaseTemplate class and provides the implementation for creating a CrewAI template.
 * It overrides the abstract methods in the BaseTemplate class to provide the specific implementation for CrewAI.
 */
public class CrewAITemplate extends BaseTemplate {

    /**
     * This method is responsible for creating the necessary imports for the CrewAI template.
     * It uses a switch statement to check the type of the large language model (LLM).
     * If the LLM is Azure, it reads the Azure template file.
     * If the LLM is Groq, it reads the Groq template file.
     * The method uses the FileReader utility to read the template files.
     *
     * @param llm The type of the large language model (LLM).
     * @return A string containing the created imports. If the LLM is Azure, it returns the Azure imports. If the LLM is Groq, it returns the Groq imports.
     */
    @Override
    protected String createImports(LLM llm) {
        return switch (llm) {
            case AZURE -> FileReader.readFile(TemplateConstants.CREWAI_AZURE);
            case GROQ -> FileReader.readFile(TemplateConstants.CREWAI_GROQ);
        };
    }

    /**
     * This method creates the large language model (LLM) for the CrewAI template.
     * Depending on the type of LLM (Azure or Groq), it reads the corresponding template file and replaces placeholders with environment variables.
     * For Azure, it replaces placeholders for the Azure endpoint, API key, Azure deployment, and API version.
     * For Groq, it replaces placeholders for the API key and model.
     * If the LLM type is not Azure or Groq, it returns an empty string.
     *
     * @param llm The type of the large language model (LLM).
     * @return The created large language model as a string. If the LLM type is not Azure or Groq, it returns an empty string.
     */
    @Override
    public String createLLM(LLM llm) {
        String content;
        switch (llm) {
            case AZURE:
                content = FileReader.readFile(TemplateConstants.AZURE_OPENAI);
                content = content.replace("<azure_endpoint>", System.getenv("azure_endpoint"));
                content = content.replace("<api_key>", System.getenv("azure_openai_api_key"));
                content = content.replace("<azure_deployment>", System.getenv("azure_deployment"));
                content = content.replace("<api_version>", System.getenv("api_version"));
                return content;
            case GROQ:
                content = FileReader.readFile(TemplateConstants.GROQ);
                content = content.replace("<api_key>", System.getenv("groq_api_key"));
                content = content.replace("<model>", System.getenv("model"));
                return content;
            default:
                return "";
        }
    }

    /**
     * This method creates the agents for the CrewAI template.
     *
     * @param agents The list of agents.
     * @return The created agents as a string.
     */
    @Override
    protected String createAgents(ArrayList<CrewAIAgentModel> agents) {
        StringBuilder agentsString = new StringBuilder();
        for (CrewAIAgentModel agent : agents) {
            getAgentNames().add(agent.getName());
                String content = FileReader.readFile(TemplateConstants.CREWAI_AGENT);
                content = content.replace("<name>", agent.getName());
                content = content.replace("<role>", agent.getRole());
                content = content.replace("<goal>", agent.getGoal());
                content = content.replace("<verbose>", Parser.getPythonBooleanString(agent.isVerbose()));
                content = content.replace("<memory>", Parser.getPythonBooleanString(agent.isMemory()));
                content = content.replace("<backstory>", agent.getBackstory());
                content = content.replace("<llm>", agent.getLlm().toString());
                content = content.replace("<tools>", agent.getToolNames());
                content = content.replace("<allow_delegation>", Parser.getPythonBooleanString(agent.isAllow_delegation()));
                agentsString.append(content);
        }
        return agentsString.toString();
    }

    /**
     * This method creates the tasks for the CrewAI template.
     *
     * @param tasks The list of tasks.
     * @return The created tasks as a string.
     */
    @Override
    protected String createTasks(ArrayList<CrewAITaskModel> tasks) {
        StringBuilder tasksString = new StringBuilder();
        for (CrewAITaskModel task : tasks) {
            getTaskNames().add(task.getName());
            String content = FileReader.readFile(TemplateConstants.CREWAI_TASK);
            content = content.replace("<name>", task.getName());
            content = content.replace("<description>", task.getDescription());
            content = content.replace("<expected_output>", task.getExpected_output());
            content = content.replace("<tools>", task.getToolNames());
            content = content.replace("<agent>", task.getAgent().getName());
            tasksString.append(content);
        }
        return tasksString.toString();
    }

    /**
     * This method creates the crew for the CrewAI template.
     *
     * @param crew The crew.
     * @return The created crew as a string.
     */
    @Override
    protected String createCrew(CrewAICrewModel crew) {
        String content = FileReader.readFile(TemplateConstants.CREWAI_CREW);
        content = content.replace("<agents>", getAgentNames().toString());
        content = content.replace("<tasks>", getTaskNames().toString());
        content = content.replace("<process>", crew.getProcess());
        content = content.replace("<cache>", Parser.getPythonBooleanString(crew.isCache()));
        content = content.replace("<max_rpm>", String.valueOf(crew.getMax_rpm()));
        content = content.replace("<share_crew>", Parser.getPythonBooleanString(crew.isShare_crew()));
        return content;
    }

    /**
     * This method creates the run method for the CrewAI template.
     *
     * @param inputs The inputs.
     * @return The created run method as a string.
     */
    @Override
    protected String createRunMethod(String inputs) {
        String content = FileReader.readFile(TemplateConstants.CREWAI_RUN);
        return content.replace("<inputs>", inputs);
    }

}
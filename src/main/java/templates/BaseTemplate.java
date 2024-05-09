package templates;

import constants.TemplateConstants;
import enums.LLM;
import frameworks.crewai.models.CrewAIAgentModel;
import frameworks.crewai.models.CrewAICrewModel;
import frameworks.crewai.models.CrewAITaskModel;
import frameworks.langchain.models.ToolModel;
import util.FileReader;

import java.util.ArrayList;

/**
 * This abstract class serves as a base template for creating different types of templates.
 * It contains methods for creating imports, local learning models, agents, tasks, crews, and run methods.
 * It also contains a load method that prints the created elements.
 */
public abstract class BaseTemplate {

    protected ArrayList<String> agentNames = new ArrayList<>();
    protected ArrayList<String> taskNames = new ArrayList<>();
    protected ArrayList<String> toolNames = new ArrayList<>();

    /**
     * This method is responsible for loading the agents, tasks, crew, and inputs.
     * It creates a StringBuilder, appends the results of the create methods for imports, local learning model, tools, agents, tasks, crew, and run method.
     * Finally, it prints the created elements.
     *
     * @param llm The largue language model.
     * @param tools The list of tools.
     * @param agents The list of agents.
     * @param tasks The list of tasks.
     * @param crew The crew.
     * @param inputs The inputs.
     */
    public void load(LLM llm, ArrayList<ToolModel> tools, ArrayList<CrewAIAgentModel> agents,
                     ArrayList<CrewAITaskModel> tasks, CrewAICrewModel crew, String inputs) {
        StringBuilder sb = new StringBuilder();
        sb.append(createImports(llm));
        sb.append(createLLM(llm));
        sb.append(createTools(tools));
        sb.append(createAgents(agents));
        sb.append(createTasks(tasks));
        sb.append(createCrew(crew));
        sb.append(createRunMethod(inputs));
        System.out.println(sb);
    }

    /**
     * This abstract method is responsible for creating the imports.
     * It should be overridden by subclasses to provide the specific implementation.
     *
     * @param llm The local learning model.
     * @return A string representing the created imports.
     */
    protected abstract String createImports(LLM llm);

    /**
     * This abstract method is responsible for creating the local learning model.
     * It should be overridden by subclasses to provide the specific implementation.
     *
     * @param llm The local learning model.
     * @return A string representing the created local learning model.
     */
    protected abstract String createLLM(LLM llm);

    /**
     * This method creates a string representation of the tools.
     * It iterates over the provided list of ToolModel objects, adds their names to the toolNames list,
     * and replaces placeholders in the template with the tool's properties.
     *
     * @param tools The list of ToolModel objects.
     * @return A string representation of the tools.
     */
    protected String createTools(ArrayList<ToolModel> tools) {
        StringBuilder toolsString = new StringBuilder();
        for (ToolModel tool : tools) {
            getToolNames().add(tool.getName());
            String content = FileReader.readFile(TemplateConstants.TOOL);
            content = content.replace("<name>", tool.getName());
            content = content.replace("<func>", tool.getFunc());
            content = content.replace("<description>", tool.getDescription());
            content = content.replace("<code>", tool.getCode());
            toolsString.append(content);
        }
        return toolsString.toString();
    };

    /**
     * This method creates the agents.
     * It should be overridden by subclasses.
     *
     * @param agents The list of agents.
     * @return The created agents.
     */
    protected abstract String createAgents(ArrayList<CrewAIAgentModel> agents);

    /**
     * This method creates the tasks.
     * It should be overridden by subclasses.
     *
     * @param tasks The list of tasks.
     * @return The created tasks.
     */
    protected abstract String createTasks(ArrayList<CrewAITaskModel> tasks);

    /**
     * This method creates the crew.
     * It should be overridden by subclasses.
     *
     * @param crew The crew.
     * @return The created crew.
     */
    protected abstract String createCrew(CrewAICrewModel crew);

    /**
     * This method creates the run method.
     * It should be overridden by subclasses.
     *
     * @param inputs The question.
     * @return The created run method.
     */
    protected abstract String createRunMethod(String inputs);

    /**
     * This method returns the list of task names.
     *
     * @return The list of task names.
     */
    protected ArrayList<String> getTaskNames() {
        return taskNames;
    }

    /**
     * This method returns the list of agent names.
     *
     * @return The list of agent names.
     */
    protected ArrayList<String> getAgentNames() {
        return agentNames;
    }

    /**
     * This method returns the list of tool names.
     *
     * @return An ArrayList of Strings representing the names of the tools.
     */
    public ArrayList<String> getToolNames() {
        return toolNames;
    }
}
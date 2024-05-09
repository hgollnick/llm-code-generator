package frameworks.crewai.models;

import frameworks.commons.models.ToolModel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a model for a Task in the CrewAI framework.
 * It contains several properties related to the task's description, expected output, tools, and assigned agent.
 */
public class CrewAITaskModel {

    private String name; // The name of the task

    // Python Task properties
    private String description; // The description of the task
    private String expected_output; // The expected output of the task
    private ArrayList<ToolModel> tools; // The tools required for the task
    private CrewAIAgentModel agent; // The agent assigned to the task

    /**
     * Default constructor for CrewAITaskModel.
     */
    public CrewAITaskModel() {
    }

    /**
     * Constructor for CrewAITaskModel with all properties.
     *
     * @param description      The description of the task.
     * @param expected_output  The expected output of the task.
     * @param tools            The tools required for the task.
     * @param agent            The agent assigned to the task.
     */
    public CrewAITaskModel(String description, String expected_output, ArrayList<ToolModel> tools, CrewAIAgentModel agent) {
        this.description = description;
        this.expected_output = expected_output;
        this.tools = tools;
        this.agent = agent;
    }

    /**
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the task.
     *
     * @param name The new name of the task.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description The new description of the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The expected output of the task.
     */
    public String getExpected_output() {
        return expected_output;
    }

    /**
     * Sets the expected output of the task.
     *
     * @param expected_output The new expected output of the task.
     */
    public void setExpected_output(String expected_output) {
        this.expected_output = expected_output;
    }

    /**
     * @return The tools required for the task.
     */
    public ArrayList<ToolModel> getTools() {
        return tools;
    }

    /**
     * Sets the tools required for the task.
     *
     * @param tools The new tools for the task.
     */
    public void setTools(ArrayList<ToolModel> tools) {
        this.tools = tools;
    }

    /**
     * @return The agent assigned to the task.
     */
    public CrewAIAgentModel getAgent() {
        return agent;
    }

    /**
     * Sets the agent assigned to the task.
     *
     * @param agent The new agent for the task.
     */
    public void setAgent(CrewAIAgentModel agent) {
        this.agent = agent;
    }

    /**
     * This method retrieves the names of all the tools associated with the agent.
     * It uses Java 8 streams to map each ToolModel object to its name, and then collects these names into an array.
     * The array of names is then converted to a string for easy display.
     *
     * @return A string representation of an array containing the names of all the tools.
     */
    public String getToolNames() {
        return Arrays.toString(tools.stream()
                .map(ToolModel::getName)
                .toArray(String[]::new));
    }
}
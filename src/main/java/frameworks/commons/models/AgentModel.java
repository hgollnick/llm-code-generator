package frameworks.commons.models;

import enums.LLM;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents an agent model in the system.
 * An agent has a name, a verbosity setting, a local learning model (LLM), and a list of tools.
 */
public class AgentModel {

    private String name;
    private boolean verbose = true;
    private LLM llm;
    private ArrayList<ToolModel> tools;

    /**
     * Default constructor for the AgentModel class.
     */
    public AgentModel() {
    }

    /**
     * Constructor for the AgentModel class that sets the name of the agent.
     *
     * @param name The name of the agent.
     */
    public AgentModel(String name) {
        this.name = name;
    }

    /**
     * @return The name of the agent.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the agent.
     *
     * @param name The new name of the agent.
     */
    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    /**
     * @return The verbosity setting of the agent.
     */
    public boolean isVerbose() {
        return verbose;
    }

    /**
     * Sets the verbosity setting of the agent.
     *
     * @param verbose The new verbosity setting of the agent.
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    /**
     * @return The local learning model of the agent.
     */
    public LLM getLlm() {
        return llm;
    }

    /**
     * Sets the local learning model of the agent.
     *
     * @param llm The new local learning model of the agent.
     */
    public void setLlm(LLM llm) {
        this.llm = llm;
    }

    /**
     * @return The tools of the agent.
     */
    public ArrayList<ToolModel> getTools() {
        return tools;
    }

    /**
     * Sets the tools of the agent.
     *
     * @param tools The new tools of the agent.
     */
    public void setTools(ArrayList<ToolModel> tools) {
        this.tools = tools;
    }

    /**
     * This method retrieves the names of all the tools associated with the agent.
     * It uses Java 8 streams to map each ToolModel object to its name, and then collects these names into an array.
     * The array of names is then converted to a string for easy display.
     *
     * @return A string representation of an array containing the names of all the tools.
     */
    public String getToolNames() {
        return Arrays.toString(getTools().stream()
                .map(ToolModel::getName)
                .toArray(String[]::new));
    }
}

package frameworks.crewai.models;

import enums.LLM;
import frameworks.langchain.models.ToolModel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a model for an Agent in the CrewAI framework.
 * It contains several properties related to the agent's role, goal, verbosity, memory, backstory,
 * Large Language Model (LLM), tools, and delegation allowance.
 */
public class CrewAIAgentModel {

    private String name;

    // Python Agent properties
    private String role;
    private String goal;
    private boolean verbose = true;
    private boolean memory = true;
    private String backstory;
    private LLM llm;
    private ArrayList<ToolModel> tools;
    private boolean allow_delegation = true;

    /**
     * Default constructor for CrewAIAgentModel.
     */
    public CrewAIAgentModel() {
    }

    /**
     * Constructor for CrewAIAgentModel with all properties.
     *
     * @param role             The role of the agent.
     * @param goal             The goal of the agent.
     * @param verbose          The verbosity flag of the agent.
     * @param memory           The memory flag of the agent.
     * @param backstory        The backstory of the agent.
     * @param llm              The local learning model of the agent.
     * @param tools            The tools of the agent.
     * @param allow_delegation The delegation allowance flag of the agent.
     */
    public CrewAIAgentModel(String role, String goal, boolean verbose, boolean memory, String backstory,
                            LLM llm, ArrayList<ToolModel> tools, boolean allow_delegation) {
        this.role = role;
        this.goal = goal;
        this.verbose = verbose;
        this.memory = memory;
        this.backstory = backstory;
        this.llm = llm;
        this.tools = tools;
        this.allow_delegation = allow_delegation;
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
     * @return The role of the agent.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the agent.
     *
     * @param role The new role of the agent.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return The goal of the agent.
     */
    public String getGoal() {
        return goal;
    }

    /**
     * Sets the goal of the agent.
     *
     * @param goal The new goal of the agent.
     */
    public void setGoal(String goal) {
        this.goal = goal;
    }

    /**
     * @return The verbosity flag of the agent.
     */
    public boolean isVerbose() {
        return verbose;
    }

    /**
     * Sets the verbosity flag of the agent.
     *
     * @param verbose The new verbosity flag of the agent.
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    /**
     * @return The memory flag of the agent.
     */
    public boolean isMemory() {
        return memory;
    }

    /**
     * Sets the memory flag of the agent.
     *
     * @param memory The new memory flag of the agent.
     */
    public void setMemory(boolean memory) {
        this.memory = memory;
    }

    /**
     * @return The backstory of the agent.
     */
    public String getBackstory() {
        return backstory;
    }

    /**
     * Sets the backstory of the agent.
     *
     * @param backstory The new backstory of the agent.
     */
    public void setBackstory(String backstory) {
        this.backstory = backstory;
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
     * @return The delegation allowance flag of the agent.
     */
    public boolean isAllow_delegation() {
        return allow_delegation;
    }

    /**
     * Sets the delegation allowance flag of the agent.
     *
     * @param allow_delegation The new delegation allowance flag of the agent.
     */
    public void setAllow_delegation(boolean allow_delegation) {
        this.allow_delegation = allow_delegation;
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
package frameworks.crewai.models;

import frameworks.commons.models.AgentModel;

/**
 * This class represents a model for an Agent in the CrewAI framework.
 * It contains several properties related to the agent's role, goal, verbosity, memory, backstory,
 * Large Language Model (LLM), tools, and delegation allowance.
 */
public class CrewAIAgentModel extends AgentModel {

    // Python Agent properties
    private String role;
    private String goal;
    private boolean memory = true;
    private String backstory;
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
     * @param memory           The memory flag of the agent.
     * @param backstory        The backstory of the agent.
     * @param allow_delegation The delegation allowance flag of the agent.
     */
    public CrewAIAgentModel(String role, String goal, boolean memory, String backstory, boolean allow_delegation) {
        this.role = role;
        this.goal = goal;
        this.memory = memory;
        this.backstory = backstory;
        this.allow_delegation = allow_delegation;
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
}
package frameworks.crewai.models;

import java.util.ArrayList;

/**
 * This class represents a model for a Crew in the CrewAI framework.
 * It contains a list of agents and tasks, along with several other properties.
 */
public class CrewAICrewModel {

    private ArrayList<CrewAIAgentModel> agents; // The list of agents in the crew
    private ArrayList<CrewAITaskModel> tasks; // The list of tasks for the crew
    private String process = "Process.sequential"; // The process type
    private boolean memory = true; // The memory flag
    private boolean cache = true; // The cache flag
    private int max_rpm = 100; // The maximum RPM
    private boolean share_crew = true; // The share crew flag

    /**
     * Default constructor for CrewAICrewModel.
     */
    public CrewAICrewModel() {
    }

    /**
     * Constructor for CrewAICrewModel with all properties.
     *
     * @param agents     The list of agents in the crew.
     * @param tasks      The list of tasks for the crew.
     * @param process    The process type.
     * @param memory     The memory flag.
     * @param cache      The cache flag.
     * @param max_rpm    The maximum RPM.
     * @param share_crew The share crew flag.
     */
    public CrewAICrewModel(ArrayList<CrewAIAgentModel> agents, ArrayList<CrewAITaskModel> tasks, String process,
                           boolean memory, boolean cache, int max_rpm, boolean share_crew) {
        this.agents = agents;
        this.tasks = tasks;
        this.process = process;
        this.memory = memory;
        this.cache = cache;
        this.max_rpm = max_rpm;
        this.share_crew = share_crew;
    }

    /**
     * @return The list of agents in the crew.
     */
    public ArrayList<CrewAIAgentModel> getAgents() {
        return agents;
    }

    /**
     * Sets the list of agents in the crew.
     *
     * @param agents The new list of agents.
     */
    public void setAgents(ArrayList<CrewAIAgentModel> agents) {
        this.agents = agents;
    }

    /**
     * @return The list of tasks for the crew.
     */
    public ArrayList<CrewAITaskModel> getTasks() {
        return tasks;
    }

    /**
     * Sets the list of tasks for the crew.
     *
     * @param tasks The new list of tasks.
     */
    public void setTasks(ArrayList<CrewAITaskModel> tasks) {
        this.tasks = tasks;
    }

    /**
     * @return The process type.
     */
    public String getProcess() {
        return process;
    }

    /**
     * Sets the process type.
     *
     * @param process The new process type.
     */
    public void setProcess(String process) {
        this.process = process;
    }

    /**
     * @return The memory flag.
     */
    public boolean isMemory() {
        return memory;
    }

    /**
     * Sets the memory flag.
     *
     * @param memory The new memory flag.
     */
    public void setMemory(boolean memory) {
        this.memory = memory;
    }

    /**
     * @return The cache flag.
     */
    public boolean isCache() {
        return cache;
    }

    /**
     * Sets the cache flag.
     *
     * @param cache The new cache flag.
     */
    public void setCache(boolean cache) {
        this.cache = cache;
    }

    /**
     * @return The maximum RPM.
     */
    public int getMax_rpm() {
        return max_rpm;
    }

    /**
     * Sets the maximum RPM.
     *
     * @param max_rpm The new maximum RPM.
     */
    public void setMax_rpm(int max_rpm) {
        this.max_rpm = max_rpm;
    }

    /**
     * @return The share crew flag.
     */
    public boolean isShare_crew() {
        return share_crew;
    }

    /**
     * Sets the share crew flag.
     *
     * @param share_crew The new share crew flag.
     */
    public void setShare_crew(boolean share_crew) {
        this.share_crew = share_crew;
    }

}
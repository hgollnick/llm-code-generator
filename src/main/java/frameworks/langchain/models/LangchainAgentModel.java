package frameworks.langchain.models;

import frameworks.commons.models.AgentModel;

/**
 * This class represents a Langchain agent model in the system.
 * It extends the AgentModel class and adds two additional properties: agent_type and handle_parsing_errors.
 * The agent_type property represents the type of the agent, and the handle_parsing_errors property indicates whether the agent should handle parsing errors.
 */
public class LangchainAgentModel extends AgentModel {

    private String agent_type = "AgentType.ZERO_SHOT_REACT_DESCRIPTION";
    private boolean handle_parsing_errors = true;

    /**
     * @return The type of the agent.
     */
    public String getAgent_type() {
        return agent_type;
    }

    /**
     * Sets the type of the agent.
     *
     * @param agent_type The new type of the agent.
     */
    public void setAgent_type(String agent_type) {
        this.agent_type = agent_type;
    }

    /**
     * @return The handle_parsing_errors setting of the agent.
     */
    public boolean isHandle_parsing_errors() {
        return handle_parsing_errors;
    }

    /**
     * Sets the handle_parsing_errors setting of the agent.
     *
     * @param handle_parsing_errors The new handle_parsing_errors setting of the agent.
     */
    public void setHandle_parsing_errors(boolean handle_parsing_errors) {
        this.handle_parsing_errors = handle_parsing_errors;
    }
}
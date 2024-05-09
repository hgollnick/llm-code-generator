package templates;

import constants.TemplateConstants;
import enums.LLM;
import frameworks.commons.models.AgentModel;
import frameworks.commons.models.ToolModel;
import frameworks.langchain.models.LangchainAgentModel;
import util.FileReader;
import util.Parser;

import java.util.ArrayList;

/**
 * This class represents a Langchain template in the system.
 * It extends the BaseTemplate class and overrides some of its methods to provide Langchain-specific functionality.
 */
public class LangchainTemplate extends BaseTemplate {

    /**
     * This method loads the Langchain template.
     * It calls the super class's load method and then replaces the "<complement>" placeholder in the template with a newline character.
     *
     * @param llm The type of the large language model (LLM).
     * @param tools The tools to be used by the agents.
     * @param agents The agents to be used in the template.
     * @param inputs The inputs to the template.
     * @return The loaded Langchain template as a string.
     */
    public String loadLangchain(LLM llm, ArrayList<ToolModel> tools, ArrayList<AgentModel> agents, String inputs) {
        String str = super.load(llm, tools, agents, inputs);
        str = str.replace("<complement>", "\n");
        return str;
    }

    /**
     * This method creates the necessary imports for the Langchain template.
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
            case AZURE -> FileReader.readFile(TemplateConstants.LANGCHAIN_AZURE);
            case GROQ -> FileReader.readFile(TemplateConstants.LANGCHAIN_GROQ);
        };
    }

    /**
     * This method creates the agents for the Langchain template.
     * It iterates over the provided list of agents, casts each agent to a LangchainAgentModel, and then replaces various placeholders in the agent template with the agent's properties.
     * The method uses the FileReader utility to read the agent template file and the Parser utility to convert boolean values to Python boolean strings.
     *
     * @param agents The agents to be used in the template.
     * @return A string containing the created agents.
     */
    @Override
    protected String createAgents(ArrayList<AgentModel> agents) {
        StringBuilder agentsString = new StringBuilder();
        for (AgentModel a : agents) {
            LangchainAgentModel agent = (LangchainAgentModel) a;
            getAgentNames().add(agent.getName());
            String content = FileReader.readFile(TemplateConstants.LANGCHAIN_AGENT);
            content = content.replace("<name>", agent.getName());
            content = content.replace("<tools>", agent.getToolNames());
            content = content.replace("<llm>", agent.getLlm().toString());
            content = content.replace("<agent_type>", agent.getAgent_type());
            content = content.replace("<verbose>", Parser.getPythonBooleanString(agent.isVerbose()));
            content = content.replace("<handle_parsing_errors>", Parser.getPythonBooleanString(agent.isHandle_parsing_errors()));
            agentsString.append(content);
        }
        return agentsString.toString();
    }

    /**
     * This method creates the run method for the Langchain template.
     * It reads the run method template file and replaces the "<inputs>" placeholder with the provided inputs.
     * The method uses the FileReader utility to read the run method template file.
     *
     * @param inputs The inputs to the run method.
     * @return A string containing the created run method.
     */
    @Override
    protected String createRunMethod(String inputs) {
        String content = FileReader.readFile(TemplateConstants.LANGCHAIN_RUN);
        return content.replace("<inputs>", inputs);
    }
}
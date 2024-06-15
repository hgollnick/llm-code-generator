package constants;

/**
 * This class contains constants that represent the paths to various template files.
 * These templates are used throughout the application to generate different parts of the code.
 */
public class TemplateConstants {


    // Commons
    public static final String GROQ = "src/main/resources/LLM/GroqTemplate.txt";
    public static final String AZURE_OPENAI = "src/main/resources/LLM/AzureOpenAITemplate.txt";

    public static final String TOOL = "src/main/resources/templates/commons/ToolTemplate.txt";

    // CrewAI
    public static final String CREWAI_AGENT = "src/main/resources/templates/crewai/CrewAIAgentTemplate.txt";
    public static final String CREWAI_TASK = "src/main/resources/templates/crewai/CrewAITaskTemplate.txt";
    public static final String CREWAI_CREW = "src/main/resources/templates/crewai/CrewAICrewTemplate.txt";
    public static final String CREWAI_RUN = "src/main/resources/templates/crewai/CrewAIRunTemplate.txt";

    public static final String CREWAI_GROQ = "src/main/resources/templates/crewai/imports/CrewAIGroqTemplate.txt";
    public static final String CREWAI_AZURE = "src/main/resources/templates/crewai/imports/CrewAIAzureTemplate.txt";

    public static final String CREWAI_GROQ_REQUIREMENTS = "src/main/resources/templates/crewai/requirements/CrewAIGroqRequirements.txt";
    public static final String CREWAI_AZURE_REQUIREMENTS = "src/main/resources/templates/crewai/requirements/CrewAIAzureRequirements.txt";

    // Langchain
    public static final String LANGCHAIN_AGENT = "src/main/resources/templates/langchain/LangchainAgentTemplate.txt";
    public static final String LANGCHAIN_RUN = "src/main/resources/templates/langchain/LangchainRunTemplate.txt";

    public static final String LANGCHAIN_GROQ = "src/main/resources/templates/langchain/imports/LangchainGroqTemplate.txt";
    public static final String LANGCHAIN_AZURE = "src/main/resources/templates/langchain/imports/LangchainAzureTemplate.txt";

    public static final String LANGCHAIN_GROQ_REQUIREMENTS = "src/main/resources/templates/langchain/requirements/LangchainGroqRequirements.txt";
    public static final String LANGCHAIN_AZURE_REQUIREMENTS = "src/main/resources/templates/langchain/requirements/LangchainAzureRequirements.txt";

}

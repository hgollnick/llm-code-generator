package constants;

/**
 * This class contains constants that represent the paths to various template files.
 * These templates are used throughout the application to generate different parts of the code.
 */
public class TemplateConstants {

    public static final String GROQ = "src/main/resources/LLM/GroqTemplate.txt";
    public static final String AZURE_OPENAI = "src/main/resources/LLM/AzureOpenAITemplate.txt";

    public static final String CREWAI_AGENT = "src/main/resources/templates/crewai/CrewAIAgentTemplate.txt";
    public static final String CREWAI_TASK = "src/main/resources/templates/crewai/CrewAITaskTemplate.txt";
    public static final String CREWAI_CREW = "src/main/resources/templates/crewai/CrewAICrewTemplate.txt";
    public static final String CREWAI_RUN = "src/main/resources/templates/crewai/CrewAIRunTemplate.txt";

    public static final String CREWAI_GROQ = "src/main/resources/templates/crewai/imports/CrewAIGroqTemplate.txt";
    public static final String CREWAI_AZURE = "src/main/resources/templates/crewai/imports/CrewAIAzureTemplate.txt";

    public static final String TOOL = "src/main/resources/templates/langchain/ToolTemplate.txt";
}

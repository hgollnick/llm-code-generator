package frameworks.commons.models;

/**
 * This class represents a tool model in the Langchain framework.
 * It contains properties related to a Python task such as name, function, description, and code.
 */
public class ToolModel {

    // Python Tool properties
    private String name;
    private String func;
    private String description;
    private String code;

    /**
     * Default constructor for the ToolModel class.
     */
    public ToolModel() {
    }

    /**
     * Constructor for the ToolModel class.
     *
     * @param name        The name of the tool.
     * @param func        The function of the tool.
     * @param description The description of the tool.
     * @param code        The code of the tool.
     */
    public ToolModel(String name, String func, String description, String code) {
        this.name = name;
        this.func = func;
        this.description = description;
        this.code = code;
    }

    /**
     * Getter for the name property.
     *
     * @return The name of the tool.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name property.
     *
     * @param name The new name of the tool.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the function property.
     *
     * @return The function of the tool.
     */
    public String getFunc() {
        return func;
    }

    /**
     * Setter for the function property.
     *
     * @param func The new function of the tool.
     */
    public void setFunc(String func) {
        this.func = func;
    }

    /**
     * Getter for the description property.
     *
     * @return The description of the tool.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the description property.
     *
     * @param description The new description of the tool.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the code property.
     *
     * @return The code of the tool.
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for the code property.
     *
     * @param code The new code of the tool.
     */
    public void setCode(String code) {
        this.code = code;
    }
}
package PresentationLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ibenk
 */
public class HTMLSelect {
    private final String name;
    private String selectedValue = "";
    private final List<HTMLOption> options;

    /**
     *
     * @param name
     * @param selectedValue
     * @param options
     */
    public HTMLSelect(String name, String selectedValue, List<HTMLOption> options) {
        this.name = name;
        this.selectedValue = selectedValue;
        this.options = options;
    }

    /**
     *
     * @param name
     * @param selectedValue
     * @param optionValues
     */
    public HTMLSelect(String name, String selectedValue, String... optionValues) {
        this.name = name;
        this.selectedValue = selectedValue;
        options = new ArrayList();
        for (String optionValue : optionValues) 
            options.add(new HTMLOption(optionValue,optionValue));
    }

    /**
     *
     * @param name
     * @param selectedValue
     * @param postfix
     * @param start
     * @param end
     */
    public HTMLSelect(String name, String selectedValue, String postfix, int start, int end) {
        this.name = name;
        this.selectedValue = selectedValue;
        options = new ArrayList();
        for (int v = start; v <= end; v+=30) 
            options.add(new HTMLOption(""+v,""+v+postfix));
        
    }
    
    

    @Override
    public String toString() {
        String result = "<select name='" + name + "' >\n";
        for (HTMLOption option : options) 
            result+=option;
        return result+"</select>\n";
    }
    
    /**
     *
     */
    public class HTMLOption {
        private final String value;
        private final String display;

        /**
         *
         * @param value
         * @param display
         */
        public HTMLOption(String value, String display) {
            this.value = value;
            this.display = display;
        }

        @Override
        public String toString() {
            if (value.equals(selectedValue))
                return "  <option value='" + value + "' selected='selected'>" + display + "</option>\n";
            else
                return "  <option value='" + value + "'>" + display + "</option>\n";

        }
        
        
        
    }
    
}

/**
 * Add your own comments
 */

import java.util.*;
public class HtmlValidator {
    private static final String INDENTATIONMARKER = "    ";
    private Queue<HtmlTag> tags;

    /**
     * Create an empty HtmlValidator
     */

    public HtmlValidator() {
        tags = new LinkedList<>();
    }

    /**
     * Create an HtmlValidator with the content of tags
     * @param tags the content of new HtmlValidator
     */

    public HtmlValidator(Queue<HtmlTag> tags){
        if (tags == null) {
            throw new IllegalArgumentException("Initial tags cannot be null");
        }
        //create a deep copy of the input queue
        this.tags = new LinkedList<>(tags);
    }
    /**
     * Add a tag to the end of the HTMLValidator
     * @param tag the tag to be added
     */

    public void addTag(HtmlTag tag){
        if(tag == null){
            throw new IllegalArgumentException("Cannot add a null tag");
        }
        tags.add(tag);
    }

    /**
     * Get a deep copy of the tags in HtmlValidator
     * @return A deep copy of the tags in HtmlValidator
     */

    public Queue<HtmlTag> getTags(){
        //return a deep copy of the tags in htmlvalidator
        return new LinkedList<>(tags);
    }

    /**
     * remove all tags matching element
     * @param element the type of tag to be removed
     */
    public void removeAll(String element){
        if(element == null){
            throw new IllegalArgumentException("Cannot remove null tag");
        }

        tags.removeIf(n -> (n.matches));

        Queue<HtmlTag> filteredTags = new LinkedList<>(){
            for(HtmlTag tag:tags){
                if(!tag.getElement().equalsIgnoreCase(element)){
                    filteredTags.add(tag);
                }
            }

            tags = filteredTags;

            /**
             * Print Formatted HTML based on the content of the HTMLValidator. The
             * output is indented according to tag depth.
             *
             * Unexpected and Unclosed Tags are printed as error message at 0 Depth.
             */

            public void validate(){
                Stack<HtmlTag> openTags = new Stack<>();
                for(int i = 0; i < tags.size(); i++){
                    //for(HtmlTag tag:tags) { IS NOT ALLOWED by the spec
                    //because we can't use a foreach loop.
                    HtmlTag tag = tags.remove();
                    tags.add(tag);

                    //TODO: TAG CONDITIONALS

                    if(tag.isSelfClosing()){

                    } else if (tag.isOpenTag()){

                    } else if (!openTags.isEmpty() && tag.matches(openTags.peek())){
                        //by exhaustion, the tag must be a closed tag.
                        // closing tags should be at the same depth as opening tags, so we pop
                        // before printing those values.
                    } else {
                        //print the correct message for unexpected tags based on the spec.
                    }

                    /*
                    Dealing with unclosed tags.
                     */

                    while(!openTags.isEmpty()){
                        HtmlTag tag = ;
                        System.out.println("ERROR unclosed tag" + ....);
                    }

                    //Helper Function: make printing at given indentation more convenient.
                    private static void printWithIndentation(HtmlTag tag, int indentationLevel){
                        StringBuilder sb = ....
                        for(){} .... //be sure to append the indentation marker.

                        //TODO: Make sure to print out the sb.toString()
                    }

                }
            }
        }
    }
}

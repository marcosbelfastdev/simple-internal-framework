package sites.venturus.data;

public interface FormItemsData {
    /*
    This could be a client to get data from a database or a json file.
    I'll keep this simple for the sake of time saving
     */


    String FORM_ITEMS_LABEL = "TreeSelect";

    String[] COUNTRIES = {"Brazil",
            "United Kingdom",
            "United States",
            "Portugal"}; // and other countries do add here

    String CORRECT_INPUT_DATA = "This is an alphanumeric text 1";
    String INCORRECT_INPUT_DATA = "This is not :) an alphanumeric text 10";

}

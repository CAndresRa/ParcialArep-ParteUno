package edu.escuelaing.arep;

import edu.escuelaing.arep.model.OperationService;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        port(getPort());

        get("/", (req, res) -> {
            return "<html>\n" +
                    "<head>\n" +
                    "  <title>Parcial</title>\n" +
                    "</head>\n" +
                    "  <div style=\"margin:auto\">\n" +
                    "    <h1>Parcial Andres Ramirez</h1>\n" +
                    "    <form method=\"post\" action=\"/calculate\">\n" +
                    "      <p><b>Instructions:</b> Insert a set of  numbers separated by commas (,) and hit the 'Calculate' button.</p>\n" +
                    "      <p><b>Example:</b> 1.0 or 1</p>\n" +
                    "      <input type=\"number\" required=\"true\" name=\"number\"/>\n" +
                    "      <p><b>Example:</b> tan or  cos or sin</p>\n" +
                    "      <input type=\"text\" required=\"true\" name=\"operation\"/>\n" +
                    "      <input type=\"submit\" value=\"Calculate\"/>\n" +
                    "    </form>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "</html>";
        });

        post("/calculate", (req, res) -> {
            System.out.println(req.queryParams("number"));
            System.out.println(req.queryParams("operation"));
            String result  = "Invalido";
            if(checkOperation(req.queryParams("operation"))){
                Double number = Double.parseDouble(req.queryParams("number"));
                OperationService operationService = new OperationService(req.queryParams("operation"), number);
                result = operationService.getResult();
                //gson.toJson(result);
            } else {
                result = "Verifique los datos de entrada";
            }
            return "<html>\n" +
                        "<head>\n" +
                        "  <title>Parcial</title>\n" +
                        "</head>\n" +
                        "  <div style=\"margin:auto\">\n" +
                        "    <h1>Parcial Andres Ramirez</h1>\n" +
                        "    <form method=\"post\" action=\"/calculate\">\n" +
                        "      <p><b>Instructions:</b> Insert a set of  numbers separated by commas (,) and hit the 'Calculate' button.</p>\n" +
                        "      <p><b>Example:</b> 1.0 or 1 ...</p>\n" +
                        "      <input type=\"number\" required=\"true\" name=\"number\"/>\n" +
                        "      <p><b>Example:</b> tan or  cos or sin</p>\n" +
                        "      <input type=\"text\" required=\"true\" name=\"operation\"/>\n" +
                        "      <input type=\"submit\" value=\"Calculate\"/>\n" +
                        "    </form>\n" +
                        "  <div>\n" +
                        "    <label>"+ result +"</label>\n" +
                        "  </div>\n" +
                        "  </div>\n" +
                        "</body>\n" +
                    "</html>";
        });
    }

    /**
     * Check if the user changed the operation
     * @param inputLine Line entered by customer
     */
    public static boolean checkOperation(String inputLine){
        boolean operationIsValid = false;
        if(inputLine.contains("sin")) {
            operationIsValid = true;
        }
        else if (inputLine.contains("cos")){
            operationIsValid = true;
        }
        else if (inputLine.contains("tan")){
            operationIsValid = true;
        }
        else {
            operationIsValid = false;
        }
        return operationIsValid;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}

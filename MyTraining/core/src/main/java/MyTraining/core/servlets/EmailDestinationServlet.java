package MyTraining.core.servlets;




        import MyTraining.core.services.EmailDestinationService;
        import org.apache.sling.api.SlingHttpServletRequest;
        import org.apache.sling.api.SlingHttpServletResponse;
        import org.apache.sling.api.servlets.HttpConstants;
        import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
        import org.osgi.service.component.annotations.Component;
        import org.osgi.service.component.annotations.Reference;

        import javax.servlet.Servlet;
        import javax.servlet.ServletException;
        import java.io.IOException;

@Component(service = Servlet.class,
        property = {"sling.servlet.methods="+ HttpConstants.METHOD_GET,
                "sling.servlet.paths=/bin/emailDestination"})
public class EmailDestinationServlet extends SlingSafeMethodsServlet {


    @Reference
    EmailDestinationService emailDestinationService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String destination = request.getParameter("destination");
        response.getWriter().println("email : "+email +"  "+"\t\t destination : "+destination);
    }
}

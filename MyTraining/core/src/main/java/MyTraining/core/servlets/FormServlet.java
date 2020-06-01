package MyTraining.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.jcr.Node;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
/**
 * servlet to save form data to node.
 */
@Component(service = Servlet.class, property = {
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=/bin/FormServletDemo"})
public class FormServlet extends SlingSafeMethodsServlet {

    @Override
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        response.getWriter().println("servlet is being called");
        String fName = request.getParameter("first_name");
        String lname = request.getParameter("last_name");
        String email = request.getParameter("email");

      /*  Node node = request.adaptTo(Node.class);
        try {
            node.addNode("new");
            node.setPrimaryType("cq:page");
        } catch (RepositoryException e) {
            e.printStackTrace();
        }*/

        if (fName == null || fName.isEmpty() && lname == null || lname.isEmpty() && email == null
                || email.isEmpty()) {
            out.println(" Please fill required field");
        } else {


            ResourceResolver resolver = request.getResourceResolver();
            Resource parent = resolver.getResource("/content/Tests");
            if(parent==null){
                Resource content = resolver.getResource("/content");
                String childName = ResourceUtil.createUniqueChildName(content,"Tests");
                parent = ResourceUtil.getOrCreateResource(resolver,"/content/"+childName,"nt:unstructured","nt:unstructured",false);
            }
            //Node node = parent.getResourceResolver().adaptTo(Node.class);

            String childName = ResourceUtil.createUniqueChildName(parent,"timestamp");
            Resource child = ResourceUtil.getOrCreateResource(resolver,parent.getPath()+"/"+childName,"nt:unstructured","nt:unstructured",false);
            ModifiableValueMap childMap = child.adaptTo(ModifiableValueMap.class);
            childMap.put("f_name",fName);
            childMap.put("l_name",lname);
            childMap.put("email",email);
            resolver.commit();
            resolver.close();

//                Node newnode = node.addNode("nodex");
//                ResourceUtil.createUniqueChildName()
//                newnode.setProperty("f_name", fName);
//                newnode.setProperty("l_name", lname);
//                newnode.setProperty("email", email);
//                node.getSession().save();
//                request.getResourceResolver().commit();
            out.println(" thank you");


        }
    }
}
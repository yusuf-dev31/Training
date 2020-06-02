package MyTraining.core.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, property = {
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths=/bin/MovieGenre"})
public class DropdownServlet extends SlingAllMethodsServlet
{

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        String movie_gen = request.getParameter("movieGen");
      ///  System.out.println("check status="+movie_gen);
        out.println(movie_gen);
        if (movie_gen == null || movie_gen.isEmpty()) {
            out.println("Could not found any Value please try again !!");
        } else {
            ResourceResolver resolver= request.getResourceResolver();
            Resource res= resolver.getResource("/content/drop-down");
            if(res==null){
                Resource resolv= resolver.getResource("/content");
                String child= ResourceUtil.createUniqueChildName(resolv,"drop-down");
                res= ResourceUtil.getOrCreateResource(resolver,"/content/"+child,"sling:folder","nt:unstructured",false);
            }
            String child = ResourceUtil.createUniqueChildName(res,"drop-down-child");
            Resource childName = ResourceUtil.getOrCreateResource(resolver,res.getPath()+"/"+child,"nt:unstructured","nt:unstructured",false);
            ModifiableValueMap map = childName.adaptTo(ModifiableValueMap.class);
            map.put("movieGen", movie_gen);
            request.getResourceResolver().commit();
            resolver.close();
             out.println("<br>Movie Genre saved at: " +childName.getPath());
        }
    }
}


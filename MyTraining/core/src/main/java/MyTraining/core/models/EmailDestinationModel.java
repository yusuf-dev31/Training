package MyTraining.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmailDestinationModel {

    String pagePath;
    String title;
    String email;
    List<String> location = new ArrayList<String>();

    @SlingObject
    Resource resource;

    @PostConstruct
    public void activate()
    {
        if(resource.getValueMap().get("pagepath",String.class) !=null && resource.getValueMap().get("email",String.class)!=null){
            String path = resource.getValueMap().get("pagepath",String.class);
            title = resource.getResourceResolver().getResource(path).getName();
            email = resource.getValueMap().get("email",String.class);
        }

       String [] locpath = resource.getValueMap().get("location", String[].class);
        if (locpath != null) {
          //  locpath = new String[locpath.length];

            for (int i = 0; i < locpath.length; i++) {

                location.add(locpath[i]);

            }
        }
    }

    public String getTitle()
    {
        return title;
    }

    public String getEmail()
    {
        return email;
    }

    public List<String> getLocation()
    {
        return location;
    }

}

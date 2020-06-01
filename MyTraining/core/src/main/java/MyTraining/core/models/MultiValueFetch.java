package MyTraining.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiValueFetch
{
    @SlingObject
    Resource resource;

Map map=new HashMap<String,String>();
    @PostConstruct
        public void activate()
            {
                Resource multi=resource.getChild("multi");
                if(multi!=null)
                {
                    Iterator it = multi.listChildren();
                    while (it.hasNext()) {
                        Resource item = (Resource) it.next();
                        if (item.getValueMap().get("Title", String.class) == null && item.getValueMap().get("viewLink", String.class )==null) {
                            map.put("please enter the value",null);

                        } else {
                            map.put(item.getValueMap().get("Title", String.class),item.getValueMap().get("viewLink", String.class));

                        }
                        //    marks=item.getValueMap().get("studentmarks", String[].class);

                    }
                }

            }
    public Map<String,String> getValue()
    {
        return map;
    }
}

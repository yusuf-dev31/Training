package MyTraining.core.models;

import java.util.ArrayList;
import java.util.List;
import MyTraining.core.services.DropdownService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DropDownModel {
    List<String> value=new ArrayList<>();
    @OSGiService
    DropdownService dropdownService;

   /* @Inject
    String movieGen;
    String name;*/
    @SlingObject
    Resource resource;
    @PostConstruct
    protected void activate()
    {
        if (dropdownService.getDisplayValue() != null)

    {
      // name = resource.getValueMap().get("movieGen", String.class);
        value = dropdownService.getDisplayValue();

    }
    }
    public List<String> getDropDownValue()
    {
        return this.value;
    }
  /*  public String getName()
    { return this.name;}*/
}
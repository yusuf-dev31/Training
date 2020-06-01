package MyTraining.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoModel
{
    @SlingObject
    Resource resource;
    @Inject
    private String[] pages;
    private String name;
    @Inject
    String path;
    String[] pageName;
    @PostConstruct
    public void activate()
    {
        name = resource.getValueMap().get("path", String.class);

        pages = resource.getValueMap().get("pages", String[].class);
        if (pages != null) {
            pageName = new String[pages.length];

            for (int i = 0; i < pages.length; i++) {

                pageName[i] = resource.getResourceResolver().getResource(pages[i]).getName();

            }
        }

    }

        public String getPage ()
        {
            return name;

        }
    public String[] getPageName ()
    {
        return pageName;

    }

}



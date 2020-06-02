package MyTraining.core.services.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import MyTraining.core.services.DropdownService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(immediate = true, service = DropdownService.class)
@Designate(ocd = DropdownServiceImpl.DisplayValueConfig.class)

public class DropdownServiceImpl implements DropdownService {
    List<String> message = new ArrayList<>();
    @Activate
    protected void activate(DisplayValueConfig config) {
        this.message = Arrays.stream(config.message()).collect(Collectors.toList());
    }
    @Modified
    protected void modified(DisplayValueConfig config) {
        this.message = Arrays.stream(config.message()).collect(Collectors.toList());
    }
    @Override
    public List<String> getDisplayValue() {
        return this.message;
    }
    @ObjectClassDefinition(name = "Display Movie Genre")
    public @interface DisplayValueConfig {
        @AttributeDefinition(
                name = "value"
        )
        String[] message();
    }
}

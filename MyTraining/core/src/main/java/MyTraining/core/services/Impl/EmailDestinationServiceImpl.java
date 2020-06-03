package MyTraining.core.services.Impl;

        import MyTraining.core.services.EmailDestinationService;
        import org.osgi.service.component.annotations.Component;

@Component(service = EmailDestinationService.class)
public class EmailDestinationServiceImpl implements EmailDestinationService {

    String email;
    String destination;


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }


}

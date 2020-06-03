package MyTraining.core.services;

public interface EmailDestinationService {
    String getEmail ();
    String getDestination();
  void setEmail (String email);
  void setDestination(String destination);
}

import camundajar.impl.com.google.gson.Gson;
import com.incedo.workflow.model.*;

import java.time.LocalDate;

public class JsonUtilityTest {
    public static void main(String[] args){
        System.out.println("Test");
        OnBoardApplication application = new OnBoardApplication();
        application.setApplicationId(123456L);
        Customer customer = new Customer();
        customer.setCustomerId(10001L);
        customer.setSsn("123-456-7890");
        Name name = new Name();
        name.setFirstName("BankApp");
        name.setLastName("Camunda");
        name.setMiddleName("Incedo");
        customer.setPrimaryName(name);
        Address address = new Address();
        address.setAddressId(20001L);
        address.setStreet1("222 1st Ave");
        address.setCity("Newyork");
        address.setZip("10004");
        address.setState("NY");
        customer.setAddress(address);
        customer.setDateOfBirth(LocalDate.now());
        CustomerContact customerContact = new CustomerContact();
        customerContact.setCustomerContactId(30001L);
        customerContact.setEmail("test@incedoinc.com");
        Phone phone = new Phone();
        phone.setPhoneNum("3334567890");
        customerContact.setCellPhone(phone);
        customer.setCustomerContact(customerContact);
        application.setStartTime(LocalDate.now());
        application.setApplicationTypeCode("401K");
        application.setStatusCode("InProgress");
        application.setCustomer(customer);

        System.out.println(new Gson().toJson(application));
    }
}
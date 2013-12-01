import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;
public class DomainGenerator {
	  public static void main(String[] args) throws Exception {
	        Schema schema = new Schema(3, "com.example.ormsample.domain");

	       addPerson(schema);
	       // addCustomerOrder(schema);

	        new DaoGenerator().generateAll(schema, "../ORMSample/gen");
	    }
	  
	  private static void addPerson(Schema schema){
		  Entity person = schema.addEntity("Person");
		  person.addIdProperty();
		  person.addStringProperty("fname").notNull();
		  person.addStringProperty("lname").notNull();
		  person.addStringProperty("minitial");
		  person.addStringProperty("comment");
		  person.addDateProperty("createdOn");
		  
		  Entity phoneNumber = schema.addEntity("PhoneNumber");
		  phoneNumber.addIdProperty();
		  phoneNumber.addIntProperty("countryCode").notNull();
		  phoneNumber.addIntProperty("areaCode").notNull();
		  phoneNumber.addIntProperty("prefix").notNull();
		  phoneNumber.addIntProperty("suffix").notNull();
		  Property phoneNumberPersonId = phoneNumber.addLongProperty("personId").notNull().getProperty();
		  ToMany personPhoneNumbers = person.addToMany(phoneNumber,phoneNumberPersonId);
		  personPhoneNumbers.setName("phoneNumbers");
		  
	  }
	  
}

package payloads;

public class Payload {
    public static String createUser(
            String title,
            String firstName,
            String lastName,
            String picture,
            String gender,
            String email,
            String dateOfBirth,
            String phone,
            String street,
            String city,
            String state,
            String country,
            String timezone
    ) {
        return "{\n" +
                "    \"title\": \"" + title + "\",\n" +
                "    \"firstName\": \"" + firstName + "\",\n" +
                "    \"lastName\": \"" + lastName + "\",\n" +
                "    \"picture\": \"" + picture + "\",\n" +
                "    \"gender\": \"" + gender + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"dateOfBirth\": \"" + dateOfBirth + "\",\n" +
                "    \"phone\": \"" + phone + "\",\n" +
                "    \"location\": {\n" +
                "        \"street\": \"" + street + "\",\n" +
                "        \"city\": \"" + city + "\",\n" +
                "        \"state\": \"" + state + "\",\n" +
                "        \"country\": \"" + country + "\",\n" +
                "        \"timezone\": \"" + timezone + "\"\n" +
                "    }\n" +
                "}";
    }
}

import java.util.Map;
import java.util.HashMap;


public class GenerateEmployeeEmailAddresses {


    public static void main(String args[]) {
        GenerateEmployeeEmailAddresses e = new GenerateEmployeeEmailAddresses();
        System.out.println(e.Solution("example", "John Doe"));
        System.out.println(e.Solution("example", "Peter Benjamin Parker"));
        System.out.println(e.Solution("example", "John Elvis Doe"));
        System.out.println(e.Solution("example", "John Evan Doe"));
        System.out.println(e.Solution("example", "Peter Brian Parker"));

    }

    public String Solution(String C, String S) {
        StringBuffer finalEmailList = new StringBuffer();
        Map<String, Integer> emailOccurence = new HashMap<>();
        String[] employeeList = S.split("; ");
        for (String employeeName : employeeList) {
            String[] splitName = employeeName.split(" ");
            String firstName = splitName[0].replace("-", "").toLowerCase();
            String lastName = splitName[splitName.length - 1].replace("-", "").toLowerCase();
            String email = firstName + "." + lastName + '@' + C.toLowerCase() + ".com";
            String empEmail = employeeName + " <" + email + ">" + "; ";
            if (!emailOccurence.containsKey(email)) {
                emailOccurence.put(email, 1);
                finalEmailList.append(empEmail);
            } else {
                Integer count = emailOccurence.get(email) + 1;
                emailOccurence.put(email, count);
                String empEmailWithCount = employeeName + " <" + firstName + "." + lastName + count + '@' + C.toLowerCase() + ".com" + ">" + "; ";
                finalEmailList.append(empEmailWithCount);
            }

        }

        return finalEmailList.toString();
    }
}

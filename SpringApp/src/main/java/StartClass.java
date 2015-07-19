import firstPack.JavaContactService;
import firstPack.Test.ContactTests;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Stas on 27.06.2015.
 */
public class StartClass {

    static ArrayList<String> commands;
    static
    {
        commands = new ArrayList<String>();
        commands.add("Type one of the following command below (exactly like in the example)");
        commands.add("To create contact type: 1; firstName ; lastName ; birthday (yyyy-mm-dd)");
        commands.add("To add hobby type: 2; hobbyName ; hobbyDescription");
        commands.add("To add place type: 3; placeName ; placeDescription ; longitude ; altitude");
        commands.add("To add friendship type: 4; firstFriendFirstName; firstFriendLastName ; secondFriendFirstName ; secondFriendLastName");
        commands.add("To get friendList type: 5; name");
        commands.add("To get conversation type: 6; firstFriendName ; secondFriendName");
        commands.add("If you want to exit type: 7");
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context-Application.xml");

        JavaContactService service = context.getBean(JavaContactService.class);

        //���������� �� ����� ���������� � ��������� �������� � �������� ����� ����������
        for (String text: commands)
        {
            System.out.println(text);
        }

        //�������� ������� ����
        boolean isWorking = true;
        while (isWorking)
        {
            isWorking = execution(service);
        }
    }

    public static boolean execution (JavaContactService service)
    {
        Scanner scanner = new Scanner (System.in);
        //��������� �����, ��������� ������������� � �������, �� ����� �� ������� ";"
        String[] userAnswer = scanner.nextLine().split(";");

        //���������� ����� ������� ���� ������������ � ��������� ��������������� ��������
        switch(Integer.parseInt(userAnswer[0]))
        {
            case 1:
            {
                String firstName = userAnswer[1].replaceAll(" ","");
                String lastName = userAnswer[2].replaceAll(" ","");
                LocalDate birthday = LocalDate.parse(userAnswer[3]);
                service.createContact(firstName,lastName,birthday);

                System.out.println("Contact was created");

                return true;
            }
            case 2:
            {
                String title = userAnswer[1].replaceAll(" ","");
                String description = userAnswer[2];
                service.addHobby(title,description);

                System.out.println("Hobby was added");

                return true;
            }
            case 3:
            {
                String title = userAnswer[1].replaceAll(" ","");
                String description = userAnswer[2];
                double longitude = Double.parseDouble(userAnswer[3].replaceAll(" ",""));
                double latitude = Double.parseDouble(userAnswer[4].replaceAll(" ",""));
                service.addPlace(title,description,longitude,latitude);

                System.out.println("Place was added");

                return true;
            }
            case 4:
            {
                String firstFriendFirstName = userAnswer[1].replaceAll(" ","");
                String firstFriendLastName = userAnswer[2].replaceAll(" ","");
                String secondFriendFirstName = userAnswer[3].replaceAll(" ","");
                String secondFriendLastName = userAnswer[4].replaceAll(" ","");

                //�������� �� ������������ ����� (���������� ������ �������� ������ ���� ������ ����)
                if(firstFriendFirstName.equals(secondFriendFirstName)&&secondFriendFirstName.equals(secondFriendLastName))
                {
                    System.out.println("You are trying to add friendship to the same person. Are you insane?");
                    System.out.println("Try one more time from the beginning");
                    return true;
                }

                service.addFriendship(firstFriendFirstName,firstFriendLastName,secondFriendFirstName,secondFriendLastName);
                return true;
            }
            case 5:
            case 6:
            case 7:return false;
            default:
            {
                System.out.println("You wrote wrong command number");
                return true;
            }
        }
    }
}

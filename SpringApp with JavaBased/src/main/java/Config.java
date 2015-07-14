import firstPack.DAO.ContactDao;
import firstPack.DAO.HobbyDao;
import firstPack.DAO.MessageDao;
import firstPack.DAO.PlaceDao;
import firstPack.JavaContactService;
import firstPack.rootClasses.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Stas on 04.07.2015.
 */
@Configuration
public class Config {
    @Bean
    public JavaContactService service ()
    {
        return new JavaContactService();
    }
    @Bean
    public ContactDao contactDAO ()
    {
        return new ContactDao();
    }
    @Bean
    public HobbyDao hobbyDAO ()
    {
        return new HobbyDao();
    }
    @Bean
    public PlaceDao placeDAO ()
    {
        return new PlaceDao();
    }
    @Bean
    public MessageDao messageDAO ()
    {
        return new MessageDao();
    }

}

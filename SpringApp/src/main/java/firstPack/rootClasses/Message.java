package firstPack.rootClasses;

import java.time.LocalDateTime;

/**
 * Created by Stas on 17.06.2015.
 */
public class Message
{
    LocalDateTime date;
    Contact from;
    Contact to;
    String content;

    public Message(LocalDateTime date, Contact from, Contact to, String content) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.content = content;
    }
}

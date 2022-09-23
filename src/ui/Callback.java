
package ui;

import chatbot.Bot;
import chatbot.User;

/**
 *
 * @author Osama
 */
public interface Callback {
    public void setUser(User u);
    public void setBot(Bot b);
}

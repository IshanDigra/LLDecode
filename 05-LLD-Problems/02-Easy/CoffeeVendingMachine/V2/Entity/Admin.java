package V2.Entity;

import V2.Enum.*;
import V2.Service.Notification.Observer;

import java.util.*;
import java.util.logging.Logger;

public class Admin implements Observer {
    private static final Logger logger = Logger.getLogger(Admin.class.getName());


    public void update(Ingredient ingredient) {
        logger.info("Dear admin "+ingredient+" quantity is low. Please restock it.");
    }


}

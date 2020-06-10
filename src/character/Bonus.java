package src.character;
import java.util.*;
import src.support.*;


public interface Bonus {
    public int checkBonus(String rollType, String subtype, Traveller.TravellerBuilder character);

}
package views.formData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgnalle on 3/30/2015.
 */
public class TelephoneTypes {
  private static final Map<String, Boolean> ALLTYPES = new HashMap<String, Boolean>() {
    {
      put("Home", false);
      put("Work", false);
      put("Cell", false);
      put("Fax", false);
    }
  };

  /**
   * Returns a list of all possible types of telephone numbers mapped to false.
   * @return The list of types.
   */
  public static Map<String, Boolean> getTypes() {
    return ALLTYPES;
  }

  /**
   * Checks if a telephone type is a valid type.
   * @param type The type to check.
   * @return True if the type is valid. False otherwise.
   */
  public static Boolean isType(String type) {
    return ALLTYPES.containsKey(type);
  }

  /**
   * Returns a list of telephone types mapped to 'false' except 'type'.
   * @param type The type to map to true.
   * @return The map of types.
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> tmp = new HashMap<String, Boolean>();
    tmp.putAll(ALLTYPES);

    if (isType(type)) {
      tmp.put(type, true);
    }

    return tmp;
  }
}

package views.formData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.DietType;

/**
 * Created by wgnalle on 3/30/2015.
 */
public class DietTypes {
  private static final Map<String, Boolean> ALLTYPES = new HashMap<String, Boolean>() {
    {
      put("Chicken", false);
      put("Fish", false);
      put("Beef", false);
      put("Dairy", false);
      put("Gluten", false);
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
  public static Boolean isType(DietType type) {
    return ALLTYPES.containsKey(type.getDietType());
  }

  /**
   * Returns a list of telephone types mapped to 'false' except 'type'.
   * @param types The type to map to true.
   * @return The map of types.
   */
  public static Map<String, Boolean> getTypes(List<DietType> types) {
    Map<String, Boolean> tmp = new HashMap<String, Boolean>();
    tmp.putAll(ALLTYPES);

    for (DietType type : types) {
      if (isType(type)) {
        tmp.put(type.getDietType(), true);
      }
    }

    return tmp;
  }
}

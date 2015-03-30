package views.formData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgnalle on 3/30/2015.
 */
public class TelephoneTypes {
  private static final Map<String, Boolean> allTypes = new HashMap<String, Boolean>() {
    {
      put("Home", false);
      put("Work", false);
      put("Cell", false);
      put("Fax", false);
    }
  };

  public static Map<String, Boolean> getTypes() {
    return allTypes;
  }

  public static Boolean isType(String type) {
    return allTypes.containsKey(type);
  }

  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> tmp = new HashMap<String, Boolean>();
    tmp.putAll(allTypes);

    if (isType(type)) {
      tmp.put(type, true);
    }

    return tmp;
  }
}

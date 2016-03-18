package interfaces;

import java.text.ParseException;
import java.util.Map;

public interface ParcerInterface {
public Map<String, Object> parceEntry() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException;
public Map<String,Object> validateFields(Object obj);
}

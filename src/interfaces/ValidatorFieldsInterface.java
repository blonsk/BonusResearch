package interfaces;

import java.util.*;

public interface ValidatorFieldsInterface {
	Map<String,Integer> findFieldsNums();
	Map<String,Object> validateFields(Set<String> neededFields);
}

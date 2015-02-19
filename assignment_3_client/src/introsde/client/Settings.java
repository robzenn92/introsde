package introsde.client;

public final class Settings {
	
	public static final String METH_01 = "Method #1: readPersonList()";
	public static final String METH_02 = "Method #2: readPerson(Long id)";
	public static final String METH_03 = "Method #3: updatePerson(Person p)";
	public static final String METH_04 = "Method #4: createPerson(Person p)";
	public static final String METH_05 = "Method #5: deletePerson(Long id)";
	public static final String METH_06 = "Method #6: readPersonHistory(Long id, String measureType)";
	public static final String METH_07 = "Method #7: readPersonMeasurement(Long id, String measureType, Long mid)";
	public static final String METH_08 = "Method #8: savePersonMeasurement(Long id, Measure m)";
	public static final String METH_09 = "Method #9: readMeasureTypes()";
	public static final String METH_10 = "Method #10: updatePersonMeasure(Long id, Measure m)";
	public static final String METH_11 = "Method #11: readPersonMeasureByDates(Long id, String measureType, Date before, Date after)";
	public static final String METH_12 = "Method #12: readPersonListByMeasurement(String measureType, String maxValue, String minValue)";
	
	public static final String RESULT = "Result: ";
}
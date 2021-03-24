package webDriver.fourthProject_framework.service;

import webDriver.fourthProject_framework.model.FormParameters;

public class FillingInFormParameters {
    public static final String TESTDATA_FORM_PARAMETERS_NUMBER_OF_INSTANCES = "testdata.formParameters.numberOfInstances";
    public static final String TESTDATA_FORM_PARAMETERS_OPERATING_SYSTEM_AND_SOFTWARE = "testdata.formParameters.operatingSystemAndSoftware";
    public static final String TESTDATA_FORM_PARAMETERS_MACHINE_CLASS = "testdata.formParameters.machineClass";
    public static final String TESTDATA_FORM_PARAMETERS_SERIES = "testdata.formParameters.series";
    public static final String TESTDATA_FORM_PARAMETERS_MACHINE_TYPE = "testdata.formParameters.machineType";
    public static final String TESTDATA_FORM_PARAMETERS_NUMBER_OF_GPUS = "testdata.formParameters.numberOfGPUs";
    public static final String TESTDATA_FORM_PARAMETERS_TYPE_OF_GPUS = "testdata.formParameters.typeOfGPUs";
    public static final String TESTDATA_FORM_PARAMETERS_LOCAL_SSD = "testdata.formParameters.localSSD";
    public static final String TESTDATA_FORM_PARAMETERS_DATACENTER_LOCATION = "testdata.formParameters.datacenterLocation";
    public static final String TESTDATA_FORM_PARAMETERS_COMMITED_USAGE = "testdata.formParameters.commitedUsage";

    public static FormParameters withFormParameters() {
        return new FormParameters(TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_OPERATING_SYSTEM_AND_SOFTWARE),
                TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_SERIES),
                TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_TYPE_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_FORM_PARAMETERS_COMMITED_USAGE));
    }
}
package webDriver.fourthProject_framework.model;

public class FormParameters {
    private String numberOfInstances;
    private String operatingSystemAndSoftware;
    private String machineClass;
    private String series;
    private String machineType;
    private String numberOfGPUs;
    private String typeOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String commitedUsage;

    public FormParameters(String numberOfInstances, String operatingSystemAndSoftware, String machineClass, String series, String machineType, String numberOfGPUs, String typeOfGPUs, String localSSD, String datacenterLocation, String commitedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemAndSoftware = operatingSystemAndSoftware;
        this.machineClass = machineClass;
        this.series = series;
        this.machineType = machineType;
        this.numberOfGPUs = numberOfGPUs;
        this.typeOfGPUs = typeOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.commitedUsage = commitedUsage;
    }

    public FormParameters(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public FormParameters() {
        super();
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystemAndSoftware() {
        return operatingSystemAndSoftware;
    }

    public void setOperatingSystemAndSoftware(String operatingSystemAndSoftware) {
        this.operatingSystemAndSoftware = operatingSystemAndSoftware;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getTypeOfGPUs() {
        return typeOfGPUs;
    }

    public void setTypeOfGPUs(String typeOfGPUs) {
        this.typeOfGPUs = typeOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }
}
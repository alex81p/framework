package com.example.service;

import com.example.model.google_cloud.ComputeEngineForm;

public class ComputeEngineFormCreator {

    public static final String NUMBER_OF_INSTANCES = "testData.computeEngineForm.numberOfInstances";
    public static final String OPERATING_SYSTEM = "testData.computeEngineForm.operatingSystem";
    public static final String PROVISIONING_MODEL = "testData.computeEngineForm.provisioningModel";
    public static final String SERIES = "testData.computeEngineForm.series";
    public static final String INSTANCE_TYPE = "testData.computeEngineForm.instanceType";
    public static final String GPU_TYPE = "testData.computeEngineForm.gpuType";
    public static final String GPU_COUNT = "testData.computeEngineForm.gpuCount";
    public static final String LOCAL_SSD = "testData.computeEngineForm.localSSD";
    public static final String REGION = "testData.computeEngineForm.region";
    public static final String COMMITMENT_TERM = "testData.computeEngineForm.commitmentTerm";

    public static ComputeEngineForm withDataFromProperty(){
        return ComputeEngineForm.builder()
                .numberOfInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES))
                .operatingSystem(TestDataReader.getTestData(OPERATING_SYSTEM))
                .provisioningModel(TestDataReader.getTestData(PROVISIONING_MODEL))
                .series(TestDataReader.getTestData(SERIES))
                .instanceType(TestDataReader.getTestData(INSTANCE_TYPE))
                .gpuType(TestDataReader.getTestData(GPU_TYPE))
                .gpuCount(TestDataReader.getTestData(GPU_COUNT))
                .localSSD(TestDataReader.getTestData(LOCAL_SSD))
                .region(TestDataReader.getTestData(REGION))
                .commitmentTerm(TestDataReader.getTestData(COMMITMENT_TERM))
                .build();
    }
}

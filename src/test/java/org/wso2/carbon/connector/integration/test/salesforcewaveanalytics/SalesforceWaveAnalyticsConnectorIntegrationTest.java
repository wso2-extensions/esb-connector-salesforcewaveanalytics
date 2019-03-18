/*
 *  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.connector.integration.test.salesforcewaveanalytics;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.connector.integration.test.base.ConnectorIntegrationTestBase;
import org.wso2.connector.integration.test.base.RestResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Salesforce Wave analytics integration test
 */
public class SalesforceWaveAnalyticsConnectorIntegrationTest extends ConnectorIntegrationTestBase {

    private Map<String, String> esbRequestHeadersMap = new HashMap<String, String>();
    private Map<String, String> apiRequestHeadersMap = new HashMap<String, String>();

    /**
     * Environment setup for Salesforce Wave Analytics.
     */
    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {

        addCertificatesToEIKeyStore("client-truststore.jks", "wso2carbon");

        String connectorName = System.getProperty("connector_name") + "-connector-" +
                System.getProperty("connector_version") + ".zip";
        init(connectorName);
        esbRequestHeadersMap.put("Accept-Charset", "UTF-8");
        esbRequestHeadersMap.put("Content-Type", "application/json");
        apiRequestHeadersMap.put("Accept-Charset", "UTF-8");
        apiRequestHeadersMap.put("Content-Type", "application/json");

        getApiConfigProperties();
        getAccessToken();
        String accessToken = connectorProperties.getProperty("accessToken");
        apiRequestHeadersMap.put("Authorization", "Bearer " + accessToken);

        Random rnd = new Random();
        char c = (char) (rnd.nextInt(26) + 'a');
        connectorProperties.setProperty("folderName", c + connectorProperties.getProperty("folderName"));
        Random rnd2 = new Random();
        char m = (char) (rnd2.nextInt(26) + 'a');
        connectorProperties.setProperty("name", m + connectorProperties.getProperty("name"));
    }

    private void getAccessToken() throws IOException, JSONException {

        Map<String, String> apiTokenRequestHeadersMap = new HashMap<String, String>();
        Map<String, String> apiParametersMap = new HashMap<String, String>();
        apiTokenRequestHeadersMap.put("Content-Type", "application/x-www-form-urlencoded");
        RestResponse<JSONObject> apiTokenRestResponse =
                sendJsonRestRequest(connectorProperties.getProperty("hostName") + "/services/oauth2/" +
                                "token?grant_type=refresh_token&client_id=" +
                                connectorProperties.getProperty("clientId") + "&client_secret=" +
                                connectorProperties.getProperty("clientSecret") + "&refresh_token=" +
                                connectorProperties.getProperty("refreshToken"),
                        "POST", apiTokenRequestHeadersMap, "", apiParametersMap);
        String accessToken = apiTokenRestResponse.getBody().get("access_token").toString();
        connectorProperties.put("accessToken", accessToken);
    }

    /**
     * Positive test case for listTopLevelResources method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "salesforcewaveanalytics {listTopLevelResources}" +
            " integration test with mandatory parameters.")
    public void listTopLevelResourcesWithMandatoryParameters() throws IOException, JSONException {

        String methodName = "listTopLevelResources";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listTopLevelResourcesMandatory.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getString("dashboards"), apiRestResponse.getBody().
                getString("dashboards"));
    }

    /**
     * Negative test case for listTopLevelResources method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "salesforcewaveanalytics {listTopLevelResources} " +
            "integration test with mandatory parameters.")
    public void listTopLevelResourcesNegative() throws IOException, JSONException {

        String methodName = "listTopLevelResources";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listTopLevelResourcesNegative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 404);
    }

    /**
     * Positive test case for listAnnotations method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListDashboardMandatory"},
            description = "salesforcewaveanalytics {listAnnotations} integration test with mandatory parameters.")
    public void testListAnnotationsMandatory() throws Exception {

        String methodName = "listAnnotations";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listAnnotationsMandatory.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/annotations?assetId=" +
                connectorProperties.getProperty("assetId");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getString("url"), apiRestResponse.getBody().
                getString("url"));
    }

    /**
     * Negative test case for listAnnotations method .
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListDashboardMandatory"},
            description = "salesforcewaveanalytics {listAnnotations} integration test.")
    public void testListAnnotationsNegative() throws Exception {

        String methodName = "listAnnotations";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listAnnotationsNegative.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/annotations?assetId=";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 400);
    }

    /**
     * Positive test case for createDashboard method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"}, description =
            "salesforcewaveanalytics {createDashboard} integration test with mandatory parameters.")
    public void testCreateDashboardMandatory() throws Exception {

        String methodName = "createDashboard";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_createDashboardMandatory.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/dashboards";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "POST",
                apiRequestHeadersMap, "api_createDashboardMandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 201);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 201);
    }

    /**
     * Negative test case for createDashboard.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"}, description =
            "salesforcewaveanalytics {createDashboard} integration test.")
    public void testCreateDashboardNegative() throws Exception {

        String methodName = "createDashboard";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_createDashboardNegative.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/dashboards";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "POST",
                apiRequestHeadersMap, "api_createDashboardNegative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 400);
    }

    /**
     * Positive test case for createDashboard with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"}, description =
            "salesforcewaveanalytics {createDashboard} integration test with optional parameters.")
    public void testCreateDashboardOptional() throws Exception {

        String methodName = "createDashboard";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_createDashboardOptional.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/dashboards?folderId=" +
                connectorProperties.getProperty("folderId");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 201);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Positive test case for listDashboard method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"}, description =
            "salesforcewaveanalytics {listDashboard} integration test with mandatory parameters.")
    public void testListDashboardMandatory() throws Exception {

        String methodName = "listDashboard";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listDashboardMandatory.json");
        String dId = esbRestResponse.getBody().getJSONArray("dashboards").getJSONObject(0).getString("id");
        connectorProperties.setProperty("dashboardId", dId);
        connectorProperties.setProperty("defaultAssetId", dId);
        connectorProperties.setProperty("assetId", dId);
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/dashboards";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getJSONArray("dashboards").getJSONObject(0).getString
                ("assetSharingUrl"), apiRestResponse.getBody().getJSONArray("dashboards").getJSONObject(0).
                getString("assetSharingUrl"));
    }

    /**
     * Negative test case for listDashboard method.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory", "testListDashboardMandatory"},
            description = "salesforcewaveanalytics {listDashboard} integration test with optional parameters .")
    public void testListDashboardNegative() throws Exception {

        String methodName = "listDashboard";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_listDashboardNegative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 404);
    }

    /**
     * positive test case for updateDashboard method with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory", "testListDashboardMandatory"},
            description = "salesforcewaveanalytics {updateDashboard} integration test with optional parameters .")
    public void testUpdateDashboardOptional() throws Exception {

        String methodName = "updateDashboard";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_updateDashboardOptional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Positive test case for listTemplates method with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "salesforcewaveanalytics " +
            "{listTemplate} integration test with optional parameters.")
    public void testListTemplateOptional() throws Exception {

        String methodName = "listTemplate";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listTemplateOptional.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/templates?type="
                + connectorProperties.getProperty("type");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getJSONArray("templates").getJSONObject(0).getString
                ("assetIcon"), apiRestResponse.getBody().getJSONArray("templates").getJSONObject(0).
                getString("assetIcon"));
    }

    /**
     * Negative test case for listTemplate method .
     */
    @Test(groups = {"wso2.esb"}, description = "salesforcewaveanalytics {listTemplate} integration test.")
    public void testListTemplateNegative() throws Exception {

        String methodName = "listTemplate";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listTemplateNegative.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/templates?type=" +
                connectorProperties.getProperty("typeNeg");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 400);
    }

    /**
     * positive test case for listDataset method with Mendatory parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"}, description =
            "salesforcewaveanalytics {listDataset} integration test with mendatory parameters .")
    public void testListDatasetMendatory() throws Exception {

        String methodName = "listDataset";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listDatasetMendatory.json");
        String cId = esbRestResponse.getBody().getJSONArray("datasets").getJSONObject(0).getString
                ("currentVersionId");
        connectorProperties.setProperty("currentVersionId", cId);
        String dsId = esbRestResponse.getBody().getJSONArray("datasets").getJSONObject(0).getString
                ("id");
        connectorProperties.setProperty("datasetId", dsId);
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/datasets";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint,
                "GET", apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getJSONArray("datasets").getJSONObject(0).getString
                ("currentVersionId"), apiRestResponse.getBody().getJSONArray("datasets").getJSONObject(0).
                getString("currentVersionId"));
    }

    /**
     * Negative test case for listDataset method .
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"}, description =
            "salesforcewaveanalytics {listDataset} integration test.")
    public void testListDatasetNegative() throws Exception {

        String methodName = "listDataset";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_listDatasetNegative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 404);
    }

    /**
     * positive test case for updateDataset method with Mendatory parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory", "testListDatasetMendatory"},
            description = "salesforcewaveanalytics {updateDataset} integration test with mendatory parameters .")
    public void testUpdateDatasetMendatory() throws Exception {

        String methodName = "updateDataset";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_updateDatasetMandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for updateDataset method .
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory", "testListDatasetMendatory"},
            description = "salesforcewaveanalytics {updateDataset} integration test.")
    public void testUpdateDatasetNegative() throws Exception {

        String methodName = "updateDataset";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_updateDatasetNegative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 401);
    }

    /**
     * positive test case for listFolder method with Mendatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "salesforcewaveanalytics {listFolder} integration test with " +
            "mendatory parameters .")
    public void testListFolderMendatory() throws Exception {

        String methodName = "listFolder";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listFolderMendatory.json");
        String id = esbRestResponse.getBody().getJSONArray("folders").getJSONObject(0).getString("id");
        connectorProperties.setProperty("folderId", id);
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/"
                + connectorProperties.getProperty("apiVersion") + "/wave/folders";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getJSONArray("folders").getJSONObject(0).getString
                ("createdBy"), apiRestResponse.getBody().getJSONArray("folders").getJSONObject(0).
                getString("createdBy"));
    }

    /*
     * positive test case for listFolderById method with Mendatory parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"},
            description = "salesforcewaveanalytics {listFolderById} integration test with mendatory parameters .")
    public void testListFolderByIdMendatory() throws Exception {

        String methodName = "listFolderById";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listFolderByIdMendotory.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/folders/"
                + connectorProperties.getProperty("folderId");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getString("assetSharingUrl"), apiRestResponse.getBody().
                getString("assetSharingUrl"));
    }

    /**
     * positive test case for listFolderById method with Optional parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"},
            description = "salesforcewaveanalytics {listFolderById} integration test with optional parameters .")
    public void testListFolderByIdOptional() throws Exception {

        String methodName = "listFolderById";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listFolderByIdOptional.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/folders/"
                + connectorProperties.getProperty("folderId") + "?=mobileOnlyFeaturedAssets" +
                connectorProperties.getProperty("mobileOnlyFeaturedAssets");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getString("assetSharingUrl"), apiRestResponse.getBody().
                getString("assetSharingUrl"));
    }

    /**
     * Negative test case for listFolderById method .
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"},
            description = "salesforcewaveanalytics {listFolderById} integration test.")
    public void testListFolderByIdNegative() throws Exception {

        String methodName = "listFolderById";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_listFolderByIdNegative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 404);
    }

    /**
     * positive test case for listLense method with Mendatory parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"},
            description = "salesforcewaveanalytics {listLense} integration test with mendatory parameters .")
    public void testListLenseMendatory() throws Exception {

        String methodName = "listLense";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listLenseMendatory.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/lenses";
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET",
                apiRequestHeadersMap);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getString("lenses"), apiRestResponse.getBody().
                getString("lenses"));
    }

    /**
     * Negative test case for listLense method with Optional parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory"},
            description = "salesforcewaveanalytics {listLense} integration test.")
    public void testListLenseNegative() throws Exception {

        String methodName = "listLense";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "listLenseNegative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 404);
    }

    /**
     * Test case for replaceFolder method with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory", "testListDashboardMandatory"},
            description = "salesforcewaveanalytics " + "{replaceFolder} integration test with optional parameters .")
    public void testReplaceFolderOptional() throws Exception {

        String methodName = "replaceFolder";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap, "esb_replaceFolderOptional.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/folders/" +
                connectorProperties.getProperty("folderId");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "PUT",
                apiRequestHeadersMap, "api_replaceFolderOptional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(esbRestResponse.getBody().getString("defaultAsset"), apiRestResponse.getBody().
                getString("defaultAsset"));
    }

    /**
     * Negative test case for replaceFolder method .
     */
    @Test(groups = {"wso2.esb"}, dependsOnMethods = {"testListFolderMendatory", "testListDashboardMandatory"},
            description = "salesforcewaveanalytics " + "{replaceFolder} integration test with mendatory parameters .")
    public void testReplaceFolderNegative() throws Exception {

        String methodName = "replaceFolder";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", esbRequestHeadersMap,
                "esb_replaceFolderNegative.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/" +
                connectorProperties.getProperty("apiVersion") + "/wave/folders/" +
                connectorProperties.getProperty("folderId");
        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "PUT",
                apiRequestHeadersMap, "api_replaceFolderNegative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 400);
    }
}
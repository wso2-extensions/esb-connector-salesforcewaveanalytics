# Working with Dashboard

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview 

The following operations allow you to work with Dashboard, for the current organization. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with createDashboard, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [createDashboard](#Creates-the-dashboard)    | Creates the dashboard. |
| [listDashboard](#Returns-the-collection-of-the-dashboard)      | Returns the collection of the dashboard. |
| [updateDashboard](#Updates-the-dashboard)      | Updates the dashboard.|

### Operation details

This section provides more details on each of the operations.

#### Creates the dashboard
To create the dashboard, use salesforcewaveanalytics.createDashboard and specify the following property.

**createDashboard**
```xml
<salesforcewaveanalytics.createDashboard>
      <state>{$ctx:state}</state>
      <folderId>{$ctx:folderId}</folderId>
      <folderName>{$ctx:folderName}</folderName>
      <description>{$ctx:description}</description>
      <label>{$ctx:label}</label>
      <name>{$ctx:name}</name>
</salesforcewaveanalytics.createDashboard>
```

**Properties**
* state: The state of the dashboard.
* folderId: Folder in which this dashboard is stored.
* folderName: Folder in which this dashboard is stored.
* label: The label of the asset.
* description: Short description of the asset.
* name: The name of the asset.


**Sample request**

Following is a sample request that can be handled by the createDashboard operation.

```json
{
 "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
  "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPOO9pG5e8PvVODwZ4DSMgJJwfHSu_9TRyaIzt1r2",
  "clientSecret": "5478649612867397870",
  "hostName": "https://login.salesforce.com",
  "apiVersion": "v39.0",
  "registryPath":"connectors/salesforcewaveanalytics",
  "accessToken":"00D0o0000016avV!AQYAQHE9LTqCDUZIilIzLWtL4n7I1iJdMo7ci3Ra41QDVpJX86mV85QBCPl8LbqEFHjRmMEPS8BmYkRoKakL.i3KkQoeMHuL",
  "intervalTime" : "100000",
  "apiUrl":"https://ap8.salesforce.com",
   "state":{
    	"gridLayouts": 
    		 {
    		   "name": "Default",
    		    "version": 1
        	 },
    "folderName": "My_DTC_Sales",
    "folderId": "00l0o000002AC94AAG", 
    "label":"newDashboardCreated"
    }
}
```
**Sample response**

Given below is a sample response for the createDashboard operation.

```json
{
    "allowPreview": true,
    "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/dashboard?assetId=0FK0o000000LWtEGAW&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
    "createdBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "createdDate": "2019-01-30T05:49:14.000Z",
    "datasets": [],
    "files": [],
    "folder": {
        "id": "00l0o000002AC94AAG",
        "label": "new",
        "name": "test",
        "url": "/services/data/v36.0/wave/folders/00l0o000002AC94AAG"
    },
    "id": "0FK0o000000LWtEGAW",
    "label": "nini",
    "lastModifiedBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "lastModifiedDate": "2019-01-30T05:49:14.000Z",
    "name": "nini",
    "permissions": {
        "manage": true,
        "modify": true,
        "view": true
    },
    "state": {
        "gridLayouts": [
            {
                "name": "Default",
                "pages": [],
                "selectors": [],
                "version": 1
            }
        ],
        "layouts": [],
        "steps": {},
        "widgets": {}
    },
    "type": "dashboard",
    "url": "/services/data/v36.0/wave/dashboards/0FK0o000000LWtEGAW"
}
 
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_dashboards_id.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_dashboards_id.htm)

#### Returns the collection of the dashboard

To return the collection of the dashboard,use salesforcewaveanalytics.listDashboard .

**listDashboard**
```xml
<salesforcewaveanalytics.listDashboard>
     <folderId>{$ctx:folderId}</folderId>
     <mobileOnly>{$ctx:mobileOnly}</mobileOnly>
     <scope>{$ctx:scope}</scope>
     <page>{$ctx:page}</page>
     <pageSize>{$ctx:pageSize}</pageSize>
     <q>{$ctx:q}</q>
     <sort>{$ctx:sort}</sort>
</salesforcewaveanalytics.listDashboard>
```
**Properties**
* folderId: The specific folder ID to be filtered.
* mobileOnly: For mobile dashboards only.
* scope: Type of scope to be applied to a collection resource representation.
* page: A generated token that indicates the view of dashboard to be returned.
* pageSize: Number of items to be returned in a single page. Minimum is 1, maximum is 200, and default is 25.
* q: Search terms.
* sort: Property names that can be sorted.

**Sample request**

Following is a sample request that can be handled by the listDashboard operation.

```json
{
  "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
  "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPONn_0Uco32tTRr7Kxq9cZdHanLlFjymzY5Cktqe",
  "clientSecret": "5478649612867397870",
  "hostName": "https://login.salesforce.com",
  "apiVersion": "v37.0",
  "registryPath":"connectors/salesforcewaveanalytics",
  "accessToken":"00D0o0000016avV!AQYAQAgVHZ_g0N4jfdCeP7txvaXlrCZVJQQOaSnV1.LjvMiXZCdtRfO07lOCPXWuAG053kTC_VvvUud1ZqKeSghpKdgWceFr",
  "intervalTime" : "100000",
  "apiUrl":"https://ap8.salesforce.com",
  "folderId":"00l0o000002AC94AAG"
}
```
**Sample response**

Given below is a sample response for the tabs operation.

```json
{
    "dashboards": [
        {
            "allowPreview": true,
            "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/dashboard?assetId=0FK0o000000LTbUGAW&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
            "createdBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "createdDate": "2019-01-24T09:57:49.000Z",
            "datasets": [
                {
                    "id": "0Fb0o000000PEGCCA4",
                    "label": "DTC Opportunity",
                    "name": "DTC_Opportunity_SAMPLE",
                    "url": "/services/data/v36.0/wave/datasets/0Fb0o000000PEGCCA4"
                }
            ],
            "files": [
                {
                    "contentType": "image/png",
                    "fileLength": 13067,
                    "fileName": "assetPreviewThumb",
                    "id": "0FJ0o0000008QH9GAM",
                    "lastModifiedDate": "2019-01-24T09:57:49.000Z",
                    "url": "/services/data/v36.0/wave/lenses/0FK0o000000LTbUGAW/files/0FJ0o0000008QH9GAM"
                }
            ],
            "folder": {
                "id": "00l0o000002AC94AAG",
                "label": "My DTC Sales",
                "name": "My_DTC_Sales",
                "url": "/services/data/v36.0/wave/folders/00l0o000002AC94AAG"
            },
            "id": "0FK0o000000LTbUGAW",
            "label": "DTC Sales",
            "lastAccessedDate": "2019-01-29T05:17:29.000Z",
            "lastModifiedBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "lastModifiedDate": "2019-01-24T09:57:49.000Z",
            "name": "DTC_Sales_SAMPLE",
            "permissions": {
                "manage": true,
                "modify": true,
                "view": true
            },
            "refreshDate": "2019-01-24T09:57:49.000Z",
            "type": "dashboard",
            "url": "/services/data/v36.0/wave/dashboards/0FK0o000000LTbUGAW"
        }
    ]
}
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_dashboards.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_dashboards.htm)

#### Updates the dashboard

To update the dashboard, use salesforcewaveanalytics.UpdateDashboard.

**UpdateDashboard**
```xml
<salesforcewaveanalytics.updateDashboard>
                <dashboardId>{$ctx:dashboardId}</dashboardId>
                <state>{$ctx:state}</state>
                <folderId>{$ctx:folderId}</folderId>
                <folderName>{$ctx:folderName}</folderName>
                <description>{$ctx:description}</description>
                <label>{$ctx:label}</label>
                <name>{$ctx:name}</name>
</salesforcewaveanalytics.updateDashboard>
```
**Properties**
* dashboardId: The Id of the dashboard.
* state: The state of the dashboard.
* folderId: Folder in which this dashboard is stored.
* folderName: Folder in which this dashboard is stored.
* label: The label of the asset.
* description: Short description of the asset.
* name: The name of the asset.

**Sample request**

Following is a sample request that can be handled by the UpdateDashboard operation.

```json
{  
  "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
  "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPONDT1ndlu6XzBM.Ac3ydhWbauvwwKgJR5tvgrJw",
  "clientSecret": "5478649612867397870",
  "hostName": "https://login.salesforce.com",
  "apiVersion": "v39.0",
  "registryPath":"connectors/salesforcewaveanalytics",
  "accessToken":"00D0o0000016avV!AQYAQD1PH24nW1gYalUdkvIvzUeojX4g1XSZjYEpTDbN7CsH2ZJsWjEG_2yMEIbV4Ylpfa5dTyuO1_q8Qf2mVjlNujhecwA4",
  "intervalTime" : "100000",
  "apiUrl":"https://ap8.salesforce.com",
  "dashboardId":"0FK0o000000LTbVGAW",
  "label": "My DTC Sales",
  "name": "AAAAAAAA",
  "folderName": "My_DTC_Sales",
  "folderId": "00l0o000002AC91AAG"
} 
```
**Sample response**

Given below is a sample response for the UpdateDashboard operation.

```json
{
    "allowPreview": true,
    "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/dashboard?assetId=0FK0o000000LTbVGAW&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
    "createdBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "createdDate": "2019-01-24T09:57:49.000Z",
    "datasets": [],
    "description": "choc",
    "files": [
        {
            "contentType": "image/png",
            "fileLength": 20789,
            "fileName": "assetPreviewThumb",
            "id": "0FJ0o0000008QHBGA2",
            "lastModifiedDate": "2019-01-24T09:57:49.000Z",
            "url": "/services/data/v39.0/wave/lenses/0FK0o000000LTbVGAW/files/0FJ0o0000008QHBGA2"
        }
    ],
    "folder": {
        "id": "00l0o000002AC91AAG",
        "label": "iiiiiiii",
        "name": "iiiiiiii",
        "url": "/services/data/v39.0/wave/folders/00l0o000002AC91AAG"
    },
    "id": "0FK0o000000LTbVGAW",
    "label": "My DTC Sales",
    "lastAccessedDate": "2019-03-01T06:10:47.000Z",
    "lastModifiedBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "lastModifiedDate": "2019-03-01T06:10:47.000Z",
    "name": "AAAAAAAA",
    "permissions": {
        "manage": true,
        "modify": true,
        "view": true
    },
    "state": {
        "dataSourceLinks": [],
        "gridLayouts": [
            {
                "name": "youyoyou",
                "numColumns": 12,
                "pages": [],
                "rowHeight": "normal",
                "selectors": [],
                "version": 1
            }
        ],
        "layouts": [],
        "steps": {},
        "widgets": {}
    },
    "type": "dashboard",
    "url": "/services/data/v39.0/wave/dashboards/0FK0o000000LTbVGAW"
}
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_dashboards_id.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_dashboards_id.htm)

### Sample configuration

Following example illustrates how to connect to Salesforce Wave Analytics with the init operation and createDashboard operation.

1. Create a sample proxy as below :

    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="createDashboard"
           startOnLoad="true"
           statistics="disable"
           trace="disable"
           transports="http,https">
        <target>
            <inSequence>
                <property expression="json-eval($.accessToken)" name="accessToken"/>
                <property expression="json-eval($.apiVersion)" name="apiVersion"/>
                <property expression="json-eval($.hostName)" name="hostName"/>
                <property expression="json-eval($.refreshToken)" name="refreshToken"/>
                <property expression="json-eval($.clientSecret)" name="clientSecret"/>
                <property expression="json-eval($.clientId)" name="clientId"/>
                <property expression="json-eval($.apiUrl)" name="apiUrl"/>
                <property expression="json-eval($.registryPath)" name="registryPath"/>
                <property expression="json-eval($.intervalTime)" name="intervalTime"/>
                <property expression="json-eval($.state)" name="state"/>
                <property expression="json-eval($.folderId)" name="folderId"/>
                <property expression="json-eval($.folderName)" name="folderName"/>
                <property expression="json-eval($.description)" name="description"/>
                <property expression="json-eval($.label)" name="label"/>
                <property expression="json-eval($.name)" name="name"/>
                <salesforcewaveanalytics.init>
                    <accessToken>{$ctx:accessToken}</accessToken>
                    <apiUrl>{$ctx:apiUrl}</apiUrl>
                    <clientId>{$ctx:clientId}</clientId>
                    <clientSecret>{$ctx:clientSecret}</clientSecret>
                    <refreshToken>{$ctx:refreshToken}</refreshToken>
                    <hostName>{$ctx:hostName}</hostName>
                    <apiVersion>{$ctx:apiVersion}</apiVersion>
                    <registryPath>{$ctx:registryPath}</registryPath>
                    <intervalTime>{$ctx:intervalTime}</intervalTime>
                </salesforcewaveanalytics.init>
                <salesforcewaveanalytics.createDashboard>
                    <state>{$ctx:state}</state>
                    <folderId>{$ctx:folderId}</folderId>
                    <folderName>{$ctx:folderName}</folderName>
                    <description>{$ctx:description}</description>
                    <label>{$ctx:label}</label>
                    <name>{$ctx:name}</name>
                </salesforcewaveanalytics.createDashboard>
                <send/>
            </inSequence>
        </target>
        <description/>
    </proxy>
    ```

2. Create a json file named createDashboard.json and copy the configurations given below to it:

    ```json
    {
     "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
      "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPOO9pG5e8PvVODwZ4DSMgJJwfHSu_9TRyaIzt1r2",
      "clientSecret": "5478649612867397870",
      "hostName": "https://login.salesforce.com",
      "apiVersion": "v39.0",
      "registryPath":"connectors/salesforcewaveanalytics",
      "accessToken":"00D0o0000016avV!AQYAQHE9LTqCDUZIilIzLWtL4n7I1iJdMo7ci3Ra41QDVpJX86mV85QBCPl8LbqEFHjRmMEPS8BmYkRoKakL.i3KkQoeMHuL",
      "intervalTime" : "100000",
      "apiUrl":"https://ap8.salesforce.com",
       "state":{
            "gridLayouts": 
                 {
                   "name": "Default",
                    "version": 1
                 },
        "folderName": "My_DTC_Sales",
        "folderId": "00l0o000002AC94AAG", 
        "label":"newDashboardCreated"
        }
    }                     
    ```
3. Replace the values according to your setup.

4. Execute the following curl command:
      ```bash
      curl -X POST http://localhost:8280/services/createDashboard --header 'Content-Type: application/json' -d @createDashboard.json
      ```

5. Salesforce Wave Analytics returns a json response similar to the one shown below:
 
```json

{
    "allowPreview": true,
    "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/dashboard?assetId=0FK0o000000LWtEGAW&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
    "createdBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "createdDate": "2019-01-30T05:49:14.000Z",
    "datasets": [],
    "files": [],
    "folder": {
        "id": "00l0o000002AC94AAG",
        "label": "new",
        "name": "test",
        "url": "/services/data/v36.0/wave/folders/00l0o000002AC94AAG"
    },
    "id": "0FK0o000000LWtEGAW",
    "label": "nini",
    "lastModifiedBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "lastModifiedDate": "2019-01-30T05:49:14.000Z",
    "name": "nini",
    "permissions": {
        "manage": true,
        "modify": true,
        "view": true
    },
    "state": {
        "gridLayouts": [
            {
                "name": "Default",
                "pages": [],
                "selectors": [],
                "version": 1
            }
        ],
        "layouts": [],
        "steps": {},
        "widgets": {}
    },
    "type": "dashboard",
    "url": "/services/data/v36.0/wave/dashboards/0FK0o000000LWtEGAW"
}
 
```

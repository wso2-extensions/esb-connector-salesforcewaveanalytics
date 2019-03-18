# Working with Dataset

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview 

The following operations allow you to work with listDataset, updateDataset, for the current organization. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with updateDataset, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [listDataset](#returns-the-collection-of-the-dataset)    | Returns the collection of the dataset. |
| [updateDataset](#updates-the-dataset-for-a-specific-Id)      | Updates the dataset for a specific Id. |


### Operation details

This section provides more details on each of the operations.

#### Updates the dataset for a specific Id
To update the dataset for the specific dataset Id, use salesforcewaveanalytics.updateDataset and specify the following property.

**updateDataset**
```xml
 <salesforcewaveanalytics.updateDataset>
       <datasetId>{$ctx:datasetId}</datasetId>
       <currentVersionId>{$ctx:currentVersionId}</currentVersionId>
       <description>{$ctx:description}</description>
       <folderId>{$ctx:folderId}</folderId>
       <label>{$ctx:label}</label>
 </salesforcewaveanalytics.updateDataset>
```

**Properties**
* datasetId: The type of the menu, either AppSwitcher or Salesforce.
* currentVersionId: The current version Id of the dataset.
* description: The description of the dataset.
* folderId: The 18-character ID of the folder that contains the dataset.
* label: The label of the dataset.


**Sample request**

Following is a sample request that can be handled by the updateDataset operation.

```json
{ 
 "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
  "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPOOKxsV_3lDwKwTzBz2pGXcuHtmd.D7ZISnDg_AD",
  "clientSecret": "5478649612867397870",
  "hostName": "https://login.salesforce.com",
  "apiVersion": "v39.0",
  "registryPath":"connectors/salesforcewaveanalytics",
  "accessToken":"00D0o0000016avV!AQYAQMndEofSnH8XffbB_X7Eli8WF7_3cCa3WkP1tv8tp5iy2CFQIpgbK9FKdttS9._VbyZqM0p8vUNDf3.eu1yEanJd2j6o",
  "intervalTime" : "100000",
  "apiUrl":"https://ap8.salesforce.com",
  "datasetId":"0Fb0o000000PEGACA4",
  "currentVersionId": "0Fc0o000000RZh5CAG",
  "label": "newChange " 
}
 
```
**Sample response**

Given below is a sample response for the updateDashboard operation.

```json
{
    "clientShardsUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4/shards",
    "createdBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "createdDate": "2019-01-24T09:57:49.000Z",
    "currentVersionId": "0Fc0o000000RZh5CAG",
    "currentVersionUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4/versions/0Fc0o000000RZh5CAG",
    "folder": {
        "id": "00l0o000002AC91AAG",
        "label": "iiiiiiii",
        "name": "iiiiiiii",
        "url": "/services/data/v39.0/wave/folders/00l0o000002AC91AAG"
    },
    "id": "0Fb0o000000PEGACA4",
    "label": "newChange",
    "lastAccessedDate": "2019-03-05T05:35:49.000Z",
    "lastModifiedBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "lastModifiedDate": "2019-03-05T05:35:49.000Z",
    "lastQueriedDate": "2019-02-14T10:36:48.000Z",
    "name": "activity",
    "permissions": {
        "manage": true,
        "modify": true,
        "view": true
    },
    "type": "dataset",
    "url": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4",
    "versionsUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4/versions"
}
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_dataset_id.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_dataset_id.htm)

#### Returns the collection of the dataset
To return the collection of the dataset, use salesforcewaveanalytics.listDataset

**listDataset**
```xml
<salesforcewaveanalytics.listDataset>
     <folderId>{$ctx:folderId}</folderId>
     <hasCurrentOnly>{$ctx:hasCurrentOnly}</hasCurrentOnly>
     <order>{$ctx:order}</order>
     <page>{$ctx:page}</page>
     <pageSize>{$ctx:pageSize}</pageSize>
     <q>{$ctx:q}</q>
     <sort>{$ctx:sort}</sort>
</salesforcewaveanalytics.listDataset>
```

**Properties**
* folderId: The specific folder ID to be filtered.
* hasCurrentOnly: current version true or false .
* order: Order of the values (Ascending or descending).
* page: A generated token that indicates the view of dashboard to be returned.
* pageSize: Number of items to be returned in a single page. Minimum is 1, maximum is 200, and default is 25.
* q: Search terms.
* sort: Property names that can be sorted.

**Sample request**

Following is a sample request that can be handled by the listDataset operation.

```json
{
   "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
  "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPOOKxsV_3lDwKwTzBz2pGXcuHtmd.D7ZISnDg_AD",
  "clientSecret": "5478649612867397870",
  "hostName": "https://login.salesforce.com",
  "apiVersion": "v39.0",
  "registryPath":"connector/salesforcewaveanalytics",
  "accessToken":"00D0o0000016avV!AQYAQMndEofSnH8XffbB_X7Eli8WF7_3cCa3WkP1tv8tp5iy2CFQIpgbK9FKdttS9._VbyZqM0p8vUNDf3.eu1yEanJd2j6o",
  "intervalTime" : "100000",
  "apiUrl":"https://ap8.salesforce.com",
  "folderId":"00l0o000002AC91AAG"
}
```
**Sample response**

Given below is a sample response for the listDataset operation.

```json
{
    "datasets": [
        {
            "clientShardsUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4/shards",
            "createdBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "createdDate": "2019-01-24T09:57:49.000Z",
            "currentVersionId": "0Fc0o000000RZh5CAG",
            "currentVersionUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4/versions/0Fc0o000000RZh5CAG",
            "folder": {
                "id": "00l0o000002AC91AAG",
                "label": "iiiiiiii",
                "name": "iiiiiiii",
                "url": "/services/data/v39.0/wave/folders/00l0o000002AC91AAG"
            },
            "id": "0Fb0o000000PEGACA4",
            "label": "newChange",
            "lastAccessedDate": "2019-03-05T05:35:49.000Z",
            "lastModifiedBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "lastModifiedDate": "2019-03-05T05:35:49.000Z",
            "lastQueriedDate": "2019-02-14T10:36:48.000Z",
            "name": "activity",
            "permissions": {
                "manage": true,
                "modify": true,
                "view": true
            },
            "type": "dataset",
            "url": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4",
            "versionsUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4/versions"
        },
        {
            "clientShardsUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGBCA4/shards",
            "createdBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "createdDate": "2019-01-24T09:57:49.000Z",
            "currentVersionId": "0Fc0o000000RZh6CAG",
            "currentVersionUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGBCA4/versions/0Fc0o000000RZh6CAG",
            "folder": {
                "id": "00l0o000002AC91AAG",
                "label": "iiiiiiii",
                "name": "iiiiiiii",
                "url": "/services/data/v39.0/wave/folders/00l0o000002AC91AAG"
            },
            "id": "0Fb0o000000PEGBCA4",
            "label": "Users",
            "lastAccessedDate": "2019-01-29T05:16:34.000Z",
            "lastModifiedBy": {
                "id": "0050o00000VvA0wAAF",
                "name": "Security User",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "lastModifiedDate": "2018-06-27T17:32:14.000Z",
            "lastQueriedDate": "2018-11-27T20:13:01.000Z",
            "name": "user",
            "permissions": {
                "manage": true,
                "modify": true,
                "view": true
            },
            "type": "dataset",
            "url": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGBCA4",
            "versionsUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGBCA4/versions"
        }
    ],
    "nextPageUrl": null,
    "totalSize": 2,
    "url": "/services/data/v39.0/wave/datasets?folderId=00l0o000002AC91AAG"
}
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_datasets.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_datasets.htm)


### Sample configuration

Following example illustrates how to connect to Salesforce wave analytics with the init operation and updateDataset operation.

1. Create a sample proxy as below :

    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="updateDataset"
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
                <property expression="json-eval($.currentVersionId)" name="currentVersionId"/>
                <property expression="json-eval($.description)" name="description"/>
                <property expression="json-eval($.folderId)" name="folderId"/>
                <property expression="json-eval($.label)" name="label"/>
                <property expression="json-eval($.name)" name="name"/>
                <property expression="json-eval($.datasetId)" name="datasetId"/>
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
                <salesforcewaveanalytics.updateDataset>
                    <datasetId>{$ctx:datasetId}</datasetId>
                    <currentVersionId>{$ctx:currentVersionId}</currentVersionId>
                    <description>{$ctx:description}</description>
                    <folderId>{$ctx:folderId}</folderId>
                    <label>{$ctx:label}</label>
                    <name>{$ctx:name}</name>
                </salesforcewaveanalytics.updateDataset>
                <send/>
            </inSequence>
        </target>
        <description/>
    </proxy>
    ```

2. Create a json file named updateDatset.json and copy the configurations given below to it:

    ```json
    { 
     "clientId": "3MVG9pe2TCoA1Pf6K584VNDD80a6UqXVrD8cmFybYmBGw_0lzlTDE.O6.jp8U4Dnlw6WKH62Rwp7DAHjnd7sl",
      "refreshToken": "5Aep861ARUdJp8j3X36_jKdhoQp8ma26ieHKwW8JYjTK2BDPOOKxsV_3lDwKwTzBz2pGXcuHtmd.D7ZISnDg_AD",
      "clientSecret": "5478649612867397870",
      "hostName": "https://login.salesforce.com",
      "apiVersion": "v39.0",
      "registryPath":"connectors/salesforcewaveanalytics",
      "accessToken":"00D0o0000016avV!AQYAQMndEofSnH8XffbB_X7Eli8WF7_3cCa3WkP1tv8tp5iy2CFQIpgbK9FKdttS9._VbyZqM0p8vUNDf3.eu1yEanJd2j6o",
      "intervalTime" : "100000",
      "apiUrl":"https://ap8.salesforce.com",
      "datasetId":"0Fb0o000000PEGACA4",
      "currentVersionId": "0Fc0o000000RZh5CAG",
      "label": "newChange " 
    }
                       
    ```
3. Replace the values according to your setup.

4. Execute the following curl command:
    ```bash
      curl -X POST http://localhost:8280/services/updateDatset --header 'Content-Type: application/json' -d @updateDatset.json
    ```

5. Salesforce Wave Analytics returns a json response similar to the one shown below:
 
```json
{
    "clientShardsUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4/shards",
    "createdBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "createdDate": "2019-01-24T09:57:49.000Z",
    "currentVersionId": "0Fc0o000000RZh5CAG",
    "currentVersionUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4/versions/0Fc0o000000RZh5CAG",
    "folder": {
        "id": "00l0o000002AC91AAG",
        "label": "iiiiiiii",
        "name": "iiiiiiii",
        "url": "/services/data/v39.0/wave/folders/00l0o000002AC91AAG"
    },
    "id": "0Fb0o000000PEGACA4",
    "label": "newChange",
    "lastAccessedDate": "2019-03-05T05:35:49.000Z",
    "lastModifiedBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "lastModifiedDate": "2019-03-05T05:35:49.000Z",
    "lastQueriedDate": "2019-02-14T10:36:48.000Z",
    "name": "activity",
    "permissions": {
        "manage": true,
        "modify": true,
        "view": true
    },
    "type": "dataset",
    "url": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4",
    "versionsUrl": "/services/data/v39.0/wave/datasets/0Fb0o000000PEGACA4/versions"
}
```

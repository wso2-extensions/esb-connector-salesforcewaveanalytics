# Working with Folder

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview 

The following operations allow you to work with listFolder, listFolderById and replaceFolder, for the current organization. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with listFolderById, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [listFolder](#returns-the-collection-of-the-folder)    | Returns the collection of the folder. |
| [listFolderById](#lists-the-folder-by-specific-Id)      | Lists the folder by specific Id. |
| [replaceFolder](#replaces-the-folder)      | Replaces the folder.|

### Operation details

This section provides more details on each of the operations.

#### Lists the folder by specific Id
To list the folder by specific Id, use salesforcewaveanalytics.listFolderById and specify the following property.

**listFolderById**
```xml
<salesforcewaveanalytics.listFolderById>
      <folderId>{$ctx:folderId}</folderId>
      <mobileOnlyFeaturedAssets>{$ctx:mobileOnlyFeaturedAssets}</mobileOnlyFeaturedAssets>
</salesforcewaveanalytics.listFolderById>
```

**Properties**
* folderId: The type of the menu, either AppSwitcher or Salesforce.
* mobileOnlyFeaturedAssets: Set this parameter to true to show only dashboards that are enabled for the Einstein Analytics mobile app.

**Sample request**

Following is a sample request that can be handled by the listFolderById operation.

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
  "folderId":"00l0o000002AC91AAG"
}
```
**Sample response**

Given below is a sample response for the listFolderById operation.

```json
{
    "applicationStatus": "newstatus",
    "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/application?assetId=00l0o000002AC91AAG&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
    "attachedFiles": [],
    "canBeSharedExternally": false,
    "createdBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "createdDate": "2019-01-24T09:57:49.000Z",
    "featuredAssets": {},
    "icon": {
        "id": "00l0o000002AC91AAG",
        "name": "16.png",
        "url": "/analytics/wave/web/proto/images/app/icons/16.png"
    },
    "id": "00l0o000002AC91AAG",
    "isPinned": true,
    "label": "iiiiiiii",
    "lastModifiedBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "lastModifiedDate": "2019-02-26T06:46:27.000Z",
    "name": "iiiiiiii",
    "permissions": {
        "manage": true,
        "modify": true,
        "view": true
    },
    "shares": [],
    "templateOptions": {},
    "templateValues": {},
    "type": "folder",
    "url": "/services/data/v39.0/wave/folders/00l0o000002AC91AAG"
}
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_folders_id.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_folders_id.htm)

#### Returns the collection of the folder

To return the collection of the folder, use salesforcewaveanalytics.listFolder.

**listFolder**
```xml
<salesforcewaveanalytics.listFolder>
      <isPinned>{$ctx:isPinned}</isPinned>
      <scope>{$ctx:scope}</scope>
      <page>{$ctx:page}</page>
      <pageSize>{$ctx:pageSize}</pageSize>
      <q>{$ctx:q}</q>
      <sort>{$ctx:sort}</sort>
</salesforcewaveanalytics.listFolder>
```

**Properties**
* isPinned: Boolean value for pinned.
* scope: Type of scope to be applied to a collection resource representation.
* page: A generated token that indicates the view of dashboard to be returned.
* pageSize: Number of items to be returned in a single page. Minimum is 1, maximum is 200, and default is 25.
* q: Search terms.
* sort: Property names that can be sorted.

**Sample request**

Following is a sample request that can be handled by the listFolder operation.

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
  "folderId":"00l0o000002AC91AAG",
  "isPinned":"false",
  "scope":"CreatedByMe"
}
```
**Sample response**

Given below is a sample response for the listFolder operation.

```json
{
    "folders": [
        {
            "applicationStatus": "newstatus",
            "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/application?assetId=00l0o000002AC91AAG&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
            "attachedFiles": [],
            "canBeSharedExternally": false,
            "createdBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "createdDate": "2019-01-24T09:57:49.000Z",
            "featuredAssets": {},
            "icon": {
                "id": "00l0o000002AC91AAG",
                "name": "16.png",
                "url": "/analytics/wave/web/proto/images/app/icons/16.png"
            },
            "id": "00l0o000002AC91AAG",
            "isPinned": true,
            "label": "iiiiiiii",
            "lastAccessedDate": "2019-03-05T06:05:48.000Z",
            "lastModifiedBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "lastModifiedDate": "2019-02-26T06:46:27.000Z",
            "name": "iiiiiiii",
            "permissions": {
                "manage": true,
                "modify": true,
                "view": true
            },
            "shares": [],
            "templateOptions": {},
            "templateValues": {},
            "type": "folder",
            "url": "/services/data/v39.0/wave/folders/00l0o000002AC91AAG"
        },
        {
            "applicationStatus": "newstatus",
            "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/application?assetId=00l0o000002AC94AAG&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
            "attachedFiles": [],
            "canBeSharedExternally": false,
            "createdBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "createdDate": "2019-01-24T09:57:49.000Z",
            "defaultAsset": {
                "id": "0FK0o000000LTbUGAW",
                "name": "DTC_Sales_SAMPLE",
                "url": "/services/data/v39.0/wave/dashboards/0FK0o000000LTbUGAW"
            },
            "featuredAssets": {},
            "icon": {
                "id": "00l0o000002AC94AAG",
                "name": "16.png",
                "url": "/analytics/wave/web/proto/images/app/icons/16.png"
            },
            "id": "00l0o000002AC94AAG",
            "isPinned": true,
            "label": "new",
            "lastAccessedDate": "2019-03-05T05:14:00.000Z",
            "lastModifiedBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "lastModifiedDate": "2019-03-05T05:12:14.000Z",
            "name": "test",
            "permissions": {
                "manage": true,
                "modify": true,
                "view": true
            },
            "shares": [],
            "templateOptions": {},
            "templateValues": {},
            "type": "folder",
            "url": "/services/data/v39.0/wave/folders/00l0o000002AC94AAG"
        },
        {
            "applicationStatus": "newstatus",
            "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/application?assetId=00l0o000002AC90AAG&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
            "attachedFiles": [],
            "canBeSharedExternally": false,
            "createdBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "createdDate": "2019-01-24T09:57:49.000Z",
            "featuredAssets": {},
            "icon": {
                "id": "00l0o000002AC90AAG",
                "name": "16.png",
                "url": "/analytics/wave/web/proto/images/app/icons/16.png"
            },
            "id": "00l0o000002AC90AAG",
            "isPinned": true,
            "label": "ABC Seed",
            "lastAccessedDate": "2019-01-28T05:11:21.000Z",
            "lastModifiedBy": {
                "id": "0050o00000VHH1RAAX",
                "name": "Ravikumar Nirubikaa",
                "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
            },
            "lastModifiedDate": "2019-01-24T09:57:49.000Z",
            "name": "ABC_Seed",
            "permissions": {
                "manage": true,
                "modify": true,
                "view": true
            },
            "shares": [],
            "templateOptions": {},
            "templateValues": {},
            "type": "folder",
            "url": "/services/data/v39.0/wave/folders/00l0o000002AC90AAG"
        }
    ],
    "totalSize": 3,
    "url": "/services/data/v39.0/wave/folders?scope=CreatedByMe"
}
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_folders.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_folders.htm)

#### Replaces the folder

To replace the folder, use salesforcewaveanalytics.replaceFolder.

**replaceFolder**
```xml
<salesforcewaveanalytics.replaceFolder>
                <label>{$ctx:label}</label>
                <applicationStatus>{$ctx:applicationStatus}</applicationStatus>
                <description>{$ctx:description}</description>
                <defaultAssetId>{$ctx:defaultAssetId}</defaultAssetId>
                <attachedFilesName>{$ctx:attachedFilesName}</attachedFilesName>
                <canBeSharedExternally>{$ctx:canBeSharedExternally}</canBeSharedExternally>
                <defaultAssetName>{$ctx:defaultAssetName}</defaultAssetName>
                <isPinned>{$ctx:isPinned}</isPinned>
                <assetIcon>{$ctx:assetIcon}</assetIcon>
                <folderId>{$ctx:folderId}</folderId>
                <attachedFilesId>{$ctx:attachedFilesId}</attachedFilesId>
                <name>{$ctx:name}</name>
</salesforcewaveanalytics.replaceFolder>
```

**Properties**
* label: The user-facing name of the new folder or application.
* applicationStatus: The creation status of application .
* description: The description of the new folder or application.
* defaultAssetId: ID of the default Asset.
* defaultAssetName: Name of the default asset.
* attachedFilesName: Property names that can be sorted.
* attachedFilesId: The attached files name.
* canBeSharedExternally: Whether the application is shared in Communities.
* assetIcon: The icon enumeration that best represents the new folder or application. Valid values are 1.png through 20.png.
* folderId: The Id of the folder.
* name: The internal API name of the new folder or application.


**Sample request**

Following is a sample request that can be handled by the replaceFolder operation.

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
  "folderId":"00l0o000002AC94AAG",
  "applicationStatus":"CancelledStatus",
  "assetIcon":"16.png",
  "label":"new",
  "name":"test",
  "defaultAssetId":"0FK0o000000LTbUGAW",
  "attachedFilesId":"0690o000005u2XGAAY",
  "attachedFilesName":"attachedNewFile"
} 
```
**Sample response**

Given below is a sample response for the replaceFolder operation.

```json
{
    "applicationStatus": "newstatus",
    "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/application?assetId=00l0o000002AC94AAG&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
    "attachedFiles": [
        {
            "id": "0690o000005u2XGAAY"
        },
        {
            "id": "0690o000005u2XFAAY"
        }
    ],
    "canBeSharedExternally": false,
    "createdBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "createdDate": "2019-01-24T09:57:49.000Z",
    "defaultAsset": {
        "id": "0FK0o000000LTbUGAW",
        "name": "DTC_Sales_SAMPLE",
        "url": "/services/data/v39.0/wave/dashboards/0FK0o000000LTbUGAW"
    },
    "featuredAssets": {},
    "icon": {
        "id": "00l0o000002AC94AAG",
        "name": "16.png",
        "url": "/analytics/wave/web/proto/images/app/icons/16.png"
    },
    "id": "00l0o000002AC94AAG",
    "isPinned": true,
    "label": "new",
    "lastModifiedBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "lastModifiedDate": "2019-03-05T09:47:28.000Z",
    "name": "test",
    "permissions": {
        "manage": true,
        "modify": true,
        "view": true
    },
    "shares": [],
    "templateOptions": {},
    "templateValues": {},
    "type": "folder",
    "url": "/services/data/v39.0/wave/folders/00l0o000002AC94AAG"
}
```

**Related Salesforce documentation**

[https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_folders_id.htm](https://developer.salesforce.com/docs/atlas.en-us.bi_dev_guide_rest.meta/bi_dev_guide_rest/bi_resources_folders_id.htm)

### Sample configuration

Following example illustrates how to connect to Salesforce with the init operation and listFolderById operation.

1. Create a sample proxy as below :

    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="listFolderById"
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
                <property expression="json-eval($.folderId)" name="folderId"/>
                <property expression="json-eval($.mobileOnlyFeaturedAssets)"
                          name="mobileOnlyFeaturedAssets"/>
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
                <salesforcewaveanalytics.listFolderById>
                    <folderId>{$ctx:folderId}</folderId>
                    <mobileOnlyFeaturedAssets>{$ctx:mobileOnlyFeaturedAssets}</mobileOnlyFeaturedAssets>
                </salesforcewaveanalytics.listFolderById>
                <send/>
            </inSequence>
        </target>
        <description/>
    </proxy>

    ```

2. Create a json file named listFolderById.json and copy the configurations given below to it:

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
      "folderId":"00l0o000002AC91AAG"
    }                       
    ```
3. Replace the values according to your setup.

4. Execute the following curl command:
    ```bash
      curl -X POST http://localhost:8280/services/listFolderById --header 'Content-Type: application/json' -d @listFolderById.json
    ```

5. Salesforce wave analytics returns a json response similar to the one shown below:
 
```json
{
    "applicationStatus": "newstatus",
    "assetSharingUrl": "https://ap8.salesforce.com/analytics/wave/application?assetId=00l0o000002AC91AAG&orgId=00D0o0000016avV&loginHost=ap8.salesforce.com&urlType=sharing",
    "attachedFiles": [],
    "canBeSharedExternally": false,
    "createdBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "createdDate": "2019-01-24T09:57:49.000Z",
    "featuredAssets": {},
    "icon": {
        "id": "00l0o000002AC91AAG",
        "name": "16.png",
        "url": "/analytics/wave/web/proto/images/app/icons/16.png"
    },
    "id": "00l0o000002AC91AAG",
    "isPinned": true,
    "label": "iiiiiiii",
    "lastModifiedBy": {
        "id": "0050o00000VHH1RAAX",
        "name": "Ravikumar Nirubikaa",
        "profilePhotoUrl": "https://c.ap8.content.force.com/profilephoto/005/T"
    },
    "lastModifiedDate": "2019-02-26T06:46:27.000Z",
    "name": "iiiiiiii",
    "permissions": {
        "manage": true,
        "modify": true,
        "view": true
    },
    "shares": [],
    "templateOptions": {},
    "templateValues": {},
    "type": "folder",
    "url": "/services/data/v39.0/wave/folders/00l0o000002AC91AAG"
}
```

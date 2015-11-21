package com.smalljellybean.listingworks.activity.service;


import java.util.List;

public class ListItemResponse {

//    {
//        "results": [
//        {
//            "createdAt": "2015-11-07T08:27:20.450Z",
//                "description": "desc for item 1",
//                "name": "item1",
//                "objectId": "PcPIpiX9QH",
//                "updatedAt": "2015-11-07T08:27:30.785Z"
//        }
//        ]
//    }

    public List<ListItem> results;

    public List<ListItem> getResults() {
        return results;
    }
}

package com.jiankunking.logsearch.util;


import com.jiankunking.logsearch.client.ESClients;
import com.jiankunking.logsearch.config.GlobalConfig;
import com.jiankunking.logsearch.exception.ESClientNotFoundException;
import com.jiankunking.logsearch.exception.ESClusterNotFoundException;
import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author jiankunking.
 * @date：2018/8/17 10:05
 * @description:
 */
public class ESQueryUtils {

    public static String performRequest(String cluster, String project, String method, String endpoint, String queryJson) throws IOException, ESClusterNotFoundException, ESClientNotFoundException {
        StringEntity queryBody = new StringEntity(queryJson, GlobalConfig.CHARSET);
        Header header = new BasicHeader("content-type", "application/json");
        Response esResponse = ESClients.getInstance(project, cluster).performRequest(method, endpoint, new HashMap(0), queryBody, header);
        return EntityUtils.toString(esResponse.getEntity());
    }

    public static String getEndpoint(String indexName) {
        return String.format("/%s/_search", indexName);
    }
}

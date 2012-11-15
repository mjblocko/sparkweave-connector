/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.SparkWeave;

import org.junit.Before;
import org.junit.Test;
import org.mule.sparkweave.SparkWeaveConnector;

import java.util.Arrays;
import java.util.List;

public class SparkWeaveConnectorDriver
{
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }

    @Test
    public void shouldObtainListOfRootDirectory() throws Exception
    {
      String server = "secure.sparkweave.com";
      String userEmail = "connector@mulesoft.org";
      String password = "Donkey1";

        SparkWeaveConnector connector = new SparkWeaveConnector();
        connector.setUseHttps(true);
        connector.connect(server, userEmail, password);

        List<String> list = connector.list("/");
        System.out.println(Arrays.toString(list.toArray()));
    }
}

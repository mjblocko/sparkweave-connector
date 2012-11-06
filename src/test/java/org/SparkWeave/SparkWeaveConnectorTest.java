/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.SparkWeave;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.construct.Flow;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.mule.tck.junit4.FunctionalTestCase;

public class SparkWeaveConnectorTest extends FunctionalTestCase
{

  @Override
  protected String getConfigResources()
  {
    return "mule-config.xml";
  }
  
  @Test
  @Ignore
  public void testGetListApplications() throws Exception
  {
      MuleEvent event = runFlow("listApplications");
      
      Object payload = event.getMessage().getPayload();
      assertTrue(payload instanceof List);
  }
  
  /**
   * Run the flow specified by name and assert equality on the expected output
   *
   * @param flowName The name of the flow to run
   * @param expect The expected output
   */
   protected <T> void runFlowAndExpect(String flowName, T expect) throws Exception
   {
       MuleEvent responseEvent = runFlow(flowName);

       assertEquals(expect, responseEvent.getMessage().getPayload());
       @SuppressWarnings("unchecked")
      List<String> list = (List<String>) responseEvent.getMessage().getPayload();
       System.out.println(Arrays.toString(list.toArray()));
   }

   private MuleEvent runFlow(String flowName) throws Exception, MuleException {
       Flow flow = lookupFlowConstruct(flowName);
       MuleEvent event = AbstractMuleContextTestCase.getTestEvent(null);
       MuleEvent responseEvent = flow.process(event);
       return responseEvent;
   }
   
   /**
    * Retrieve a flow by name from the registry
    *
    * @param name Name of the flow to retrieve
    */
   protected Flow lookupFlowConstruct(String name)
   {
       return (Flow) muleContext.getRegistry().lookupFlowConstruct(name);
   }
}

/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for DCNode related events. .
 *
 * @author your_name_here
 */
@Component("dCNode-subscriber")
public class DCNodeSubscriber extends BaseSubscriber {

  public DCNodeSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCNode>, DCNode> dCNodeSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCNodeQuery(),
        ResponseTypes.multipleInstancesOf(DCNode.class),
        ResponseTypes.instanceOf(DCNode.class));
  }

  public SubscriptionQueryResult<DCNode, DCNode> dCNodeSubscribe(
      @DestinationVariable UUID dCNodeId) {
    return queryGateway.subscriptionQuery(
        new FindDCNodeQuery(new LoadDCNodeFilter(dCNodeId)),
        ResponseTypes.instanceOf(DCNode.class),
        ResponseTypes.instanceOf(DCNode.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

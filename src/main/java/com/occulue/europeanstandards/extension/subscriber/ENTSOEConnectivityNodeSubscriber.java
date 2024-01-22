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
package com.occulue.europeanstandards.extension.subscriber;

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
 * Subscriber for ENTSOEConnectivityNode related events. .
 *
 * @author your_name_here
 */
@Component("eNTSOEConnectivityNode-subscriber")
public class ENTSOEConnectivityNodeSubscriber extends BaseSubscriber {

  public ENTSOEConnectivityNodeSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ENTSOEConnectivityNode>, ENTSOEConnectivityNode>
      eNTSOEConnectivityNodeSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllENTSOEConnectivityNodeQuery(),
        ResponseTypes.multipleInstancesOf(ENTSOEConnectivityNode.class),
        ResponseTypes.instanceOf(ENTSOEConnectivityNode.class));
  }

  public SubscriptionQueryResult<ENTSOEConnectivityNode, ENTSOEConnectivityNode>
      eNTSOEConnectivityNodeSubscribe(@DestinationVariable UUID eNTSOEConnectivityNodeId) {
    return queryGateway.subscriptionQuery(
        new FindENTSOEConnectivityNodeQuery(
            new LoadENTSOEConnectivityNodeFilter(eNTSOEConnectivityNodeId)),
        ResponseTypes.instanceOf(ENTSOEConnectivityNode.class),
        ResponseTypes.instanceOf(ENTSOEConnectivityNode.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

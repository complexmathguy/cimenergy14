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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.subscriber;

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
 * Subscriber for TopologyBoundaryVersion related events. .
 *
 * @author your_name_here
 */
@Component("topologyBoundaryVersion-subscriber")
public class TopologyBoundaryVersionSubscriber extends BaseSubscriber {

  public TopologyBoundaryVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TopologyBoundaryVersion>, TopologyBoundaryVersion>
      topologyBoundaryVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTopologyBoundaryVersionQuery(),
        ResponseTypes.multipleInstancesOf(TopologyBoundaryVersion.class),
        ResponseTypes.instanceOf(TopologyBoundaryVersion.class));
  }

  public SubscriptionQueryResult<TopologyBoundaryVersion, TopologyBoundaryVersion>
      topologyBoundaryVersionSubscribe(@DestinationVariable UUID topologyBoundaryVersionId) {
    return queryGateway.subscriptionQuery(
        new FindTopologyBoundaryVersionQuery(
            new LoadTopologyBoundaryVersionFilter(topologyBoundaryVersionId)),
        ResponseTypes.instanceOf(TopologyBoundaryVersion.class),
        ResponseTypes.instanceOf(TopologyBoundaryVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

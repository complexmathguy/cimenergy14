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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.subscriber;

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
 * Subscriber for TopologyVersion related events. .
 *
 * @author your_name_here
 */
@Component("topologyVersion-subscriber")
public class TopologyVersionSubscriber extends BaseSubscriber {

  public TopologyVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TopologyVersion>, TopologyVersion>
      topologyVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTopologyVersionQuery(),
        ResponseTypes.multipleInstancesOf(TopologyVersion.class),
        ResponseTypes.instanceOf(TopologyVersion.class));
  }

  public SubscriptionQueryResult<TopologyVersion, TopologyVersion> topologyVersionSubscribe(
      @DestinationVariable UUID topologyVersionId) {
    return queryGateway.subscriptionQuery(
        new FindTopologyVersionQuery(new LoadTopologyVersionFilter(topologyVersionId)),
        ResponseTypes.instanceOf(TopologyVersion.class),
        ResponseTypes.instanceOf(TopologyVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

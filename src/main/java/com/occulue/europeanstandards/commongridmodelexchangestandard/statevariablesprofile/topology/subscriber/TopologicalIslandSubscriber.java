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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology.subscriber;

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
 * Subscriber for TopologicalIsland related events. .
 *
 * @author your_name_here
 */
@Component("topologicalIsland-subscriber")
public class TopologicalIslandSubscriber extends BaseSubscriber {

  public TopologicalIslandSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TopologicalIsland>, TopologicalIsland>
      topologicalIslandSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTopologicalIslandQuery(),
        ResponseTypes.multipleInstancesOf(TopologicalIsland.class),
        ResponseTypes.instanceOf(TopologicalIsland.class));
  }

  public SubscriptionQueryResult<TopologicalIsland, TopologicalIsland> topologicalIslandSubscribe(
      @DestinationVariable UUID topologicalIslandId) {
    return queryGateway.subscriptionQuery(
        new FindTopologicalIslandQuery(new LoadTopologicalIslandFilter(topologicalIslandId)),
        ResponseTypes.instanceOf(TopologicalIsland.class),
        ResponseTypes.instanceOf(TopologicalIsland.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

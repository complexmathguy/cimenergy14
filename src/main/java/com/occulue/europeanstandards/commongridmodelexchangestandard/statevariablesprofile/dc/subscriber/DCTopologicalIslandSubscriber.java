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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.dc.subscriber;

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
 * Subscriber for DCTopologicalIsland related events. .
 *
 * @author your_name_here
 */
@Component("dCTopologicalIsland-subscriber")
public class DCTopologicalIslandSubscriber extends BaseSubscriber {

  public DCTopologicalIslandSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCTopologicalIsland>, DCTopologicalIsland>
      dCTopologicalIslandSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCTopologicalIslandQuery(),
        ResponseTypes.multipleInstancesOf(DCTopologicalIsland.class),
        ResponseTypes.instanceOf(DCTopologicalIsland.class));
  }

  public SubscriptionQueryResult<DCTopologicalIsland, DCTopologicalIsland>
      dCTopologicalIslandSubscribe(@DestinationVariable UUID dCTopologicalIslandId) {
    return queryGateway.subscriptionQuery(
        new FindDCTopologicalIslandQuery(new LoadDCTopologicalIslandFilter(dCTopologicalIslandId)),
        ResponseTypes.instanceOf(DCTopologicalIsland.class),
        ResponseTypes.instanceOf(DCTopologicalIsland.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

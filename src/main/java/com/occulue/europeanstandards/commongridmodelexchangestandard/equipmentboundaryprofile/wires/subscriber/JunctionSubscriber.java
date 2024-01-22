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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.subscriber;

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
 * Subscriber for Junction related events. .
 *
 * @author your_name_here
 */
@Component("junction-subscriber")
public class JunctionSubscriber extends BaseSubscriber {

  public JunctionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Junction>, Junction> junctionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllJunctionQuery(),
        ResponseTypes.multipleInstancesOf(Junction.class),
        ResponseTypes.instanceOf(Junction.class));
  }

  public SubscriptionQueryResult<Junction, Junction> junctionSubscribe(
      @DestinationVariable UUID junctionId) {
    return queryGateway.subscriptionQuery(
        new FindJunctionQuery(new LoadJunctionFilter(junctionId)),
        ResponseTypes.instanceOf(Junction.class),
        ResponseTypes.instanceOf(Junction.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

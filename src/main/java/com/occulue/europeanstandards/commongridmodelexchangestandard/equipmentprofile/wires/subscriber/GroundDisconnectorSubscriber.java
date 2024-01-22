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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for GroundDisconnector related events. .
 *
 * @author your_name_here
 */
@Component("groundDisconnector-subscriber")
public class GroundDisconnectorSubscriber extends BaseSubscriber {

  public GroundDisconnectorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GroundDisconnector>, GroundDisconnector>
      groundDisconnectorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGroundDisconnectorQuery(),
        ResponseTypes.multipleInstancesOf(GroundDisconnector.class),
        ResponseTypes.instanceOf(GroundDisconnector.class));
  }

  public SubscriptionQueryResult<GroundDisconnector, GroundDisconnector>
      groundDisconnectorSubscribe(@DestinationVariable UUID groundDisconnectorId) {
    return queryGateway.subscriptionQuery(
        new FindGroundDisconnectorQuery(new LoadGroundDisconnectorFilter(groundDisconnectorId)),
        ResponseTypes.instanceOf(GroundDisconnector.class),
        ResponseTypes.instanceOf(GroundDisconnector.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

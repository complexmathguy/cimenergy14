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
 * Subscriber for Conductor related events. .
 *
 * @author your_name_here
 */
@Component("conductor-subscriber")
public class ConductorSubscriber extends BaseSubscriber {

  public ConductorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Conductor>, Conductor> conductorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllConductorQuery(),
        ResponseTypes.multipleInstancesOf(Conductor.class),
        ResponseTypes.instanceOf(Conductor.class));
  }

  public SubscriptionQueryResult<Conductor, Conductor> conductorSubscribe(
      @DestinationVariable UUID conductorId) {
    return queryGateway.subscriptionQuery(
        new FindConductorQuery(new LoadConductorFilter(conductorId)),
        ResponseTypes.instanceOf(Conductor.class),
        ResponseTypes.instanceOf(Conductor.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

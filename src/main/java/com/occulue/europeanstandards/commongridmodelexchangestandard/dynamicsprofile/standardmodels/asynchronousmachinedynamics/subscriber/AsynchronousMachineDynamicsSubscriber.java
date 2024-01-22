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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.subscriber;

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
 * Subscriber for AsynchronousMachineDynamics related events. .
 *
 * @author your_name_here
 */
@Component("asynchronousMachineDynamics-subscriber")
public class AsynchronousMachineDynamicsSubscriber extends BaseSubscriber {

  public AsynchronousMachineDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<AsynchronousMachineDynamics>, AsynchronousMachineDynamics>
      asynchronousMachineDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAsynchronousMachineDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(AsynchronousMachineDynamics.class),
        ResponseTypes.instanceOf(AsynchronousMachineDynamics.class));
  }

  public SubscriptionQueryResult<AsynchronousMachineDynamics, AsynchronousMachineDynamics>
      asynchronousMachineDynamicsSubscribe(
          @DestinationVariable UUID asynchronousMachineDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindAsynchronousMachineDynamicsQuery(
            new LoadAsynchronousMachineDynamicsFilter(asynchronousMachineDynamicsId)),
        ResponseTypes.instanceOf(AsynchronousMachineDynamics.class),
        ResponseTypes.instanceOf(AsynchronousMachineDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

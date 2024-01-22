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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.subscriber;

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
 * Subscriber for SynchronousMachineDynamics related events. .
 *
 * @author your_name_here
 */
@Component("synchronousMachineDynamics-subscriber")
public class SynchronousMachineDynamicsSubscriber extends BaseSubscriber {

  public SynchronousMachineDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SynchronousMachineDynamics>, SynchronousMachineDynamics>
      synchronousMachineDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSynchronousMachineDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(SynchronousMachineDynamics.class),
        ResponseTypes.instanceOf(SynchronousMachineDynamics.class));
  }

  public SubscriptionQueryResult<SynchronousMachineDynamics, SynchronousMachineDynamics>
      synchronousMachineDynamicsSubscribe(@DestinationVariable UUID synchronousMachineDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindSynchronousMachineDynamicsQuery(
            new LoadSynchronousMachineDynamicsFilter(synchronousMachineDynamicsId)),
        ResponseTypes.instanceOf(SynchronousMachineDynamics.class),
        ResponseTypes.instanceOf(SynchronousMachineDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

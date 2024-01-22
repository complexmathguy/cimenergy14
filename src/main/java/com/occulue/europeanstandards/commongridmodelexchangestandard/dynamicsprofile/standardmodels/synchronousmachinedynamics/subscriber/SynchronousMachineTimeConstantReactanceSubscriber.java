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
 * Subscriber for SynchronousMachineTimeConstantReactance related events. .
 *
 * @author your_name_here
 */
@Component("synchronousMachineTimeConstantReactance-subscriber")
public class SynchronousMachineTimeConstantReactanceSubscriber extends BaseSubscriber {

  public SynchronousMachineTimeConstantReactanceSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<SynchronousMachineTimeConstantReactance>, SynchronousMachineTimeConstantReactance>
      synchronousMachineTimeConstantReactanceSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSynchronousMachineTimeConstantReactanceQuery(),
        ResponseTypes.multipleInstancesOf(SynchronousMachineTimeConstantReactance.class),
        ResponseTypes.instanceOf(SynchronousMachineTimeConstantReactance.class));
  }

  public SubscriptionQueryResult<
          SynchronousMachineTimeConstantReactance, SynchronousMachineTimeConstantReactance>
      synchronousMachineTimeConstantReactanceSubscribe(
          @DestinationVariable UUID synchronousMachineTimeConstantReactanceId) {
    return queryGateway.subscriptionQuery(
        new FindSynchronousMachineTimeConstantReactanceQuery(
            new LoadSynchronousMachineTimeConstantReactanceFilter(
                synchronousMachineTimeConstantReactanceId)),
        ResponseTypes.instanceOf(SynchronousMachineTimeConstantReactance.class),
        ResponseTypes.instanceOf(SynchronousMachineTimeConstantReactance.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

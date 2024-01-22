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
 * Subscriber for SynchronousMachineEquivalentCircuit related events. .
 *
 * @author your_name_here
 */
@Component("synchronousMachineEquivalentCircuit-subscriber")
public class SynchronousMachineEquivalentCircuitSubscriber extends BaseSubscriber {

  public SynchronousMachineEquivalentCircuitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<SynchronousMachineEquivalentCircuit>, SynchronousMachineEquivalentCircuit>
      synchronousMachineEquivalentCircuitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSynchronousMachineEquivalentCircuitQuery(),
        ResponseTypes.multipleInstancesOf(SynchronousMachineEquivalentCircuit.class),
        ResponseTypes.instanceOf(SynchronousMachineEquivalentCircuit.class));
  }

  public SubscriptionQueryResult<
          SynchronousMachineEquivalentCircuit, SynchronousMachineEquivalentCircuit>
      synchronousMachineEquivalentCircuitSubscribe(
          @DestinationVariable UUID synchronousMachineEquivalentCircuitId) {
    return queryGateway.subscriptionQuery(
        new FindSynchronousMachineEquivalentCircuitQuery(
            new LoadSynchronousMachineEquivalentCircuitFilter(
                synchronousMachineEquivalentCircuitId)),
        ResponseTypes.instanceOf(SynchronousMachineEquivalentCircuit.class),
        ResponseTypes.instanceOf(SynchronousMachineEquivalentCircuit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

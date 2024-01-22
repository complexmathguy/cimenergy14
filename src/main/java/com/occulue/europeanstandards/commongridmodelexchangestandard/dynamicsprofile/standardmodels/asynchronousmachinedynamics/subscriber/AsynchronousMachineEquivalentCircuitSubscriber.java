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
 * Subscriber for AsynchronousMachineEquivalentCircuit related events. .
 *
 * @author your_name_here
 */
@Component("asynchronousMachineEquivalentCircuit-subscriber")
public class AsynchronousMachineEquivalentCircuitSubscriber extends BaseSubscriber {

  public AsynchronousMachineEquivalentCircuitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<AsynchronousMachineEquivalentCircuit>, AsynchronousMachineEquivalentCircuit>
      asynchronousMachineEquivalentCircuitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAsynchronousMachineEquivalentCircuitQuery(),
        ResponseTypes.multipleInstancesOf(AsynchronousMachineEquivalentCircuit.class),
        ResponseTypes.instanceOf(AsynchronousMachineEquivalentCircuit.class));
  }

  public SubscriptionQueryResult<
          AsynchronousMachineEquivalentCircuit, AsynchronousMachineEquivalentCircuit>
      asynchronousMachineEquivalentCircuitSubscribe(
          @DestinationVariable UUID asynchronousMachineEquivalentCircuitId) {
    return queryGateway.subscriptionQuery(
        new FindAsynchronousMachineEquivalentCircuitQuery(
            new LoadAsynchronousMachineEquivalentCircuitFilter(
                asynchronousMachineEquivalentCircuitId)),
        ResponseTypes.instanceOf(AsynchronousMachineEquivalentCircuit.class),
        ResponseTypes.instanceOf(AsynchronousMachineEquivalentCircuit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

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
 * Subscriber for AsynchronousMachine related events. .
 *
 * @author your_name_here
 */
@Component("asynchronousMachine-subscriber")
public class AsynchronousMachineSubscriber extends BaseSubscriber {

  public AsynchronousMachineSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<AsynchronousMachine>, AsynchronousMachine>
      asynchronousMachineSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAsynchronousMachineQuery(),
        ResponseTypes.multipleInstancesOf(AsynchronousMachine.class),
        ResponseTypes.instanceOf(AsynchronousMachine.class));
  }

  public SubscriptionQueryResult<AsynchronousMachine, AsynchronousMachine>
      asynchronousMachineSubscribe(@DestinationVariable UUID asynchronousMachineId) {
    return queryGateway.subscriptionQuery(
        new FindAsynchronousMachineQuery(new LoadAsynchronousMachineFilter(asynchronousMachineId)),
        ResponseTypes.instanceOf(AsynchronousMachine.class),
        ResponseTypes.instanceOf(AsynchronousMachine.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

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
 * Subscriber for RotatingMachine related events. .
 *
 * @author your_name_here
 */
@Component("rotatingMachine-subscriber")
public class RotatingMachineSubscriber extends BaseSubscriber {

  public RotatingMachineSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RotatingMachine>, RotatingMachine>
      rotatingMachineSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRotatingMachineQuery(),
        ResponseTypes.multipleInstancesOf(RotatingMachine.class),
        ResponseTypes.instanceOf(RotatingMachine.class));
  }

  public SubscriptionQueryResult<RotatingMachine, RotatingMachine> rotatingMachineSubscribe(
      @DestinationVariable UUID rotatingMachineId) {
    return queryGateway.subscriptionQuery(
        new FindRotatingMachineQuery(new LoadRotatingMachineFilter(rotatingMachineId)),
        ResponseTypes.instanceOf(RotatingMachine.class),
        ResponseTypes.instanceOf(RotatingMachine.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

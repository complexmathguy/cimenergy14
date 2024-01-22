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
 * Subscriber for SynchronousMachine related events. .
 *
 * @author your_name_here
 */
@Component("synchronousMachine-subscriber")
public class SynchronousMachineSubscriber extends BaseSubscriber {

  public SynchronousMachineSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SynchronousMachine>, SynchronousMachine>
      synchronousMachineSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSynchronousMachineQuery(),
        ResponseTypes.multipleInstancesOf(SynchronousMachine.class),
        ResponseTypes.instanceOf(SynchronousMachine.class));
  }

  public SubscriptionQueryResult<SynchronousMachine, SynchronousMachine>
      synchronousMachineSubscribe(@DestinationVariable UUID synchronousMachineId) {
    return queryGateway.subscriptionQuery(
        new FindSynchronousMachineQuery(new LoadSynchronousMachineFilter(synchronousMachineId)),
        ResponseTypes.instanceOf(SynchronousMachine.class),
        ResponseTypes.instanceOf(SynchronousMachine.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

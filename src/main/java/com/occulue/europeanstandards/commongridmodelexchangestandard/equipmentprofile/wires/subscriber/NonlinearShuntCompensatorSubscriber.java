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
 * Subscriber for NonlinearShuntCompensator related events. .
 *
 * @author your_name_here
 */
@Component("nonlinearShuntCompensator-subscriber")
public class NonlinearShuntCompensatorSubscriber extends BaseSubscriber {

  public NonlinearShuntCompensatorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<NonlinearShuntCompensator>, NonlinearShuntCompensator>
      nonlinearShuntCompensatorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllNonlinearShuntCompensatorQuery(),
        ResponseTypes.multipleInstancesOf(NonlinearShuntCompensator.class),
        ResponseTypes.instanceOf(NonlinearShuntCompensator.class));
  }

  public SubscriptionQueryResult<NonlinearShuntCompensator, NonlinearShuntCompensator>
      nonlinearShuntCompensatorSubscribe(@DestinationVariable UUID nonlinearShuntCompensatorId) {
    return queryGateway.subscriptionQuery(
        new FindNonlinearShuntCompensatorQuery(
            new LoadNonlinearShuntCompensatorFilter(nonlinearShuntCompensatorId)),
        ResponseTypes.instanceOf(NonlinearShuntCompensator.class),
        ResponseTypes.instanceOf(NonlinearShuntCompensator.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

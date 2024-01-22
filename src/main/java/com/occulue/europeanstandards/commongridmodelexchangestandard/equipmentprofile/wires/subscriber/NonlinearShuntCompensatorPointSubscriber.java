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
 * Subscriber for NonlinearShuntCompensatorPoint related events. .
 *
 * @author your_name_here
 */
@Component("nonlinearShuntCompensatorPoint-subscriber")
public class NonlinearShuntCompensatorPointSubscriber extends BaseSubscriber {

  public NonlinearShuntCompensatorPointSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<NonlinearShuntCompensatorPoint>, NonlinearShuntCompensatorPoint>
      nonlinearShuntCompensatorPointSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllNonlinearShuntCompensatorPointQuery(),
        ResponseTypes.multipleInstancesOf(NonlinearShuntCompensatorPoint.class),
        ResponseTypes.instanceOf(NonlinearShuntCompensatorPoint.class));
  }

  public SubscriptionQueryResult<NonlinearShuntCompensatorPoint, NonlinearShuntCompensatorPoint>
      nonlinearShuntCompensatorPointSubscribe(
          @DestinationVariable UUID nonlinearShuntCompensatorPointId) {
    return queryGateway.subscriptionQuery(
        new FindNonlinearShuntCompensatorPointQuery(
            new LoadNonlinearShuntCompensatorPointFilter(nonlinearShuntCompensatorPointId)),
        ResponseTypes.instanceOf(NonlinearShuntCompensatorPoint.class),
        ResponseTypes.instanceOf(NonlinearShuntCompensatorPoint.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

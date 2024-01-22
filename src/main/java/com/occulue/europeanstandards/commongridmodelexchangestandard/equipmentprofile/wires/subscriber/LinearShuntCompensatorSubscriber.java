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
 * Subscriber for LinearShuntCompensator related events. .
 *
 * @author your_name_here
 */
@Component("linearShuntCompensator-subscriber")
public class LinearShuntCompensatorSubscriber extends BaseSubscriber {

  public LinearShuntCompensatorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<LinearShuntCompensator>, LinearShuntCompensator>
      linearShuntCompensatorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLinearShuntCompensatorQuery(),
        ResponseTypes.multipleInstancesOf(LinearShuntCompensator.class),
        ResponseTypes.instanceOf(LinearShuntCompensator.class));
  }

  public SubscriptionQueryResult<LinearShuntCompensator, LinearShuntCompensator>
      linearShuntCompensatorSubscribe(@DestinationVariable UUID linearShuntCompensatorId) {
    return queryGateway.subscriptionQuery(
        new FindLinearShuntCompensatorQuery(
            new LoadLinearShuntCompensatorFilter(linearShuntCompensatorId)),
        ResponseTypes.instanceOf(LinearShuntCompensator.class),
        ResponseTypes.instanceOf(LinearShuntCompensator.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

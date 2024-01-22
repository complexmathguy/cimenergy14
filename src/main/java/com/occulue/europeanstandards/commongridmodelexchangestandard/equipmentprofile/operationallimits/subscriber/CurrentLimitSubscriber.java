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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.subscriber;

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
 * Subscriber for CurrentLimit related events. .
 *
 * @author your_name_here
 */
@Component("currentLimit-subscriber")
public class CurrentLimitSubscriber extends BaseSubscriber {

  public CurrentLimitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<CurrentLimit>, CurrentLimit> currentLimitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllCurrentLimitQuery(),
        ResponseTypes.multipleInstancesOf(CurrentLimit.class),
        ResponseTypes.instanceOf(CurrentLimit.class));
  }

  public SubscriptionQueryResult<CurrentLimit, CurrentLimit> currentLimitSubscribe(
      @DestinationVariable UUID currentLimitId) {
    return queryGateway.subscriptionQuery(
        new FindCurrentLimitQuery(new LoadCurrentLimitFilter(currentLimitId)),
        ResponseTypes.instanceOf(CurrentLimit.class),
        ResponseTypes.instanceOf(CurrentLimit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.subscriber;

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
 * Subscriber for CurrentFlow related events. .
 *
 * @author your_name_here
 */
@Component("currentFlow-subscriber")
public class CurrentFlowSubscriber extends BaseSubscriber {

  public CurrentFlowSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<CurrentFlow>, CurrentFlow> currentFlowSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllCurrentFlowQuery(),
        ResponseTypes.multipleInstancesOf(CurrentFlow.class),
        ResponseTypes.instanceOf(CurrentFlow.class));
  }

  public SubscriptionQueryResult<CurrentFlow, CurrentFlow> currentFlowSubscribe(
      @DestinationVariable UUID currentFlowId) {
    return queryGateway.subscriptionQuery(
        new FindCurrentFlowQuery(new LoadCurrentFlowFilter(currentFlowId)),
        ResponseTypes.instanceOf(CurrentFlow.class),
        ResponseTypes.instanceOf(CurrentFlow.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

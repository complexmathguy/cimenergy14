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
 * Subscriber for ActivePowerPerCurrentFlow related events. .
 *
 * @author your_name_here
 */
@Component("activePowerPerCurrentFlow-subscriber")
public class ActivePowerPerCurrentFlowSubscriber extends BaseSubscriber {

  public ActivePowerPerCurrentFlowSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ActivePowerPerCurrentFlow>, ActivePowerPerCurrentFlow>
      activePowerPerCurrentFlowSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllActivePowerPerCurrentFlowQuery(),
        ResponseTypes.multipleInstancesOf(ActivePowerPerCurrentFlow.class),
        ResponseTypes.instanceOf(ActivePowerPerCurrentFlow.class));
  }

  public SubscriptionQueryResult<ActivePowerPerCurrentFlow, ActivePowerPerCurrentFlow>
      activePowerPerCurrentFlowSubscribe(@DestinationVariable UUID activePowerPerCurrentFlowId) {
    return queryGateway.subscriptionQuery(
        new FindActivePowerPerCurrentFlowQuery(
            new LoadActivePowerPerCurrentFlowFilter(activePowerPerCurrentFlowId)),
        ResponseTypes.instanceOf(ActivePowerPerCurrentFlow.class),
        ResponseTypes.instanceOf(ActivePowerPerCurrentFlow.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

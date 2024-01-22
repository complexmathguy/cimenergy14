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
 * Subscriber for ActivePowerPerFrequency related events. .
 *
 * @author your_name_here
 */
@Component("activePowerPerFrequency-subscriber")
public class ActivePowerPerFrequencySubscriber extends BaseSubscriber {

  public ActivePowerPerFrequencySubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ActivePowerPerFrequency>, ActivePowerPerFrequency>
      activePowerPerFrequencySubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllActivePowerPerFrequencyQuery(),
        ResponseTypes.multipleInstancesOf(ActivePowerPerFrequency.class),
        ResponseTypes.instanceOf(ActivePowerPerFrequency.class));
  }

  public SubscriptionQueryResult<ActivePowerPerFrequency, ActivePowerPerFrequency>
      activePowerPerFrequencySubscribe(@DestinationVariable UUID activePowerPerFrequencyId) {
    return queryGateway.subscriptionQuery(
        new FindActivePowerPerFrequencyQuery(
            new LoadActivePowerPerFrequencyFilter(activePowerPerFrequencyId)),
        ResponseTypes.instanceOf(ActivePowerPerFrequency.class),
        ResponseTypes.instanceOf(ActivePowerPerFrequency.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

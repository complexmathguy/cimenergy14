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
 * Subscriber for ActivePower related events. .
 *
 * @author your_name_here
 */
@Component("activePower-subscriber")
public class ActivePowerSubscriber extends BaseSubscriber {

  public ActivePowerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ActivePower>, ActivePower> activePowerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllActivePowerQuery(),
        ResponseTypes.multipleInstancesOf(ActivePower.class),
        ResponseTypes.instanceOf(ActivePower.class));
  }

  public SubscriptionQueryResult<ActivePower, ActivePower> activePowerSubscribe(
      @DestinationVariable UUID activePowerId) {
    return queryGateway.subscriptionQuery(
        new FindActivePowerQuery(new LoadActivePowerFilter(activePowerId)),
        ResponseTypes.instanceOf(ActivePower.class),
        ResponseTypes.instanceOf(ActivePower.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

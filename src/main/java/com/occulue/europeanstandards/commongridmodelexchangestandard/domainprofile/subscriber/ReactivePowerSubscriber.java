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
 * Subscriber for ReactivePower related events. .
 *
 * @author your_name_here
 */
@Component("reactivePower-subscriber")
public class ReactivePowerSubscriber extends BaseSubscriber {

  public ReactivePowerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ReactivePower>, ReactivePower> reactivePowerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllReactivePowerQuery(),
        ResponseTypes.multipleInstancesOf(ReactivePower.class),
        ResponseTypes.instanceOf(ReactivePower.class));
  }

  public SubscriptionQueryResult<ReactivePower, ReactivePower> reactivePowerSubscribe(
      @DestinationVariable UUID reactivePowerId) {
    return queryGateway.subscriptionQuery(
        new FindReactivePowerQuery(new LoadReactivePowerFilter(reactivePowerId)),
        ResponseTypes.instanceOf(ReactivePower.class),
        ResponseTypes.instanceOf(ReactivePower.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

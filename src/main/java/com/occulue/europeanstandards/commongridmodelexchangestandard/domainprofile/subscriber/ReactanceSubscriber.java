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
 * Subscriber for Reactance related events. .
 *
 * @author your_name_here
 */
@Component("reactance-subscriber")
public class ReactanceSubscriber extends BaseSubscriber {

  public ReactanceSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Reactance>, Reactance> reactanceSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllReactanceQuery(),
        ResponseTypes.multipleInstancesOf(Reactance.class),
        ResponseTypes.instanceOf(Reactance.class));
  }

  public SubscriptionQueryResult<Reactance, Reactance> reactanceSubscribe(
      @DestinationVariable UUID reactanceId) {
    return queryGateway.subscriptionQuery(
        new FindReactanceQuery(new LoadReactanceFilter(reactanceId)),
        ResponseTypes.instanceOf(Reactance.class),
        ResponseTypes.instanceOf(Reactance.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

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
 * Subscriber for Seconds related events. .
 *
 * @author your_name_here
 */
@Component("seconds-subscriber")
public class SecondsSubscriber extends BaseSubscriber {

  public SecondsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Seconds>, Seconds> secondsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSecondsQuery(),
        ResponseTypes.multipleInstancesOf(Seconds.class),
        ResponseTypes.instanceOf(Seconds.class));
  }

  public SubscriptionQueryResult<Seconds, Seconds> secondsSubscribe(
      @DestinationVariable UUID secondsId) {
    return queryGateway.subscriptionQuery(
        new FindSecondsQuery(new LoadSecondsFilter(secondsId)),
        ResponseTypes.instanceOf(Seconds.class),
        ResponseTypes.instanceOf(Seconds.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

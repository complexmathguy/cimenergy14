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
 * Subscriber for Frequency related events. .
 *
 * @author your_name_here
 */
@Component("frequency-subscriber")
public class FrequencySubscriber extends BaseSubscriber {

  public FrequencySubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Frequency>, Frequency> frequencySubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllFrequencyQuery(),
        ResponseTypes.multipleInstancesOf(Frequency.class),
        ResponseTypes.instanceOf(Frequency.class));
  }

  public SubscriptionQueryResult<Frequency, Frequency> frequencySubscribe(
      @DestinationVariable UUID frequencyId) {
    return queryGateway.subscriptionQuery(
        new FindFrequencyQuery(new LoadFrequencyFilter(frequencyId)),
        ResponseTypes.instanceOf(Frequency.class),
        ResponseTypes.instanceOf(Frequency.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

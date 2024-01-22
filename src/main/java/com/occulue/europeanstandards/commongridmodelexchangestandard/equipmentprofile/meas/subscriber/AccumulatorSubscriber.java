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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.subscriber;

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
 * Subscriber for Accumulator related events. .
 *
 * @author your_name_here
 */
@Component("accumulator-subscriber")
public class AccumulatorSubscriber extends BaseSubscriber {

  public AccumulatorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Accumulator>, Accumulator> accumulatorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAccumulatorQuery(),
        ResponseTypes.multipleInstancesOf(Accumulator.class),
        ResponseTypes.instanceOf(Accumulator.class));
  }

  public SubscriptionQueryResult<Accumulator, Accumulator> accumulatorSubscribe(
      @DestinationVariable UUID accumulatorId) {
    return queryGateway.subscriptionQuery(
        new FindAccumulatorQuery(new LoadAccumulatorFilter(accumulatorId)),
        ResponseTypes.instanceOf(Accumulator.class),
        ResponseTypes.instanceOf(Accumulator.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

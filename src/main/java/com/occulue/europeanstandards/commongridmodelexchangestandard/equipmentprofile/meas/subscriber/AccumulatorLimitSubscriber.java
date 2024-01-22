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
 * Subscriber for AccumulatorLimit related events. .
 *
 * @author your_name_here
 */
@Component("accumulatorLimit-subscriber")
public class AccumulatorLimitSubscriber extends BaseSubscriber {

  public AccumulatorLimitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<AccumulatorLimit>, AccumulatorLimit>
      accumulatorLimitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAccumulatorLimitQuery(),
        ResponseTypes.multipleInstancesOf(AccumulatorLimit.class),
        ResponseTypes.instanceOf(AccumulatorLimit.class));
  }

  public SubscriptionQueryResult<AccumulatorLimit, AccumulatorLimit> accumulatorLimitSubscribe(
      @DestinationVariable UUID accumulatorLimitId) {
    return queryGateway.subscriptionQuery(
        new FindAccumulatorLimitQuery(new LoadAccumulatorLimitFilter(accumulatorLimitId)),
        ResponseTypes.instanceOf(AccumulatorLimit.class),
        ResponseTypes.instanceOf(AccumulatorLimit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

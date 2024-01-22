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
 * Subscriber for AccumulatorLimitSet related events. .
 *
 * @author your_name_here
 */
@Component("accumulatorLimitSet-subscriber")
public class AccumulatorLimitSetSubscriber extends BaseSubscriber {

  public AccumulatorLimitSetSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<AccumulatorLimitSet>, AccumulatorLimitSet>
      accumulatorLimitSetSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAccumulatorLimitSetQuery(),
        ResponseTypes.multipleInstancesOf(AccumulatorLimitSet.class),
        ResponseTypes.instanceOf(AccumulatorLimitSet.class));
  }

  public SubscriptionQueryResult<AccumulatorLimitSet, AccumulatorLimitSet>
      accumulatorLimitSetSubscribe(@DestinationVariable UUID accumulatorLimitSetId) {
    return queryGateway.subscriptionQuery(
        new FindAccumulatorLimitSetQuery(new LoadAccumulatorLimitSetFilter(accumulatorLimitSetId)),
        ResponseTypes.instanceOf(AccumulatorLimitSet.class),
        ResponseTypes.instanceOf(AccumulatorLimitSet.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

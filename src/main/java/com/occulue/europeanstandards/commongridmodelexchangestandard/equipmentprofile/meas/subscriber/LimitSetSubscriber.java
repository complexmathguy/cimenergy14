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
 * Subscriber for LimitSet related events. .
 *
 * @author your_name_here
 */
@Component("limitSet-subscriber")
public class LimitSetSubscriber extends BaseSubscriber {

  public LimitSetSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<LimitSet>, LimitSet> limitSetSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLimitSetQuery(),
        ResponseTypes.multipleInstancesOf(LimitSet.class),
        ResponseTypes.instanceOf(LimitSet.class));
  }

  public SubscriptionQueryResult<LimitSet, LimitSet> limitSetSubscribe(
      @DestinationVariable UUID limitSetId) {
    return queryGateway.subscriptionQuery(
        new FindLimitSetQuery(new LoadLimitSetFilter(limitSetId)),
        ResponseTypes.instanceOf(LimitSet.class),
        ResponseTypes.instanceOf(LimitSet.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

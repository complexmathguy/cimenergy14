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
 * Subscriber for AnalogLimitSet related events. .
 *
 * @author your_name_here
 */
@Component("analogLimitSet-subscriber")
public class AnalogLimitSetSubscriber extends BaseSubscriber {

  public AnalogLimitSetSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<AnalogLimitSet>, AnalogLimitSet> analogLimitSetSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllAnalogLimitSetQuery(),
        ResponseTypes.multipleInstancesOf(AnalogLimitSet.class),
        ResponseTypes.instanceOf(AnalogLimitSet.class));
  }

  public SubscriptionQueryResult<AnalogLimitSet, AnalogLimitSet> analogLimitSetSubscribe(
      @DestinationVariable UUID analogLimitSetId) {
    return queryGateway.subscriptionQuery(
        new FindAnalogLimitSetQuery(new LoadAnalogLimitSetFilter(analogLimitSetId)),
        ResponseTypes.instanceOf(AnalogLimitSet.class),
        ResponseTypes.instanceOf(AnalogLimitSet.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

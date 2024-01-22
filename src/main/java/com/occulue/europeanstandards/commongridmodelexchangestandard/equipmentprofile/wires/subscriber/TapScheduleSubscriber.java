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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for TapSchedule related events. .
 *
 * @author your_name_here
 */
@Component("tapSchedule-subscriber")
public class TapScheduleSubscriber extends BaseSubscriber {

  public TapScheduleSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TapSchedule>, TapSchedule> tapScheduleSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTapScheduleQuery(),
        ResponseTypes.multipleInstancesOf(TapSchedule.class),
        ResponseTypes.instanceOf(TapSchedule.class));
  }

  public SubscriptionQueryResult<TapSchedule, TapSchedule> tapScheduleSubscribe(
      @DestinationVariable UUID tapScheduleId) {
    return queryGateway.subscriptionQuery(
        new FindTapScheduleQuery(new LoadTapScheduleFilter(tapScheduleId)),
        ResponseTypes.instanceOf(TapSchedule.class),
        ResponseTypes.instanceOf(TapSchedule.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

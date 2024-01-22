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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.subscriber;

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
 * Subscriber for BasicIntervalSchedule related events. .
 *
 * @author your_name_here
 */
@Component("basicIntervalSchedule-subscriber")
public class BasicIntervalScheduleSubscriber extends BaseSubscriber {

  public BasicIntervalScheduleSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<BasicIntervalSchedule>, BasicIntervalSchedule>
      basicIntervalScheduleSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllBasicIntervalScheduleQuery(),
        ResponseTypes.multipleInstancesOf(BasicIntervalSchedule.class),
        ResponseTypes.instanceOf(BasicIntervalSchedule.class));
  }

  public SubscriptionQueryResult<BasicIntervalSchedule, BasicIntervalSchedule>
      basicIntervalScheduleSubscribe(@DestinationVariable UUID basicIntervalScheduleId) {
    return queryGateway.subscriptionQuery(
        new FindBasicIntervalScheduleQuery(
            new LoadBasicIntervalScheduleFilter(basicIntervalScheduleId)),
        ResponseTypes.instanceOf(BasicIntervalSchedule.class),
        ResponseTypes.instanceOf(BasicIntervalSchedule.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

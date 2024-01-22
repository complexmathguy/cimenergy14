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
 * Subscriber for RegularIntervalSchedule related events. .
 *
 * @author your_name_here
 */
@Component("regularIntervalSchedule-subscriber")
public class RegularIntervalScheduleSubscriber extends BaseSubscriber {

  public RegularIntervalScheduleSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RegularIntervalSchedule>, RegularIntervalSchedule>
      regularIntervalScheduleSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRegularIntervalScheduleQuery(),
        ResponseTypes.multipleInstancesOf(RegularIntervalSchedule.class),
        ResponseTypes.instanceOf(RegularIntervalSchedule.class));
  }

  public SubscriptionQueryResult<RegularIntervalSchedule, RegularIntervalSchedule>
      regularIntervalScheduleSubscribe(@DestinationVariable UUID regularIntervalScheduleId) {
    return queryGateway.subscriptionQuery(
        new FindRegularIntervalScheduleQuery(
            new LoadRegularIntervalScheduleFilter(regularIntervalScheduleId)),
        ResponseTypes.instanceOf(RegularIntervalSchedule.class),
        ResponseTypes.instanceOf(RegularIntervalSchedule.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

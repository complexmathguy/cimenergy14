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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.subscriber;

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
 * Subscriber for SeasonDayTypeSchedule related events. .
 *
 * @author your_name_here
 */
@Component("seasonDayTypeSchedule-subscriber")
public class SeasonDayTypeScheduleSubscriber extends BaseSubscriber {

  public SeasonDayTypeScheduleSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SeasonDayTypeSchedule>, SeasonDayTypeSchedule>
      seasonDayTypeScheduleSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSeasonDayTypeScheduleQuery(),
        ResponseTypes.multipleInstancesOf(SeasonDayTypeSchedule.class),
        ResponseTypes.instanceOf(SeasonDayTypeSchedule.class));
  }

  public SubscriptionQueryResult<SeasonDayTypeSchedule, SeasonDayTypeSchedule>
      seasonDayTypeScheduleSubscribe(@DestinationVariable UUID seasonDayTypeScheduleId) {
    return queryGateway.subscriptionQuery(
        new FindSeasonDayTypeScheduleQuery(
            new LoadSeasonDayTypeScheduleFilter(seasonDayTypeScheduleId)),
        ResponseTypes.instanceOf(SeasonDayTypeSchedule.class),
        ResponseTypes.instanceOf(SeasonDayTypeSchedule.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

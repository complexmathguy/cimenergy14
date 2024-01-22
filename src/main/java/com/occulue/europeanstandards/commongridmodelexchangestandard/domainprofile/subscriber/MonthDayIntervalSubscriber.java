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
 * Subscriber for MonthDayInterval related events. .
 *
 * @author your_name_here
 */
@Component("monthDayInterval-subscriber")
public class MonthDayIntervalSubscriber extends BaseSubscriber {

  public MonthDayIntervalSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<MonthDayInterval>, MonthDayInterval>
      monthDayIntervalSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllMonthDayIntervalQuery(),
        ResponseTypes.multipleInstancesOf(MonthDayInterval.class),
        ResponseTypes.instanceOf(MonthDayInterval.class));
  }

  public SubscriptionQueryResult<MonthDayInterval, MonthDayInterval> monthDayIntervalSubscribe(
      @DestinationVariable UUID monthDayIntervalId) {
    return queryGateway.subscriptionQuery(
        new FindMonthDayIntervalQuery(new LoadMonthDayIntervalFilter(monthDayIntervalId)),
        ResponseTypes.instanceOf(MonthDayInterval.class),
        ResponseTypes.instanceOf(MonthDayInterval.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

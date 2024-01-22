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
 * Subscriber for DateTime related events. .
 *
 * @author your_name_here
 */
@Component("dateTime-subscriber")
public class DateTimeSubscriber extends BaseSubscriber {

  public DateTimeSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DateTime>, DateTime> dateTimeSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDateTimeQuery(),
        ResponseTypes.multipleInstancesOf(DateTime.class),
        ResponseTypes.instanceOf(DateTime.class));
  }

  public SubscriptionQueryResult<DateTime, DateTime> dateTimeSubscribe(
      @DestinationVariable UUID dateTimeId) {
    return queryGateway.subscriptionQuery(
        new FindDateTimeQuery(new LoadDateTimeFilter(dateTimeId)),
        ResponseTypes.instanceOf(DateTime.class),
        ResponseTypes.instanceOf(DateTime.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

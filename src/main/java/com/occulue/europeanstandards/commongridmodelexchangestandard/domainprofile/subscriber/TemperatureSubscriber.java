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
 * Subscriber for Temperature related events. .
 *
 * @author your_name_here
 */
@Component("temperature-subscriber")
public class TemperatureSubscriber extends BaseSubscriber {

  public TemperatureSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Temperature>, Temperature> temperatureSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTemperatureQuery(),
        ResponseTypes.multipleInstancesOf(Temperature.class),
        ResponseTypes.instanceOf(Temperature.class));
  }

  public SubscriptionQueryResult<Temperature, Temperature> temperatureSubscribe(
      @DestinationVariable UUID temperatureId) {
    return queryGateway.subscriptionQuery(
        new FindTemperatureQuery(new LoadTemperatureFilter(temperatureId)),
        ResponseTypes.instanceOf(Temperature.class),
        ResponseTypes.instanceOf(Temperature.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

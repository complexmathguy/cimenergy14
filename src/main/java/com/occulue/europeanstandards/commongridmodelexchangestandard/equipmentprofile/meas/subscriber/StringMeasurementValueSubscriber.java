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
 * Subscriber for StringMeasurementValue related events. .
 *
 * @author your_name_here
 */
@Component("stringMeasurementValue-subscriber")
public class StringMeasurementValueSubscriber extends BaseSubscriber {

  public StringMeasurementValueSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<StringMeasurementValue>, StringMeasurementValue>
      stringMeasurementValueSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllStringMeasurementValueQuery(),
        ResponseTypes.multipleInstancesOf(StringMeasurementValue.class),
        ResponseTypes.instanceOf(StringMeasurementValue.class));
  }

  public SubscriptionQueryResult<StringMeasurementValue, StringMeasurementValue>
      stringMeasurementValueSubscribe(@DestinationVariable UUID stringMeasurementValueId) {
    return queryGateway.subscriptionQuery(
        new FindStringMeasurementValueQuery(
            new LoadStringMeasurementValueFilter(stringMeasurementValueId)),
        ResponseTypes.instanceOf(StringMeasurementValue.class),
        ResponseTypes.instanceOf(StringMeasurementValue.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

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
 * Subscriber for StringMeasurement related events. .
 *
 * @author your_name_here
 */
@Component("stringMeasurement-subscriber")
public class StringMeasurementSubscriber extends BaseSubscriber {

  public StringMeasurementSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<StringMeasurement>, StringMeasurement>
      stringMeasurementSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllStringMeasurementQuery(),
        ResponseTypes.multipleInstancesOf(StringMeasurement.class),
        ResponseTypes.instanceOf(StringMeasurement.class));
  }

  public SubscriptionQueryResult<StringMeasurement, StringMeasurement> stringMeasurementSubscribe(
      @DestinationVariable UUID stringMeasurementId) {
    return queryGateway.subscriptionQuery(
        new FindStringMeasurementQuery(new LoadStringMeasurementFilter(stringMeasurementId)),
        ResponseTypes.instanceOf(StringMeasurement.class),
        ResponseTypes.instanceOf(StringMeasurement.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

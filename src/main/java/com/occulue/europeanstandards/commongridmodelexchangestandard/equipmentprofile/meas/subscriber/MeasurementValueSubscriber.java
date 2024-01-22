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
 * Subscriber for MeasurementValue related events. .
 *
 * @author your_name_here
 */
@Component("measurementValue-subscriber")
public class MeasurementValueSubscriber extends BaseSubscriber {

  public MeasurementValueSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<MeasurementValue>, MeasurementValue>
      measurementValueSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllMeasurementValueQuery(),
        ResponseTypes.multipleInstancesOf(MeasurementValue.class),
        ResponseTypes.instanceOf(MeasurementValue.class));
  }

  public SubscriptionQueryResult<MeasurementValue, MeasurementValue> measurementValueSubscribe(
      @DestinationVariable UUID measurementValueId) {
    return queryGateway.subscriptionQuery(
        new FindMeasurementValueQuery(new LoadMeasurementValueFilter(measurementValueId)),
        ResponseTypes.instanceOf(MeasurementValue.class),
        ResponseTypes.instanceOf(MeasurementValue.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}

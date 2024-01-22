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
 * Subscriber for Measurement related events. .
 *
 * @author your_name_here
 */
@Component("measurement-subscriber")
public class MeasurementSubscriber extends BaseSubscriber {

  public MeasurementSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Measurement>, Measurement> measurementSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllMeasurementQuery(),
        ResponseTypes.multipleInstancesOf(Measurement.class),
        ResponseTypes.instanceOf(Measurement.class));
  }

  public SubscriptionQueryResult<Measurement, Measurement> measurementSubscribe(
      @DestinationVariable UUID measurementId) {
    return queryGateway.subscriptionQuery(
        new FindMeasurementQuery(new LoadMeasurementFilter(measurementId)),
        ResponseTypes.instanceOf(Measurement.class),
        ResponseTypes.instanceOf(Measurement.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
